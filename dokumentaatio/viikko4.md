# Viikkoraportti 4

Kiireisen tilanteen vuoksi projektiin käytetty tällä viikolla vain n. 10 tuntia, edennyt seuraavasti:

### Huffman-algoritmiin liittyvä toiminnallisuus
* Decoder- ja Coder-luokat valmiiksi. Huffman-pakkauksen ydinosa on nyt valmis ja ainakin testien perusteella näyttäisi jopa toimivan, mutta pakkauskone ja I/O-luokat eivät toistaiseksi ole yhteydessä toisiinsa, joten ohjelma ei tältä osin ole vielä valmis. Seuraava askel on saada Coder ja Decoder lukemaan/kirjoittamaan tiedostoon.

### Omia tietorakenteita
* MinHeap-luokka, toteuttaa minimikeon/prioriteettijonon. Vaikka paketin nimi on GenericDataStructures, luokka ei vielä ole geneerinen, vaan toimii CodingUnitien kanssa. Pitää generisoida myöhemmin.
* Hasher-luokka laitettu alulle, mutta täysin kesken. Tämä luokka toteuttaa hajautustaulun.
