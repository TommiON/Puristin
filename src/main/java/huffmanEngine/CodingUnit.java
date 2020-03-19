package huffmanEngine;

public class CodingUnit {
    private char character;
    private int frequency;
    private CodingUnit leftChild;
    private CodingUnit rightChild;

    public CodingUnit(char character) {
        this.character = character;
        this.frequency = 1;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void addNewOccurrence() {
        this.frequency++;
    }

    public char getCharacter() {
        return this.character;
    }

    public CodingUnit getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(CodingUnit child) {
        this.leftChild = child;
    }

    public CodingUnit getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(CodingUnit child) {
        this.rightChild = child;
    }

    @Override
    public String toString() {
        return ("Character: " + character + " Frequency: " + frequency + " Left child: " + leftChild + " Right child: " + rightChild);
    }
}
