package CustomDataStructures;

import HuffmanEngine.CodingUnit;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlidingFifoQueueTest {

    @Test
    public void worksCorrectly() {
        SlidingFifoQueue queue = new SlidingFifoQueue();

        assertEquals(true, queue.isEmpty());

        CodingUnit a = new CodingUnit('a');
        CodingUnit b = new CodingUnit('b');
        CodingUnit c = new CodingUnit('c');

        queue.push(a);
        queue.push(b);
        queue.push(c);

        assertEquals(false, queue.isEmpty());

        for (int i = 1; i <= 3; i++) {
            System.out.println(i + ": " + queue.pop());
        }
        assertEquals(true, queue.isEmpty());

        CodingUnit doesNotExist = queue.pop();
        assertNull(doesNotExist);
    }
}