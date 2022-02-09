package program.JsonSerializerLibrary.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeserializerTest {
    @Test
    void constructorCheck() {
        assertThrows(UnsupportedOperationException.class, Deserializer::new);
    }
}