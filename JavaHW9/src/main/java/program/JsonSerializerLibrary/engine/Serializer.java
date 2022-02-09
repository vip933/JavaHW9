package program.JsonSerializerLibrary.engine;

import program.JsonSerializerLibrary.annotations.*;

import java.lang.reflect.Field;
import java.util.*;

public final class Serializer {
    public String convertObjectToJson(Object object) throws UnsupportedOperationException, IllegalAccessException {
        checkAvailableSerialization(object);
        return serializeToJson(object);
    }

    private void checkAvailableSerialization(Object object) throws UnsupportedOperationException, IllegalArgumentException {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("Object is null!");
        }

        Class<?> classOfObject = object.getClass();
        if (!classOfObject.isAnnotationPresent(JsonSerializable.class)) {
            throw new UnsupportedOperationException("The class "
                    + classOfObject.getSimpleName()
                    + " cannot be serialized!"
            );
        }
    }

    private String serializeToJson(Object object) throws IllegalAccessException {
        Map<String, String> elementsMap = new HashMap<>();
        List<Field> fields = new ArrayList<>();

        Class<?> currentClass = object.getClass();
        boolean isNullIgnoringPresent = object.getClass().isAnnotationPresent(IgnoreNull.class);
        while (!Objects.isNull(currentClass)) {
            fields.addAll(Arrays.stream(currentClass.getDeclaredFields()).toList());
            currentClass = currentClass.getSuperclass();
        }

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                var obj = field.get(object);
                if (Objects.isNull(obj)) {
                    if (!isNullIgnoringPresent) {
                        elementsMap.put(getFieldName(field), "null");
                    }
                } else {
                    elementsMap.put(getFieldName(field), obj.toString());
                }
            }
            field.setAccessible(false);
        }

        StringBuilder answer = new StringBuilder("{\n");
        for (var element : elementsMap.entrySet()) {
            answer.append(String.format("    \"%s\": \"%s\",\n", element.getKey(), element.getValue()));
        }
        answer.append("},");
        return answer.toString();
    }

    private String getFieldName(Field field) {
        String name = field.getAnnotation(JsonElement.class).name();
        return name.isEmpty() ? field.getName() : name;
    }
}
