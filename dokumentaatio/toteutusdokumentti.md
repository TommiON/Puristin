# Toteutus

## Sovelluksen yleinen rakenne
Sovellus käynnistyy _main_-pakkauksen ainoasta luokasta **Main**, joka komenoriviparametreista riippuen käynnistää joko interaktiivisen tai komentoriviajon. Varsinaiset algoritmit on jaoteltu _HuffmanEngine_- ja _LempelZiwWelchEngine_-pakkauksiin ja tietorakenteet _CustomDataStructures_-pakkaukseen. Tiedosto-I/O:sta huolehtii _io_-pakkauksen ainoa luokka **FileManager**, joka tarjoaa toiminnallisuuden merkkijonojen, Javan short-lukujen, bittijonojen ja Java-olioiden lukemiseen ja kirjoittamiseen. Viimeksi mainittua toimintoa sovellus käyttää Huffman-aakkoston eli _CodingAlphabet_-olion tallentamiseen levylle.

## Omat tietorakenteet
Sovellukselle on toteutettu seuraavat tietorakenteet:
* **Hasher** ja **KeyValuePair**. Avain/arvo-parin toteuttava tietorakenne ja hajautustaulu niiden tallentamiseen. Molemmat geneerisiä eli hyväksyvät avaimiksi ja arvoiksi mitä vain. (Geneerisyydessä tosin sellainen rajoite, että hajautusarvoja laskeva **HashCalculator**-apuluokka palauttaa järkeviä arvoja vain String- ja Character-tyyppisille avaimille, koska vain noita sovellus käyttää.)
* **ResizingList**. ArrayListin kaltainen tietorakenne, tyyppien suhteen geneerinen.
* **BitSequence**. Vaihtelevanpituisten bittisarjojen tallantamiseen ja käsittelyyn.
* **MinHeap**. "Pienin ensin"-prioriteettijono. Toimii vain _CodingUniteilla_, ei ehditty muuttaa geneeriseksi.
* **SlidingFifoQueue**. First in, first out -jono. Toimii vain _CodingUniteilla_, ei ehditty muuttaa geneeriseksi.

Algoritminen ydinosa on toteutettu kokonaan omilla tietorakenteilla eikä sisällä import-viittauksia Javan tietorakenteisiin, ellei tällaiseksi lasketa _ResizingList_-luokan riippuvuutta _java.util.Iteratorista_, jonka avulla rakennettiin oma iteraattori for/each-iteraatioita varten.

## Huffman
Luokka **HuffmanRunner** toimii Huffman-osuuden pääluokkana. Se koordinoi pakkauksen ja purkamisen eri vaiheita ja tuottaa asiaan liittyvää metadataa.

Pakattaessa sovelluksen Huffman-algoritmia käyttävä osuus toimii näin:
* Toteutuksen keskeinen model-luokka on **CodingUnit**. Jokainen _CodingUnit_-olio tallentaa yhden koodauksen perusyksikön eli tekstimerkin. Olio sisältää itse merkin, sen esiintymiskerrat tekstissä sekä merkin pakatun binääriesityksen. Lisäksi on myöhemmin tarvittavaa puunrakennukseen liittyvää dataa, joka on alkuvaiheessa "null".
* **Frequencies**-luokka käy syötetekstin läpi merkki merkiltä. Uuden merkin kohdatessaan se luo sille _CodingUnitin_, kohdatessaan saman merkin uudelleen lisää merkin esiintymiskertoja yhdellä.
* Tämän jälkeen _CodingUnitit_ syötetään **FeederQueue**-luokalle. Se toimii minikikekona eli prioriteettijonona, jossa syötedatassa vähiten esiintyvä _CodingUnit_ on ensimmäisenä.
* Seuraavaksi **CodingTree**-luokka rakentaa _CodingUniteista_ binääripuun. Tämä tehdään ottamalla _FeederQueuesta_ aina kaksi ensimmäistä _CodingUnitia_ ja yhdistämällä niistä uusi _CodingUnit_: jonosta otetuista tulee uuden _CodingUnitin_ vasen ja oikea lapsi, ja uuden _CodingUnitin_ esiintymiskertaluku on sen lapsien esiintymiskertojen summa. Jonosta otetut _CodingUnitit_ eivät enää palaa pririteettijonoon, mutta uusi _CodingUnit_ työnnetään sinne. Tätä jatketaan, kunnes jonossa on enää yksi alkio: tämä on puun juuri, ja puu on nyt valmis.
* Seuraavana on vuorossa **CodingAlphabet**-luokka, joka käynnistää puun juurialkiosta lähtien leveyshaun ja rakentaa sen aikana jokaiselle _CodingUnitille_ yksilöllisen bittiesityksen: binääripuun vasemman haaran seuraaminen on "0", oikean "1".
* Lopuksi **Coder**-luokka hyödyntää _CodingAlphabetin_ ylläpitämää sanakirjaa, korvaa jokaisen kohdatun merkin sen bittiesityksellä ja muodostaa näin tulostemerkkijonon.

