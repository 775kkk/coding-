package VYZ.ErmakovJava.kyrstwosemtwo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import VYZ.ErmakovJava.kyrstwosemtwo.annotations.ToString;
import VYZ.ErmakovJava.kyrstwosemtwo.annotations.Two;
import VYZ.ErmakovJava.kyrstwosemtwo.annotations.Validate;

@Validate({ObjectCollector.class})
@Two(first = "entity", second = 2)
public abstract class Entity {

    private static boolean toStringInclude(Field field, ToString.Mode classMode) {
        ToString fieldAnnotation = field.getAnnotation(ToString.class);
        if (fieldAnnotation != null) {
            return fieldAnnotation.value() == ToString.Mode.YES;
        }
        return classMode == ToString.Mode.YES;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + "{";
        boolean first = true;
        Class<?> current = getClass();

        while (current != null && current != Object.class && current != Entity.class) {
            ToString.Mode classMode = current.isAnnotationPresent(ToString.class)
                    ? current.getAnnotation(ToString.class).value()
                    : ToString.Mode.YES;

            for (Field field : current.getDeclaredFields()) {
                if (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                if (!toStringInclude(field, classMode)) {
                    continue;
                }
                try {
                    field.setAccessible(true);
                    if (!first) {
                        result += ", ";
                    }
                    result += field.getName() + "=" + String.valueOf(field.get(this));
                    first = false;
                } catch (IllegalAccessException e) {
                    if (!first) {
                        result += ", ";
                    }
                    result += field.getName() + "=<inaccessible>";
                    first = false;
                }
            }
            current = current.getSuperclass();
        }
        result += "}";
        return result;
    }
}
