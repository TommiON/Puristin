# Määrittelydokumentti

### Ongelma

Ohjelma pakkaa tekstimuotoista dataa tiiviimmäksi ja palauttaa pakatun datan alkuperäiseen muotoonsa.

### Algoritmi yleistasolla

Ongelmaa lähdetään ratkaisemaan Huffman-algoritmilla, joka on klassinen ja hyvin tunnettu algoritmi tekstimuotoisen (tai yleisemmin rajallista aakkostoa käyttävän) datan pakkaamiseen. Lisäksi Huffman-algoritmi on ilmeisesti hyvin toteutettuna optimaalinen ratkaisu, jos tarkastellaan merkki kerrallaan operoivia pakkausalgoritmeja. Muunlaisia, vielä tehokkaampia pakkausalgoritmeja ilmeisesti on olemassa.

### Osa-algoritmit ja tietorakenteet

Tätä on ehditty miettiä vasta hyvin vähän, mutta mahdollisesti ongelman ratkaisu jakaantuu suunnilleen seuraaviin osa-algoritmeihin ja niitä tukeviin tietorakenteisiin:

* Syötteen lukeminen, eri merkkien esiintymiskertojen laskeminen ja 
* Binääripuun rakentaminen (prioriteettijono).
*

### Syötteet ja tulosteet



### Ohjelmointikieli

Java

### Tietolähteitä

* Wayner, Peter (2000): Compression algorithms of real programmers
* Allain, Alex: Huffman Encoding Compression Algorithm. https://www.cprogramming.com/tutorial/computersciencetheory/huffman.html
* Wikipedia: Huffman Encoding. https://en.wikipedia.org/wiki/Huffman_coding
