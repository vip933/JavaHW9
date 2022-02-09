package program.JsonSerializerLibrary.engine;

public class Deserializer {
    public Deserializer() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Deserialization not implemented!");
    }

    public Object convertJsonToObject(String json, Class<?> clazz) {
        checkAvailableDeserialization(json, clazz);
        return deserializeFromJson(json, clazz);
    }

    private void checkAvailableDeserialization(String json, Class<?> clazz) {
        throw new UnsupportedOperationException();
    }

    private Object deserializeFromJson(String json, Class<?> clazz) {
        throw new UnsupportedOperationException();
    }
}
