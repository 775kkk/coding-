package VYZ.ErmakovJava.kyrstwosemtwo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import VYZ.ErmakovJava.kyrstwosemtwo.annotations.Invoke;
import VYZ.ErmakovJava.kyrstwosemtwo.exceptions.NoEmptyConstructorException;

public class ObjectCollector {
    
    private static String getMethodName(Method method) {
        String annotationMethodName = method.getAnnotation(Invoke.class).value();
        if(!annotationMethodName.isBlank()){
            return annotationMethodName;
        }
        return method.getName();
    }

    private static Object methodInvoke(Method method, Object object) {
        try{
            return method.invoke(object);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static Object objectCreator(Class<?> clz) {
        try{
            Constructor<?> constructor = clz.getConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch(NoSuchMethodException e){
            throw new NoEmptyConstructorException();
        } catch(Exception e){
            throw new RuntimeException();
        }
    }

    // public static Map<String, Object> collect(Class<?> clz) {
    //     Object target = objectCreator(clz);

    //     return Arrays.stream(clz.getDeclaredMethods())
    //         .filter(method -> method.isAnnotationPresent(Invoke.class))
    //         .filter(method -> method.getParameterCount() == 0)
    //         .filter(method -> !method.getReturnType().equals(void.class))
    //         .peek(method -> method.setAccessible(true))
    //         .collect(Collectors.toMap(
    //             method -> getMethodName(method),
    //             method -> methodInvoke(method, target)
    //         ));
    // }
    public static Map<String, Object> collect(Class<?>... clzs) {
        return Arrays.stream(clzs)
            .parallel()
            .flatMap(clz -> {// вытягиваем в стримы
                Object target = objectCreator(clz);
                return Arrays.stream(clz.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(Invoke.class))
                    .filter(method -> method.getParameterCount() == 0)
                    .filter(method -> method.getReturnType() != void.class)
                    .peek(method -> method.setAccessible(true))
                    .map(method -> Map.entry(// в мапу
                        getMethodName(method),
                        methodInvoke(method, target)
                    ));
            })
            .collect(Collectors.toMap(// коллектим все entry в одну
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldV, newV) -> newV//дубли
            ));
    }

}
