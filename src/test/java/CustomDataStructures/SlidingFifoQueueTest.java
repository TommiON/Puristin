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

        queue.add(a);
        queue.add(b);
        queue.add(c);

        assertEquals(false, queue.isEmpty());

        for (int i = 1; i <= 3; i++) {
            System.out.println(i + ": " + queue.poll());
        }
        assertEquals(true, queue.isEmpty());

        CodingUnit doesNotExist = queue.poll();
        assertNull(doesNotExist);
    }
}