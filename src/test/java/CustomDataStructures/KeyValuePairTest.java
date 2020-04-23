package CustomDataStructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class KeyValuePairTest {
    KeyValuePair testPair1, testPair2, testpair3;

    @Before
    public void initialize() {
        testPair1 = new KeyValuePair("gorilla", new Integer(123), null);
        testPair2 = new KeyValuePair("apina", new Date(), null);
        testpair3 = new KeyValuePair(new Character('a'), new String("a"), null);
    }

    @Test
    public void initsCorrectlyWithStringKeys() {
        System.out.println(testPair1.toString());
        assertEquals("gorilla", testPair1.getKey());
        assertEquals("123", testPair1.getValue().toString());
        assertNull(testPair1.getNext());
        System.out.println(testPair2.toString());
        assertTrue(testPair2.getValue() instanceof Date);
    }

    @Test
    public void generatesHashValueCorrectly() {
        KeyValuePair<Object, Integer> testObject = new KeyValuePair("apina",123, null);
        int hashValue = testObject.generateHashValue();
        System.out.println(testObject.toString());
        assertEquals(277325, hashValue);
    }

    @Test
    public void initsCorrectlyWithCharacterKey() {
        assertEquals('a', testpair3.getKey());
        assertEquals("a", testpair3.getValue().toString());
        assertNull(testpair3.getNext());
        assertTrue(testpair3.getKey() instanceof Character);
        assertTrue(testpair3.getValue() instanceof String);
    }

    @Test
    public void handlesChainingCorrectly() {
        assertNull(testPair1.getNext());
        testPair1.setNext(testPair2);
        assertNotNull(testPair1.getNext());
        assertEquals(testPair2, testPair1.getNext());
    }
}