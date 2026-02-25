package VYZ.ErmakovJava.kyrstwosemtwo;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ObjectWriter {

    private final Path filePath;

    public ObjectWriter(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("fileName is blank");
        }
        this.filePath = Path.of(fileName);
    }

    public void write(List<?> items) {
        if (items == null) {
            throw new IllegalArgumentException("items == null");
        }

        List<String> lines = new ArrayList<>();

        for (Object item : items) {
            if (item == null) {
                throw new IllegalArgumentException("null item");
            }

            List<Field> fields = Reflection.collectFields(item.getClass()).stream()
                .filter(x -> !x.isSynthetic()
                    && !Modifier.isStatic(x.getModifiers())
                    && !Modifier.isTransient(x.getModifiers()))
                .toList();
            fields.forEach(f -> f.setAccessible(true));

            for (Field field : fields) {
                Object value;
                try {
                    value = field.get(item);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Cannot read field " + field.getName(), e);
                }

                String key = field.getDeclaringClass().getSimpleName() + "." + field.getName();
                lines.add(key + "=" + stringfy(value));
            }

            // енд
            lines.add("");
        }

        try {
            Files.write(filePath, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("cant write file " + filePath, e);
        }
    }

    private static String stringfy(Object value) {
        return value == null ? "@null" : String.valueOf(value);
    }
}
