# Viikkoraportti 6

Aikaa käytetty n. 25 tuntia ja sinä aikana tapahtunut seuraavaa:

* Kaikki omat tietorakenteet toteutettu ja yksikkötestattu, mutta ei vielä otettu käyttöön algoritmeissa, seuraava askel siis kokeilla miten ne toimivat oikeassa käytössä. Lisää tietorakenteista [toteutusdokumentissa](/dokumentaatio/toteutusdokumentti.md).
* Laajennettu yksikkötestausta.
* Rakennettu pakkaus- ja purkuluokkiin yksinkertaiset ajastus- ja pakkaussuhdelaskurit ja aloiteltu suorituskykytestausta, joka tosin edelleen pahasti vaiheessa I/O-syistä. Lisää [testausdokumentissa](/dokumentaatio/testaus.md).

Merkittävimmät avoimet asiat projektin loppuhuipennuksen lähestyessä:

* Omien tietorakenteiden toimivuus (yksikkötestauksen perusteella ei pitäisi tulla ongelmia, mutta käytännössä varmasti jotain ongelmia tulee).
* Tiedosto-I/O vielä vaiheessa, tällä hetkellä sovellusta voi käyttää vain tekstikäyttöliittymässä.
* Pitää ratkaista, miten Huffman-koodausaakkosto tallennetaan pakatun datan kylkeen. (LZW ei tarvitse oheisdataa varsinaisen datan lisäksi.)
