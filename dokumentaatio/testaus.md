# Testaus

### Yksikkötestaus

Yksikkötestauksen tilanne 24. huhtikuuta: testejä 52 kpl, kaikki menevät läpi. Jacocon laskema testikattavuus alla olevassa kuvassa, tarkempi Jacoco-raportointi löytyy myös repositoriosta. I/O- ja main-paketteja ei toistaiseksi ole yritettykään juuri testata, joten "todellinen" testikattavuus jonkin verran suurempi.

![](test_coverage_24_4.png)


### Suorituskykytestaus

Suorituskykytestausta tehty toistaiseksi vain epämuodollisesti kellottamalla ja pakatun datan määrää tarkastelemalla. Seuraavaksi luokkiin rakennetaan metodit näiden arvojen laskemiseen, ja samalla otetaan käyttöön joukko erilaisia ja -kokoisia testiaineistoja, jotta suorituskyvystä saadaan tarkempi selko. (Samalla tehdään toteutusdokumentin puolelle muodollisempi aikavaativuusluokkien analyysi.)
