package genericDataStructures;

import huffmanEngine.CodingUnit;

/**
 * Implements a smallest-value-first heap structure, used as a priority queue
 */

public class MinHeap {
    private CodingUnit[] contents = new CodingUnit[256];
    private int numberOfElements = 0;

    public void insert(CodingUnit newNode) {
        numberOfElements++;
        contents[numberOfElements] = newNode;

        int index = numberOfElements;

        while (index > 1 && contents[index].getFrequency() < contents[index / 2].getFrequency()) {
            contents[index] = contents[index / 2];
            index = index / 2;
        }

        contents[index] = newNode;
    }

    public CodingUnit pop() {
        CodingUnit returnValue = contents[1];
        contents[1] = contents[numberOfElements];
        numberOfElements--;
        pushDown(1);
        return returnValue;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    private void pushDown(int index) {
        boolean leftIsSmaller;

        if ((index * 2) > numberOfElements) {
            return;
        } else if ((index * 2) == numberOfElements) {
            leftIsSmaller = true;
        } else {
            if (contents[index * 2].getFrequency() < contents[(index * 2) + 1].getFrequency()) {
                leftIsSmaller = true;
            } else {
                leftIsSmaller = false;
            }
        }

        if (leftIsSmaller) {
            if (contents[index].getFrequency() > contents[index * 2].getFrequency()) {
                CodingUnit temp = contents[index];
                contents[index] = contents[index * 2];
                contents[index * 2] = temp;
                pushDown(index * 2);
            }
        } else {
            if (contents[index].getFrequency() > contents[(index * 2) + 1].getFrequency()) {
                CodingUnit temp = contents[index];
                contents[index] = contents[(index * 2) + 1];
                contents[(index * 2) + 1] = temp;
                pushDown((index * 2) + 1);
            }
        }
    }
}