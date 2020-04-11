package CustomDataStructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringHasherTest {

    @Test
    public void generatesHashValueCorrectly() {
        StringHasher<Object> testHasher = new StringHasher<>();
        int hashValue = testHasher.generateHashValue("apina");
        assertEquals(2893, hashValue);
    }

}