# Viikkoraportti 5

Aikaa käytetty n. 25 tuntia. Projektin tilanne:

### Huffman-pakkaus ja -purku

Valmis ja näyttäisi toimivan. (Pakkaussuhteen näyttäminen käyttäjälle vielä tekemättä.)

### LZW-pakkaus ja -purku

Myös valmis ja näyttäisi toimivan. (Niin ikään pakkaussuhteen näyttäminen käyttäjälle vielä tekemättä.)

### I/O

Rakennettu Main-luokkaan yksinkertainen tekstikäyttöliittymä, jolla voi voi antaa pakattavaa ja purettavaa dataa kirjoittamalla tai copy&pastella. Tämän tarkoituksena on oikeastaan varautua siihen mahdollisuuteen, että aika loppuu kesken ja tiedosto-I/O:ta ei ehdi saada valmiiksi - on sitten olemassa ainakin joku keino käyttää sovelluksen varsinaista ydintoiminnallisuutta.

Tiedosto-I/O tässä vaiheessa vielä pahasti kesken. Tiedostoon kirjoittaminen ja lukeminen itsessään toimii, mutta sovellukselta tuleva data pitää jotenkin mankeloida ja puskuroida, tämä tekemättä.

### Omat tietorakenteet

Omia tietorakenteita edistelty, mutta niitä ei ole vielä otettu käyttöön pakkausalgoritmeissa, vaan toistaiseksi mennään vielä Javan valmiilla (paitsi BitSequence, joka ollut käytössä alusta lähtien).

Seuraavat luokat olemassa:
* BitSequence-luokka vaihtelevanpituisten bittisarjojen tallantamiseen ja käsittelyyn.
* MinHeap-luokka, toteuttaa minimikeon/prioriteettijonon CodingUniteille.
* SlidingFifoQueue-luokka, toteuttaa FIFO-jonon CodingUniteille.
* StringHasher, hajautustaulu joka käyttää Stringejä avaimina, vielä täysin kesken, oikeastaan vasta hash-funktio olemassa.

Näiden lisäksi tarvitaan vielä ainakin jonkinlainen ArrayList-toteutus.
