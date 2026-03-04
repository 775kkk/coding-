package VYZ.ErmakovJava.kyrstwosemtwo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.line.Line;
import VYZ.ErmakovJava.kyrstwosemtwo.annotations.ValidateTool;

public class Reflection {
    
    private Reflection() {}

    // 8.1.1
    public static List<Field> collectFields(Class<?> clz){// все поля класса
        if (clz==Object.class) return new ArrayList<>();
        List<Field> fields = collectFields(clz.getSuperclass());
        fields.addAll(Arrays.asList(clz.getDeclaredFields()));
        return fields;
    }
    // 8.1.2
    public static void lineConnector(Line lineOne, Line lineTwo) {
        try {
            Field endTochka = Line.class.getDeclaredField("tochkaB");   // конец первой
            Field startTochka = Line.class.getDeclaredField("tochkaA"); // начало второй
            endTochka.setAccessible(true);
            startTochka.setAccessible(true);
            Object endPoint = endTochka.get(lineOne);
            startTochka.set(lineTwo, endPoint);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // 8.1.4
    public static void validate(Object item, Class<?> kit) {
        if (item == null)throw new IllegalArgumentException("item == null");
        if (kit == null) throw new IllegalArgumentException("kit == null");

        boolean foundAny = false;
        // List<Method> methods = в стриму все нижнее охото
        for (Method method : kit.getDeclaredMethods()) {
            
            if (!method.isAnnotationPresent(ValidateTool.class)) {
                continue;
            }
                
            Class<?> parametsType = method.getParameterTypes()[0];
            if (!parametsType.isAssignableFrom(item.getClass())) {// принимает
                continue;
            }
            foundAny = true;

            try {
                method.setAccessible(true);
                method.invoke(null, item);

            } catch (InvocationTargetException e) {//искл из кита
                Throwable cause = e.getCause();
                throw new IllegalStateException(
                    "validate failed " + kit.getSimpleName() + "," + method.getName(),
                    cause
                );
            } catch (IllegalAccessException e) {
                throw new RuntimeException(
                    "cant access validator met: " + method.getName(), e
                );
            }
            if (!foundAny) {
                throw new IllegalArgumentException(
                    "methkods not found " + kit.getName()
                );
            }
            
        }
    }



}
