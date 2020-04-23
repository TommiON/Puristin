package CustomDataStructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HasherTest {

    Hasher hasher;

    @Before
    public void initialize() {
        hasher = new Hasher();
    }

    @Test
    public void initialisesCorrectly() {
        assertEquals(0, hasher.size());
    }

    @Test
    public void putsAndGetsCorrectlyWithSingleEntry() {
        hasher.put("apina", new String("123"));
        assertEquals(1, hasher.size());
        Object value = hasher.get("apina");
        assertEquals("123", value.toString());
        assertTrue(value instanceof String);
    }

    @Test
    public void putsAndGetsCorrectlyWithMultipleEntries() {
        hasher.put("gorilla", new String("666"));
        hasher.put("apina", new String("123"));
        assertEquals(2, hasher.size());
        Object value = hasher.get("apina");
        assertEquals("123", value.toString());
        assertTrue(value instanceof String);
    }

    @Test
    public void updatesValueCorrectly() {
        hasher.put("apina", new String("123"));
        assertEquals(1, hasher.size());
        Object value = hasher.get("apina");
        assertEquals("123", value.toString());
        hasher.put("apina", new String("456"));
        assertEquals(1, hasher.size());
        value = hasher.get("apina");
        assertEquals("456", value.toString());
    }

    @Test
    public void handlesNonExistentEntryCorrectly() {
        Object value = hasher.get("apina");
        assertNull(value);
    }

    @Test
    public void worksCorrectlyWithCharacterKeys() {
        hasher.put('a', new String("123"));
        hasher.put('b', new String("456"));
        assertEquals("123", hasher.get('a'));
        assertEquals("456", hasher.get('b'));
        hasher.put('a', new String("789"));
        assertEquals("789", hasher.get('a'));
    }

    @Test
    public void testGettingEntrySet() {
        hasher.put("a", new String("jotain"));
        hasher.put("b", new String("jotain muuta"));
        hasher.put("xxx", new String("vielä jotain muuta"));
        hasher.put("c", new String("testataan!"));
        hasher.put("pidempi avain", new String("test!"));
        ResizingList list = hasher.getEntrySet();
        assertEquals(5, list.size());
        System.out.println(list.toString());
    }
}