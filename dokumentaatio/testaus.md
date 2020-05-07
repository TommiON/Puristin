# Testaus

## Yksikkötestaus

Yksikkötestauksen tilanne 24. huhtikuuta: testejä 52 kpl, kaikki menevät läpi. Jacocon laskema testikattavuus alla olevassa kuvassa, tarkempi Jacoco-raportointi löytyy myös repositoriosta. I/O- ja main-paketteja ei toistaiseksi ole yritettykään juuri testata, joten "todellinen" testikattavuus jonkin verran suurempi.

![](test_coverage_24_4.png)


## Suorituskykytestaus

Huffman- ja LZW-pakkauksiin on rakennettu toiminnallisuus, joka mittaa kuluneen ajan mikrosekunteina sekä saavutetun pakkaussuhteen. LZW-pakkauksessa lasketaan lisäksi kaksi eri suhdelukua, todellinen ja "ideaalinen". Nimittäin ajanpuutteen vuoksi LZW:n tiedosto-I/O jouduttiin toteuttamaan Javan short-lukutyypillä eli 16-bittisillä luvuilla, vaikka sisäisesti LZW-avaimille riittää 12 bittiä. Ideaalinen luku laskee, mikä pakkaussuhde olisi, jos myös tiedosto-I/O olisi ehditty toteuttaa 12-bittisenä.

Automaattiset suorituskykytestit löytyvät _Performance_-testipakkauksesta. Ne käyttävät seuraavia testiaineistoja:
* Data 1: Noin 22 kilotavun kokoinen suomenkielinen blogiteksti.
* Data 2: Joseph Condardin Heart of Darkness -romaanin ensimmäinen osa, noin 80 kilotavun englanninkielinen teksti.
* Data 3: Merkkijono, jossa on tuhat kertaa teksti _"Tässä olisi vähän tekstiä, toistetaan huomattavan monta kertaa samanlaisena"_.

||Data 1, JCL |Data 1, custom |Data 2, JCL|Data 2, custom|Data 3, JCL|Data 3, custom
---|---|---|---|---|---|---
LZW, pakkaussuhde (ideaalinen suluissa) |67,8% (50,9%)||66,4% (49,8%)||8,8% (6,6%)|
LZW, pakkausnopeus |12 ms||24 ms||29 ms|
LZW, purkunopeus |55 ms||654 ms||62 ms|
Huffman, pakkaussuhde |53,7%||55,3%||48,4%|
Huffman, pakkausnopeus |39 ms||63 ms||37 ms|
Huffman, purkunopeus|1913 ms||18785 ms||15301 ms|

