package VYZ.ErmakovJava.kyrstwosemtwo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class Entity {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("{");
        boolean first = true;
        Class<?> current = getClass();

        while (current != null && current != Object.class && current != Entity.class) {
            for (Field field : current.getDeclaredFields()) {
                if (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                try {
                    field.setAccessible(true);
                    if (!first) {
                        sb.append(", ");
                    }
                    sb.append(field.getName()).append("=").append(String.valueOf(field.get(this)));
                    first = false;
                } catch (IllegalAccessException e) {
                    if (!first) {
                        sb.append(", ");
                    }
                    sb.append(field.getName()).append("=<inaccessible>");
                    first = false;
                }
            }
            current = current.getSuperclass();
        }
        sb.append("}");
        return sb.toString();
    }
}
