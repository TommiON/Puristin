package CustomDataStructures;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class HashCalculatorTest {

    @Test
    public void generatesHashValueCorrectlyForString() {
        int hashValue = HashCalculator.generateHashValueFromKey("apina");
        assertEquals(277325, hashValue);
    }

    @Test
    public void generatesHashValueCorrectlyForChar() {
        int hashValue = HashCalculator.generateHashValueFromKey('a');
        assertEquals(97, hashValue);
    }

    @Test
    public void generatesHashValueCorrectlyForUnknownType() {
        int hashValue = HashCalculator.generateHashValueFromKey(new Date());
        assertEquals(-1, hashValue);
    }
}