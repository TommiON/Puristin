# Viikkoraportti 2

Viikon aika projekti edennyt seuraavasti.

### Aiheen tarkentaminen
* Laajennettu projektin aihetta.

### I/O-toiminnallisuus
* TextFileManager-luokka ja -testi. Tekstitiedostojen lukemiseen ja kirjoittamiseen.
* BinaryFileManager-luokka ja -testi. Binääritiedostojen lukemiseen ja kirjoittamiseen.
* Aloitettu ByteBuffer-luokka, täysin kesken. Datan lukemiseen ja kirjoittamiseen yhden bitin tarkkuudella, tavuiksi muutettuna.

### Huffman-algoritmiin liittyvä toiminnallisuus
* Frequencies-luokka ja -testi. Selvittää syötteestä uniikit merkit ja laskee niille esiintymiskerrat.
* CodingUnit-luokka ja -testi. Toteuttaa koodauksen perusyksikön, joista koodauspuu rakennetaan.
* Aloitettu CodingTree-luokka ja -testi, vielä kesken. Koodaukseen käytettävä binääripuu.
* FeederQueue-luokka ja -testi. Prioriteettijono, jota käytetään CodingTreen rakentamiseen.

### Projektin tukitoimintoja
* Lisätty staattinen analyysi (Checkstyle)
* Lisätty testikattavuuden raportointi (Jacoco)

Tunteja yhteensä noin 20.
