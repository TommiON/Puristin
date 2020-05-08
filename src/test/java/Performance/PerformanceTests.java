package Performance;

import CustomDataStructures.BitSequence;
import CustomDataStructures.ResizingList;
import HuffmanEngine.CodingAlphabet;
import HuffmanEngine.HuffmanRunner;
import LempelZivWelchEngine.LZWCoder;
import LempelZivWelchEngine.LZWDecoder;
import org.junit.Test;

import java.util.ArrayList;

public class PerformanceTests {

    @Test
    public void testPerformanceWithRandomAuthenticData() {
        String testData = TestSupport.getBlogPost();
        System.out.println("Performance, random authentic data");
        run(testData);
        System.out.println();
    }

    @Test
    public void testPerformanceWithRandomAuthenticData2() {
        String testData = TestSupport.getHeartOfDarkness();
        System.out.println("Performance, Joseph Conrad's Heart of Darkness");
        run(testData);
        System.out.println();
    }

    @Test
    public void testPerformanceWithRepetitiveData() {
        String testData = TestSupport.getRepetitiveText();
        System.out.println("Performance, generated repetitive data");
        run(testData);
        System.out.println();
    }

    private void run(String testData) {
        HuffmanRunner huffmanRunnerIn = new HuffmanRunner();
        BitSequence huffmanResultBinary = huffmanRunnerIn.encode(testData);
        System.out.println("Huffman, pakkausaika: " + huffmanRunnerIn.getTime());
        System.out.println("Huffman, pakkaussuhde: " + huffmanRunnerIn.getCompressRatio());

        CodingAlphabet knownHuffmanAlphabet = huffmanRunnerIn.getAlphabet();
        HuffmanRunner huffmanRunnerOut = new HuffmanRunner(knownHuffmanAlphabet);
        String huffmanResultString = huffmanRunnerOut.decode(huffmanResultBinary);
        System.out.println("Huffman, purkuaika: " + huffmanRunnerOut.getTime());

        LZWCoder lzwCoder = new LZWCoder();
        ResizingList<Short> resultNumbers = lzwCoder.encode(testData);
        System.out.println("LZW, pakkausaika: " + lzwCoder.getTime());
        System.out.println("LZW, pakkaussuhde: " + lzwCoder.getActualCompressRatio());
        System.out.println("LZW, ideaalinen pakkaussuhde: " + lzwCoder.getIdealCompressRatio());

        LZWDecoder lzwDecoder = new LZWDecoder();
        String out = lzwDecoder.decode(resultNumbers);
        System.out.println("LZW, purkuaika: " + lzwDecoder.getTime());
    }


}
