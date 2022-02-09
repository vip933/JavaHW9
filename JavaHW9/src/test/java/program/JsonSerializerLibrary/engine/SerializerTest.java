package program.JsonSerializerLibrary.engine;

import org.junit.jupiter.api.Test;
import program.serializableObjectsExamples.*;

import static org.junit.jupiter.api.Assertions.*;

class SerializerTest {

    private final static String FERRARI_JSON =
            "{\n" +
                    "    \"modelName\": \"F12 Berlinetta\",\n" +
                    "    \"horsePowers\": \"660\",\n" +
                    "    \"manufacturer\": \"Ferrari\",\n" +
                    "},";
    private final static String ZAPPY_JSON =
            "{\n" +
                    "    \"firstName\": \"Maxim\",\n" +
                    "    \"age\": \"19\",\n" +
                    "    \"Name\": \"Zappy\",\n" +
                    "},";
    private final static String LAMBORGHINI_JSON =
            "{\n" +
                    "    \"modelName\": \"Urus\",\n" +
                    "    \"horsePowers\": \"850\",\n" +
                    "    \"streamliningCoefficient\": \"0.27\",\n" +
                    "    \"manufacturer\": \"Lamborghini\",\n" +
                    "},";
    private final static Serializer serializer = new Serializer();

    @Test
    void convertObjectToJsonShouldNotThrowOnValidData() throws IllegalAccessException {

        Car car = new Car("Ferrari", "F12 Berlinetta", 660);
        assertEquals(FERRARI_JSON, serializer.convertObjectToJson(car));

        Person person = new Person("Maxim", "Zappy", "19", "70");
        assertEquals(ZAPPY_JSON, serializer.convertObjectToJson(person));

        SportCar sportCar = new SportCar("Lamborghini", "Urus", 850, 0.27);
        assertEquals(LAMBORGHINI_JSON, serializer.convertObjectToJson(sportCar));
    }

    @Test
    void convertObjectToJsonShouldThrowOnNotSerializable() {
        NotSerializableClass notSerializableClass = new NotSerializableClass(1);
        assertThrows(UnsupportedOperationException.class, () -> serializer.convertObjectToJson(notSerializableClass));
    }

    @Test
    void convertObjectToJsonShouldChangeNullVariableToStringIfNoIgnoreNullAnnotation() throws IllegalAccessException {
        Person person = new Person("Aleksandr", "Kuchuk", null, "15");
        final String kuchukJson =
                "{\n" +
                        "    \"firstName\": \"Aleksandr\",\n" +
                        "    \"age\": \"null\",\n" +
                        "    \"Name\": \"Kuchuk\",\n" +
                        "},";
        assertEquals(kuchukJson, serializer.convertObjectToJson(person));
    }

    @Test
    void convertObjectsToJsonShouldNotShowVariableIfIgnoreNullAnnotation() throws IllegalAccessException {
        Car car = new Car("AB", null, 100);
        final String carJson =
                "{\n" +
                        "    \"horsePowers\": \"100\",\n" +
                        "    \"manufacturer\": \"AB\",\n" +
                        "},";
        assertEquals(carJson, serializer.convertObjectToJson(car));
    }
}