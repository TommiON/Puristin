# Määrittelydokumentti

### Ratkaistava ongelma

Ohjelma pakkaa tekstimuotoista dataa tiiviimmäksi ja palauttaa pakatun datan alkuperäiseen muotoonsa.

### Algoritmit yleistasolla

Ongelmaa lähdetään ratkaisemaan Huffman-algoritmilla ja Lempel–Ziv–Welch-algoritmilla.

### Syötteet ja tulosteet

Pakatessa sovellus hyväksyy syötteenä 8-bittisesti ASCII-koodattua tekstiä tiedostosta ja tulostaa pakatun version toiseen  tiedostoon. Purkaessa prosessi on sama, mutta päinvastaiseen suuntaan.

### Osa-algoritmit ja tietorakenteet (Huffman)

Tätä on ehditty miettiä vasta hyvin vähän, mutta mahdollisesti ongelman ratkaisu jakaantuu suunnilleen seuraaviin osa-algoritmeihin ja niitä tukeviin tietorakenteisiin:

* Syöte luetaan ja eri merkkien esiintymiskerrat lasketaan. Koska tekstiaakkosto tunnetaan ennalta ja on suljettu, tietorakenteeksi riittänee tässä vaiheessa 256-paikkainen kokonaislukutaulukko, jossa jokainen taulukkopaikka ilmaisee kyseisen merkin esiintymiskerrat. Syöte käydään läpi järjestyksessä ja laskureiden arvoja lisätään tämän mukaan.
* Kustakin taulukon alkiosta muodostetaan CodeUnit-tietorakenne, joka sisältää 1) kyseisen merkin, 2) merkin esiintymiskerrat  kokonaislukuna, ja 3) osoittimen tulevaan äitisolmuun puussa. Osoitinta tarvitaan tulevassa puunrakennusvaiheessa, tässä vaiheessa osoittimien arvo on "null".
* Edellä muodostetut CodeUnitit tallennetaan prioriteettijonoon eli minimikekoon, jossa vähiten esiintymiskertoja sisältävät CodeUnitit ovat korkeimmalla prioriteetilla. Sitten ryhdytään rakentamaan Huffman-binääripuuta alhaalta ylös ottamalla jonosta kaksi ensimmäistä (datassa vähiten esiintyvää) CodeUnitia ja liittämällä ne uuden äitisolmun lapsiksi. Äitisolmun esiintymiskerroiksi tulee lapsisolmun esiintymiskertojen summa. Muodostettu äitisolmu palautetaan prioriteettijonoon ja tätä jatketaan, kunnes jonossa on enää yksi solmu. Puu on tällöin valmis ja jäljellä oleva solmu on sen juuri.
* Muodostetaan koodiaakkosto, jossa jokaiselle merkille on tallennettu bittipolku, jota kulkemalla pääsee Huffman-puussa kyseiseen merkkiin (0 = vasen lapsisolmu, joka on aina puun lehti eli merkki, 1 = oikea lapsisolmu, jatketaan puussa alaspäin). Koodiaakkosto tallennetaan pakatun tiedoston alkuun, tarkempi toteutus vielä selvitettävä.
* Koodataan data käymällä syöte läpi merkki merkiltä ja korvaamalla se vastaavalla bittiesityksellä.
* Pakattua tiedostoa purettaessa edellinen kohta suoritetaan päinvastaiseen suuntaan.

### Osa-algoritmit ja tietorakenteet (Lempel–Ziv–Welch)

Tämä osio vielä selvitettävä tarkemmin, toistaiseksi vasta hyvin yleisluontoinen käsitys menetelmästä.

### Aikavaativuudet

Huffman-puun muodostaminen O(n log n), jossa n = aakkosten eli uniikkien merkkien määrä?

Itse koodaus/dekoodaus O(m), jossa m = datan eli merkkien määrä?

### Ohjelmointikieli

Java

### Tietolähteitä

* Wayner, Peter (2000): Compression algorithms of real programmers
* Allain, Alex: Huffman Encoding Compression Algorithm. https://www.cprogramming.com/tutorial/computersciencetheory/huffman.html
* Wikipedia: Huffman Encoding. https://en.wikipedia.org/wiki/Huffman_coding
* Laaksonen, Antti (2019): Tietorakenteet ja algoritmit.
* https://www.geeksforgeeks.org/lzw-lempel-ziv-welch-compression-technique/
