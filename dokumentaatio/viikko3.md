# Viikkoraportti 3

Kaikille luokille on tehty testejä, mutta melkein kaikki testit ovat toistaiseksi vaillinaisia. Tyypillisesti on kirjoitettu happy path -tyyppinen testi, jolla voi pikaisesti tarkistaa, että luokka tekee sitä mitä on tarkoitus, mutta corner casejen ja virheellisten syötteiden käsittelyä testataan hyvin vähän. Tätä puutetta on tarkoitus korjailla sitä mukaa kun aikaa riittää.

Projekti on edennyt seuraavasti:

### Huffman-algoritmiin liittyvä toiminnallisuus
* CodingTree-luokka eli koodaukseen käytettävä binääripuu valmiiksi.
* CodingAlphabet-luokka, rakentaa teksti->binääri- ja binääri->teksti -aakkoston CodingTreeta hyödyntäen.
* CoderDecoder-luokka, muuntaa tekstiä biteiksi ja päinvastoin CodingAlphabetia hyödyntäen.

### Omia tietorakenteita
* BitSequence-luokka vaihtelevanpituisten bittisarjojen tallantamiseen ja käsittelyyn.

### I/O
* ByteBuffer-luokkaa eteenpäin, ei vieläkään valmis.
* StringHasher, oma toteutus HashMap<String,String> -tietorakenteesta, vielä hyvin kesken.

### Muuta
* Selvitelty hieman Lempel–Ziv–Welch -algoritmin perusteita, toteutus vielä aloittamatta.
