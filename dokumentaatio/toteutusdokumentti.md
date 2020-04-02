# Toteutus

### Huffman

Dataa pakattaessa sovelluksen Huffman-algoritmia käyttävä osuus toimii yleistasolla näin:

* Toteutuksen keskeinen model-luokka on CodingUnit. Jokainen CodingUnit-olio tallentaa yhden koodauksen perusyksikön eli tekstimerkin. Olio sisältää itse merkin, sen esiintymiskerrat tekstissä sekä merkin pakatun binääriesityksen. Lisäksi on myöhemmin tarvittavaa puunrakennukseen liittyvää dataa, joka on alkuvaiheessa "null".
* Frequencies-luokka käy syötetekstin läpi merkki merkiltä. Uuden merkin kohdatessaan se luo sille CodingUnitin, kohdatessaan saman merkin uudelleen lisää merkin esiintymiskertoja yhdellä.
* Tämän jälkeen CodingUnitit syötetään FeederQueue-luokalle. Se toimii minikikekona eli prioriteettijonona, jossa syötedatassa vähiten esiintyvä CodingUnit on ensimmäisenä.
* Seuraavaksi CodingTree-luokka rakentaa CodingUniteista binääripuun. Tämä tehdään ottamalla FeederQueuesta aina kaksi ensimmäistä CodingUnitia ja yhdistämällä niistä uusi CodingUnit: jonosta otetuista tulee uuden CodingUnitin vasen ja oikea lapsi, ja uuden CodingUnitin esiintymiskertaluku on sen lapsien esiintymiskertojen summa. Jonosta otetut CodingUnitit eivät enää palaa jonoon, mutta uusi CodingUnit työnnetään sinne. Tätä jatketaan, kunnes jonossa on enää yksi alkio: tämä on puun juuri, ja puu on nyt valmis.
* Seuraavana on vuorossa CodingAlphabet-luokka, joka käynnistää puun juurialkiosta lähtien leveyshaun ja rakentaa sen aikana jokaiselle CodingUnitille yksilöllisen bittiesityksen: binääripuun vasemman haaran seuraaminen on "0", oikean "1".
* Lopuksi Coder-luokka hyödyntää CodingAlphabetin ylläpitämää sanakirjaa, jossa jokainen kohdattu tekstimerkki korvataan bittiesityksellä.
* _Tämän jälkeen tiedostoon..._

Purettaessa prosessi huomattavasti yksinkertaisempi, koska koodausaakkosto on jo olemassa. Tällöin Decoder-luokka hyödyntää CodingAlphabetin sanakirjaa toiseen suuntaan ja korvaa bittiesityksen tekstimerkeillä.

_Aikavaativuudet vielä määrittelemättä..._

