package CustomDataStructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ResizingListTest {
    private ResizingList list;

    @Before
    public void init() {
        list = new ResizingList();
    }

    @Test
    public void initsCorrectly() {
        assertEquals(0, list.size());
        assertNull(list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void testSimpleAddingAndGettingWithStrings() {
        list.add("a");
        assertEquals(1, list.size());
        list.add("b");
        list.add("pidempi merkkijono");
        assertEquals(3, list.size());
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        System.out.println(list.toString());
    }

    @Test
    public void testGrowing() {
        for (int i = 0; i < 1000; i++) {
            list.add(String.valueOf(i));
        }
        assertEquals(1000, list.size());
    }

    @Test
    public void testSimpleAddingWithDateObjects() {
        list.add(new Date());
        list.add(new Date());
        assertEquals(2, list.size());
        System.out.println(list.toString());
    }

    @Test
    public void testAddingtoIndex() {
        list.add("a");
        list.add("b");
        assertEquals(2, list.size());
        assertEquals("a", list.get(0));
        System.out.println(list.toString());
        list.add(0, "c");
        assertEquals(3, list.size());
        assertEquals("c", list.get(0));
        System.out.println(list.toString());
    }

    @Test
    public void testRemoving() {
        list.add("a");
        list.add("b");
        list.add("c");
        assertEquals(3, list.size());
        assertEquals("b", list.get(1));
        System.out.println(list.toString());
        Object result = list.remove(1);
        assertEquals("b", result.toString());
        assertEquals(2, list.size());
        assertEquals("c", list.get(1));
        System.out.println(list.toString());
    }

    @Test
    public void testGettingOutOfBounds() {
        list.add("a");
        assertEquals("a", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void testAddingOutOfBounds() {
        list.add(100, "a");
        assertNull(list.get(100));
    }

    @Test
    public void testRemovingOutOfBounds() {
        assertNull(list.remove(100));
    }

    @Test
    public void testIterating() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("x");
        for (Object node : list) {
            System.out.println(node.toString());
        }
        System.out.println("---");
        list.remove(2);
        list.remove(2);
        list.remove(2);
        for (Object node : list) {
            System.out.println(node.toString());
        }
    }

    @Test
    public void testIterating2() {
        list.add(new Date());
        list.add(new Date());
        for (Object node : list) {
            System.out.println(node.toString());
        }
        System.out.println("---");
        list.add("toimisko näinkin?");
        list.add(new Date());
        for (Object node : list) {
            System.out.println(node.toString());
        }
        System.out.println("---");
        list.remove(0);
        for (Object node : list) {
            System.out.println(node.toString());
        }
    }
}