# Viikkoraportti 3

Kaikille luokille on tehty testejä, mutta melkein kaikki testit ovat toistaiseksi vaillinaisia. Tyypillisesti on kirjoitettu happy path -tyyppinen testi, jolla voi pikaisesti tarkistaa, että luokka tekee sitä mitä on tarkoitus, mutta corner casejen ja virheellisten syötteiden käsittelyä testataan hyvin vähän. Tätä puutetta on tarkoitus korjailla sitä mukaa kun aikaa riittää.

Projekti on edennyt seuraavasti:

### Huffman-algoritmiin liittyvä toiminnallisuus
* CodingTree-luokka eli koodaukseen käytettävä binääripuu valmiiksi.
* CodingAlphabet-luokka, muodostaa teksti->binääri- ja binääri->teksti -muunnokset CodingTreeta hyödyntäen.
* Decoder-luokka, muuntaa bittejä tekstiksi CodingAlphabetia hyödyntäen. Vielä keskeneräinen, nyt tulostaa ruudulle, myöhemmin I/O-puskuriin. Tämän kaveriksi tulee vielä Coder-luokka, joka tekee muunnoksen toiseen suuntaan, ja sitten Huffman-pakkauksen osaset alkavat olla kasassa.

### Omia tietorakenteita
* BitSequence-luokka vaihtelevanpituisten bittisarjojen tallantamiseen ja käsittelyyn.

### I/O
* ByteBuffer-luokkaa eteenpäin, ei vieläkään valmis.

### Muuta
* Selvitelty hieman Lempel–Ziv–Welch -algoritmin perusteita, toteutus vielä aloittamatta.
