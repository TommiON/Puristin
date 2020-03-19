package huffmanEngine;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FrequenciesTest {

    @Test
    public void recordsFrequenciesCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b'};
        for (char c : testCharacters) {
            Frequencies.checkInACharacter(c);
        }

        for (HashMap.Entry entry : Frequencies.getContents().entrySet()) {
            System.out.println(entry.toString());
        }

        assertEquals(4, Frequencies.getNumberOfUniqueCharacters());
    }
    
}