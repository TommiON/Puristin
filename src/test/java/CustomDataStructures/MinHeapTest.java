package CustomDataStructures;

import huffmanEngine.CodingUnit;
import huffmanEngine.Frequencies;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {

    @Test
    public void worksCorrectlyWithOneNode() {
        MinHeap heap = new MinHeap();
        CodingUnit codingUnit = new CodingUnit('a');
        assertEquals(true, heap.isEmpty());
        heap.insert(codingUnit);
        assertEquals(false,heap.isEmpty());
        CodingUnit output = heap.pop();
        System.out.println(output.toString());
        assertEquals('a', output.getCharacter());
        assertEquals(true, heap.isEmpty());
    }

    @Test
    public void worksCorrectlyWithManyNodes() {
        MinHeap heap = new MinHeap();

        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'a'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        assertEquals(true, heap.isEmpty());

        for (CodingUnit codingUnit : freq.getCodingUnitsAsList()) {
            heap.insert(codingUnit);
        }

        assertEquals(false, heap.isEmpty());

        CodingUnit output;
        while (!heap.isEmpty()) {
            output = heap.pop();
            System.out.println(output);
        }

        assertEquals(true, heap.isEmpty());
    }

    @Test
    public void worksCorrectlyWithManyNodesWhenSomeNodesEqual() {
        MinHeap heap = new MinHeap();

        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'b', 'a', 'b', 'b'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        assertEquals(true, heap.isEmpty());

        for (CodingUnit codingUnit : freq.getCodingUnitsAsList()) {
            heap.insert(codingUnit);
        }

        assertEquals(false, heap.isEmpty());

        CodingUnit output;
        while (!heap.isEmpty()) {
            output = heap.pop();
            System.out.println(output);
        }

        assertEquals(true, heap.isEmpty());
    }

    @Test
    public void workCorrectlyWithMultipleInsertions() {
        MinHeap heap = new MinHeap();

        CodingUnit a = new CodingUnit('a');
        heap.insert(a);
        CodingUnit b = new CodingUnit('b');
        heap.insert(b);

        CodingUnit combo = new CodingUnit(a, b);
        heap.insert(combo);

        CodingUnit output;
        while (!heap.isEmpty()) {
            output = heap.pop();
            System.out.println(output);
        }

        assertEquals(true, heap.isEmpty());

    }

}