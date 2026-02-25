package VYZ.ErmakovJava.kyrstwosemtwo;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ObjectReader<T> {

    private final Path filePath;
    private final Class<T> type;

    public ObjectReader(String fileName, Class<T> type) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("file Name is blank");
        }
        if (type == null) {
            throw new IllegalArgumentException("type = null");
        }

        this.filePath = Path.of(fileName);
        this.type = type;
    }

    public List<T> read() {
        List<String> lines;
        try {
            lines = Files.exists(filePath)
                ? Files.readAllLines(filePath, StandardCharsets.UTF_8)
                : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + filePath, e);
        }

        List<T> result = new ArrayList<>();
        T current = null;

        for (String line : lines) {
            if (line.isBlank()) {
                if (current != null) {
                    result.add(current);
                    current = null;
                }
                continue;
            }

            if (current == null) {
                current = createEmpty();
            }

            int eq = line.indexOf('=');
            if (eq < 0) {
                throw new IllegalStateException("Bad line: " + line);
            }

            String key = line.substring(0, eq);
            String rawValue = line.substring(eq + 1);

            Field field = findFieldByKey(key);
            if (field == null) {
                throw new IllegalStateException("Field not found for key: " + key);
            }

            if (skipField(field)) {
                continue;
            }

            field.setAccessible(true);
            Object parsed = parseValue(rawValue, field.getType());

            try {
                field.set(current, parsed);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot write field " + field.getName(), e);
            }
        }

        if (current != null) {
            result.add(current);
        }

        return result;
    }

    private T createEmpty() {
        try {
            Constructor<T> c = type.getDeclaredConstructor();
            c.setAccessible(true);
            return c.newInstance();
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("No empty constructor in " + type.getName(), e);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Cannot create " + type.getName(), e);
        }
    }

    private Field findFieldByKey(String key) {
        return Reflection.collectFields(type).stream()
            .filter(field -> {
                String fieldKey = field.getDeclaringClass().getSimpleName() + "." + field.getName();
                return fieldKey.equals(key);
            })
            .findFirst()
            .orElse(null);
    }

    private static boolean skipField(Field field) {
        return field.isSynthetic()
            || Modifier.isStatic(field.getModifiers())
            || Modifier.isTransient(field.getModifiers());
    }

    private static Object parseValue(String rawValue, Class<?> fieldType) {
        if ("@null".equals(rawValue)) {
            if (fieldType.isPrimitive()) {
                throw new IllegalStateException("primitive field cannot be null");
            }
            return null;
        }

        if (fieldType == String.class) {
            return rawValue;
        }
        if (fieldType == int.class || fieldType == Integer.class) {
            return Integer.parseInt(rawValue);
        }
        if (fieldType == long.class || fieldType == Long.class) {
            return Long.parseLong(rawValue);
        }
        if (fieldType == double.class || fieldType == Double.class) {
            return Double.parseDouble(rawValue);
        }
        if (fieldType == float.class || fieldType == Float.class) {
            return Float.parseFloat(rawValue);
        }
        if (fieldType == boolean.class || fieldType == Boolean.class) {
            return Boolean.parseBoolean(rawValue);
        }

        throw new IllegalArgumentException("Unsupported field type: " + fieldType.getName());
    }
}
