# Toteutus

### Huffman

Dataa pakattaessa sovelluksen Huffman-algoritmia käyttävä osuus toimii yleistasolla näin:

* Toteutuksen keskeinen model-luokka on CodingUnit. Jokainen CodingUnit-olio tallentaa yhden koodauksen perusyksikön eli tekstimerkin. Olio sisältää itse merkin, sen esiintymiskerrat tekstissä sekä merkin pakatun binääriesityksen. Lisäksi on myöhemmin tarvittavaa puunrakennukseen liittyvää dataa, joka on alkuvaiheessa "null".
* Frequencies-luokka käy syötetekstin läpi merkki merkiltä. Uuden merkin kohdatessaan se luo sille CodingUnitin, kohdatessaan saman merkin uudelleen lisää merkin esiintymiskertoja yhdellä.
* Tämän jälkeen CodingUnitit syötetään FeederQueue-luokalle. Se toimii minikikekona eli prioriteettijonona, jossa syötedatassa vähiten esiintyvä CodingUnit on ensimmäisenä.
* Seuraavaksi CodingTree-luokka rakentaa CodingUniteista binääripuun. Tämä tehdään ottamalla FeederQueuesta aina kaksi ensimmäistä CodingUnitia ja yhdistämällä niistä uusi CodingUnit: jonosta otetuista tulee uuden CodingUnitin vasen ja oikea lapsi, ja uuden CodingUnitin esiintymiskertaluku on sen lapsien esiintymiskertojen summa. Jonosta otetut CodingUnitit eivät enää palaa pririteettijonoon, mutta uusi CodingUnit työnnetään sinne. Tätä jatketaan, kunnes jonossa on enää yksi alkio: tämä on puun juuri, ja puu on nyt valmis.
* Seuraavana on vuorossa CodingAlphabet-luokka, joka käynnistää puun juurialkiosta lähtien leveyshaun ja rakentaa sen aikana jokaiselle CodingUnitille yksilöllisen bittiesityksen: binääripuun vasemman haaran seuraaminen on "0", oikean "1".
* Lopuksi Coder-luokka hyödyntää CodingAlphabetin ylläpitämää sanakirjaa, korvaa jokaisen kohdatun merkin sen bittiesityksellä ja muodostaa näin tulostemerkkijonon.

Purettaessa prosessi on huomattavasti yksinkertaisempi, koska koodausaakkosto on jo olemassa. Tällöin Decoder-luokka hyödyntää CodingAlphabetin sanakirjaa toiseen suuntaan ja korvaa bittiesityksen tekstimerkeillä. _Koodausaakkoston tallennus datan mukana vielä mietinnässä..._

### Lempel-Ziv-Welch

Sovelluksen LZQ-algoritmia käyttävä osuus toimii dataa pakattaessa yleistasolla näin:

* EncodingTable-luokkaan luodaan sanakirja, jolla muunnetaan lähdedata pakatuksi (String -> Int-taulukko). Sisältää lähtödatana ASCII-merkit 0-255.
* LZWCoder-luokka käy syötedatan läpi järjestyksessä, rakentaa samalla koodaussanakirjan EncodingTable-luokkaan ja pakkaa sen avulla datan.

Purettaessa sama prosessi kulkee toiseen suuntaan:

* DecodingTable-luokkaan luo sanakirja, jolla muunnetaan pakattu data alkuperäiseksi (Int-taulukko -> String). Sisältää lähtödatana ASCII-merkit 0-255.
* LZWDecoder-luokka käy pakatun datan läpi järjestyksessä, päättelee alkuperäisen, pakatessa muodostetun sanakirjan ja generoi sen DecodingTable-luokkaan, ja palauttaa sen avulla pakatun datan alkuperäiseen muotoon.

_Aikavaativuudet kummallekin vielä määrittelemättä..._

### Omat tietorakenteet

Sovellukselle on toteutettu seuraavat tietorakenteet:

* **Hasher** ja **KeyValuePair**. Avain/arvo-parin toteuttava tietorakenne ja hajautustaulu niiden tallentamiseen. Molemmat geneerisiä eli hyväksyvät avaimiksi ja arvoiksi mitä vain. (Geneerisyydessä tosin sellainen rajoite, että hajautusarvoja laskeva **HashCalculator**-apuluokka palauttaa järkeviä arvoja vain String- ja Character-tyyppisille avaimille, koska vain noita sovellus käyttää.) Toimii ajassa O(1), paitsi kaikki avain/arvo-parit palauttava iteraattori ajassa O(n).
* **ResizingList**. ArrayListin kaltainen tietorakenne, tyyppien suhteen geneerinen.
* **BitSequence**. Vaihtelevanpituisten bittisarjojen tallantamiseen ja käsittelyyn.
* **MinHeap**. "Pienin ensin"-prioriteettijono. Toimii vain CodingUniteilla, muutetaan geneeriseksi jos ehditään.
* **SlidingFifoQueue**. First in, first out -jono. Toimii vain CodingUniteilla, muutetaan geneeriseksi jos ehditään.
