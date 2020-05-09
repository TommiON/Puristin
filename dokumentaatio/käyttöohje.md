# Käyttöohje

## Asennus ja käyttöönotto

Lataa tiedosto [Puristin.jar](https://github.com/TommiON/Puristin/releases/download/1.0/Puristin.jar). Mene hakemistoon, jossa tiedosto sijaitsee, ja anna komento

```java -jar Puristin.jar```

## Interaktiivinen moodi

Jos sovelluksen käynnistää pelkällä komennolla `java -jar Puristin.jar` ilman parametreja, käynnistyy vuorovaikutteinen moodi, jossa toiminto valitaan numerolla ja pakattavaa/purettavaa dataa voi sen jälkeen antaa kirjoittamalla.

![](ui1.png)

Sovellus näyttää pakkauksen tai purun tuloksen suoraan ruudulla ja tarjoaa lisäksi tietoa pakkaussuhteesta ja kuluneesta ajasta. Interaktiivisessa moodissa mitään dataa ei tallenneta pysyvästi minnekään, ja siksi toiminto 2 eli Huffman-purku olettaa, että purettaessa käytetään viimeksi tehdyn Huffman-pakkauksen aakkostoa.

## Komentorivimoodi

Komentorivimoodissa dataa voidaan lukea tiedostoista ja kirjoittaa niihin. Komentorivikäytön syntaksi on seuraava:

```java -jar Puristin.jar [huffman|lzw] [pakkaa|pura] <<lähdetiedosto>> <<kohdetiedosto>>```

Komennossa on neljä parametria, joista kaikki ovat pakollisia:
* Ensimmäisellä parametrilla valitaan käytettävä algoritmi, vaihtoehdot `huffman` ja `lzw`.
* Toisella parametrilla valitaan varsinainen toiminto, joko `pakkaa` tai `pura`.
* Kolmannella parametrilla annetaan operaation lähdetiedoston nimi.
* Neljännellä parametrilla annetaan operaation kohdetiedoston nimi. Jos tiedostoa ei ole olemassa, se luodaan. Jos saman niminen tiedosto on jo olemassa, se ylikirjoitetaan.

Esimerkki komennosta, joka pakkaa _source.txt_ -tiedoston LZW-algoritmilla tiedostoon _target.lzw_:

```java -jar Puristin.jar lzw pakkaa source.txt target.lzw```

Huom! Huffman-pakkausta käytettäessä sovellus luo pakatun kohdetiedoston lisäksi samaan hakemistoon erillisen aakkostotiedoston, jonka nimi on muuten sama kuin kohdetiedostolla, mutta päätteeksi lisätään _.alphabet_.