Purettaessa prosessi on huomattavasti yksinkertaisempi, koska koodausaakkosto on jo olemassa. Tällöin **Decoder**-luokka hyödyntää erilliseen tiedostoon tallennettua _CodingAlphabet_-sanakirjaa toiseen suuntaan ja korvaa bittiesityksen tekstimerkeillä. 

## Lempel-Ziv-Welch
Sovelluksen LZW-algoritmia käyttävä osuus toimii dataa pakattaessa yleistasolla näin:
* **EncodingTable**-luokka sisältää sanakirjan, jolla muunnetaan lähdedata pakatuksi (String -> Int-taulukko). Sisältää lähtödatana ASCII-merkit 0-255. Lähtödata on myös purkualgoritmin tiedossa, joten datan ulkopuolelle tallennettavaa sanakirjaa ei tarvita lainkaan.
* **LZWCoder**-luokka käy syötedatan läpi järjestyksessä, rakentaa samalla koodaussanakirjan EncodingTable-luokkaan ja pakkaa sen avulla datan.

Purettaessa sama prosessi kulkee toiseen suuntaan:
* **DecodingTable**-luokkaan luo sanakirja, jolla muunnetaan pakattu data alkuperäiseksi (Int-taulukko -> String). Sisältää lähtödatana ASCII-merkit 0-255.
* **LZWDecoder**-luokka käy pakatun datan läpi järjestyksessä, päättelee alkuperäisen, pakatessa muodostetun sanakirjan ja generoi sen _DecodingTable_-luokkaan, ja palauttaa sen avulla pakatun datan alkuperäiseen muotoon.

## Puutteita ja ongelmia
Ajanpuutteen vuoksi sovellukseen jäi ainakin seuraavat oleelliset puutteet:
* Huffmanin purkuosiossa on jokin bugi, joka tekee purkamisesta hidasta. Tarkemmin [testausdokumentissa](testaus.md).
* LZW-pakkaus tallentaa koodiavaimet 16-bittisinä short-numeroina, vaikka 12 bittiä riittäisi. Tämä syö pakkauksen tehoa. Tehokkaampi tapa olisi tallentaa bittivirtana, tavua pienemmällä resoluutiolla.
* LZW ei osaa reagoida tuntemattomiin (ASCII:n ulkopuolisiin) merkkeihin rakentavasti, vaan kaatuu.
* Algoritminen ydinosa eli _HuffmanEngine_- ja _LZWEngine_-pakkausten sisältö toimii (kai) kohtalaisen nopeasti lukuun ottamatta yllä mainittua Huffman-purun bugia, mutta näitä ympäröivässä osassa eli _IO_- ja _Main_-pakkauksissa on kiireessä tehtyjä, hitaita purkkavirityksiä. Esimerkiksi LZW-pakkauksessa tehdään iteroimalla muunnos arrayn ja arraylistin välillä. Useimmista ongelmakohdista minulla on ihan selkeä käsitys tarvittavasta optimoinnista, mutta aika ei yksinkertaisesti riittänyt.
* Huffman-pakkaus tallentaa aakkoston erilliseen .alphabet-tiedostoon, mikä on epäeleganttia. Aakkosto pitäisi toki pakata samaan tiedostoon datan kanssa, koska jokainen koodausaakkosto on joka tapauksessa uniikki. Lisäksi aakkosto pakataan suoraan Javan ObjectOutputStream-metodiikalla, mikä ei välttämättä ole tilankäytöllisesti kovin tehokas ratkaisu.

Edellisten lisäksi joitakin kauneuvirheiksi luokiteltavia puutteita:
* Käyttöliittymä on viimeistelemätön, esim. syötteitä ei validoida täysin, tiedostot ylikirjoitetaan ilman eri varoitusta jne.
* Osa tietorakenteista on ei-geneerisiä ja toimii vain tietyllä datatyypillä. Ei vaikuta itse sovelluksen toimintaan, mutta on epäeleganttia.
