package huffmanEngine;

/**
 * Implements the basic element for Huffman coding: character with frequency and two tree links
 */
public class CodingUnit implements Comparable {
    private char character;
    private int frequency;
    private CodingUnit leftChild;
    private CodingUnit rightChild;

    /**
     * Constructor, starting frequency 1 (as the first character has been encountered when this is called), tree links start as null
     * @param character character to be coded
     */
    public CodingUnit(char character) {
        this.character = character;
        this.frequency = 1;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Returns the number of occurrences for this character
     * @return frequency as int
     */
    public int getFrequency() {
        return this.frequency;
    }

    /**
     * Increments frequency by one when a new instance of this character is encountered
     */
    public void addNewOccurrence() {
        this.frequency++;
    }

    /**
     * Return the character represented by this CodingUnit
     * @return as char
     */
    public char getCharacter() {
        return this.character;
    }

    /**
     * Returns this CodingUnit's left child in tree
     * @return a CodingUnit or null
     */
    public CodingUnit getLeftChild() {
        return this.leftChild;
    }

    /**
     * Sets a left child in tree for this CodingUnit
     * @param child reference to a CodingUnit
     */
    public void setLeftChild(CodingUnit child) {
        this.leftChild = child;
    }

    /**
     * Returns this CodingUnit's right child in tree
     * @return a CodingUnit or null
     */
    public CodingUnit getRightChild() {
        return this.rightChild;
    }

    /**
     * Sets a right child in tree for this CodingUnit
     * @param child reference to a CodingUnit
     */
    public void setRightChild(CodingUnit child) {
        this.rightChild = child;
    }

    /**
     * Comparator method, needed for priority queue ordering (Comparable interface) for CodingUnits
     * @param o another CodingUnit to compare to
     * @return int, negative if o has higher frequency than this, positive if the opposite, 0 if equal
     */
    @Override
    public int compareTo(Object o) {
        CodingUnit compareTarget = (CodingUnit) o;
        return this.frequency - ((CodingUnit) o).frequency;
    }

    /**
     * String representation for testing/debugging
     * @return CodingUnit properties in a String
     */
    @Override
    public String toString() {
        return ("Character: " + character + " Frequency: " + frequency + " Left child: " + leftChild + " Right child: " + rightChild);
    }
}
