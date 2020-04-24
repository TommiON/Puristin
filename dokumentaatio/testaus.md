# Testaus

### Yksikkötestaus

Yksikkötestauksen tilanne 24. huhtikuuta: testejä 52 kpl, kaikki menevät läpi. Jacocon laskema testikattavuus alla olevassa kuvassa, tarkempi Jacoco-raportointi löytyy myös repositoriosta. I/O- ja main-paketteja ei toistaiseksi ole yritettykään juuri testata, joten "todellinen" testikattavuus jonkin verran suurempi.

![](test_coverage_24_4.png)


### Suorituskykytestaus

Huffman- ja LZW-pakkauksiin rakennettu toiminnallisuus, joka mittaa kuluneen ajan mikrosekunteina sekä saavutetun pakkaussuhteen. Näiden avulla on tehty pientä suorituskykymittausta, mutta järjestelmällisempää tarkastelua haittaa se, että tiedosto-I/O on vielä kesken ja sovellus toimii järkevästi vain tekstikäyttöliittymällä. Tiedosto-I/O tarkoitus saada kasaan ensi viikon aikana, jolloin sovellusta pääsee kokeilemaan erilaisella isommalla koedatalla.

Joitain alustavia mittauksia:


Alunperin tarkoituksena oli yrittää myös automatisoituja suorituskykytestejä, mutta se taitaa jäädä ajanpuutteen vuoksi tekemättä, ja joka tapauksessa tuollaisesta olisi ollut varsinaista hyötyä vain, jos ne olisivat olleet mukana melkein alusta lähtien, jolloin olisi voinut seurata koodimuutosten vaikutusta.
