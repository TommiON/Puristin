package LempelZivWelchEngine;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LZWCoderAndDecoderTest {

    @Test
    public void encodesAndDecodesCorrectly() {
        LZWCoder lzwCoder = new LZWCoder();
        String sourceString = "Tässä vähän kamaa pakattavaksi, kuinka hyvin mahtaa puristua?";
        System.out.println("Alkuperäinen merkkijono: " + sourceString);
        System.out.println("Alkuperäisen pituus: " + sourceString.length());

        ArrayList<Integer> compressedTarget = lzwCoder.encode(sourceString);

        System.out.print("Pakattuna: ");
        for (int code : compressedTarget) {
            System.out.print(code + " ");
        }
        System.out.println();
        System.out.println("Pakatun pituus: " + compressedTarget.size());

        LZWDecoder lzwDecoder = new LZWDecoder();

        String returningOutput = lzwDecoder.decode(compressedTarget);

        System.out.println("Palautuu: " + returningOutput);
        System.out.println("Palautuvan pituus: " + returningOutput.length());

        assertEquals(sourceString.length(), returningOutput.length());
        assertEquals(sourceString, returningOutput);
    }

    @Test
    public void encodesAndDecodesCorrectly2() {
        LZWCoder lzwCoder = new LZWCoder();
        String sourceString = "banana bandana banana";
        System.out.println("Alkuperäinen merkkijono: " + sourceString);
        System.out.println("Alkuperäisen pituus: " + sourceString.length());

        ArrayList<Integer> compressedTarget = lzwCoder.encode(sourceString);

        System.out.print("Pakattuna: ");
        for (int code : compressedTarget) {
            System.out.print(code + " ");
        }
        System.out.println();
        System.out.println("Pakatun pituus: " + compressedTarget.size());

        LZWDecoder lzwDecoder = new LZWDecoder();

        String returningOutput = lzwDecoder.decode(compressedTarget);

        System.out.println("Palautuu: " + returningOutput);
        System.out.println("Palautuvan pituus: " + returningOutput.length());

        assertEquals(sourceString.length(), returningOutput.length());
        assertEquals(sourceString, returningOutput);
    }

    @Test
    public void encodesAndDecodesCorrectly3() {
        LZWCoder lzwCoder = new LZWCoder();
        String sourceString = "Yksi kuljetuspalvelun keskeisistä tehtävistä on saapuvien viestien toimittaminen oikealle sovelluskerroksen vastaanottajalle. Samassa koneessa voi olla samanaikaisesti useita prosesseja, jotka odottavat saapuvia viestejä.\n" +
                "Vastaanottovaiheessa linkkikerros poimii saapuvista viesteistä ne, jotka on sillä kerroksella osoitettu tälle koneelle. Se antaa nämä viestit verkkokerrokselle, joka tarkistaa verkkokerroksen tiedoista viestin varsinaisen vastaanottajan. Jos vastaanottaja ei ollut tämä laite, niin viesti reititetään kohti lopullista vastaanottajaa ja annetaan linkkikerrokselle toimitettavaksi eteenpäin. Kun verkkokerroksen mielestä vastaanottaja on tällä koneella, se antaa viestin edelleen kuljetuskerrokselle.\n" +
                "Kun kuljetuskerros saa viestin verkkokerrokselta, on kuljetuskerroksen selvitettävä, mille sovelluskerroksen vastaanottajalle viesti on oikeasti menossa. Jokainen verkkokerrokselta saapuva viesti on selvitettävä erikseen. Ne voivat olla menossa eri vastaanottajille.\n" +
                "Vastaavasti sovelluskerrokselta kuljetuskerrokselle tulevat viestit saapuvat eri kohteista ja lähetysvaiheessa ne voivat lomittua keskenään.";
        System.out.println("Alkuperäinen merkkijono: " + sourceString);
        System.out.println("Alkuperäisen pituus: " + sourceString.length());

        ArrayList<Integer> compressedTarget = lzwCoder.encode(sourceString);

        System.out.print("Pakattuna: ");
        for (int code : compressedTarget) {
            System.out.print(code + " ");
        }
        System.out.println();
        System.out.println("Pakatun pituus: " + compressedTarget.size());

        LZWDecoder lzwDecoder = new LZWDecoder();

        String returningOutput = lzwDecoder.decode(compressedTarget);

        System.out.println("Palautuu: " + returningOutput);
        System.out.println("Palautuvan pituus: " + returningOutput.length());

        assertEquals(sourceString.length(), returningOutput.length());
        assertEquals(sourceString, returningOutput);
    }
}