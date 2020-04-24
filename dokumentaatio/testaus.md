# Testaus

### Yksikkötestaus

Yksikkötestauksen tilanne 24. huhtikuuta: testejä 52 kpl, kaikki menevät läpi. Jacocon laskema testikattavuus alla olevassa kuvassa, tarkempi Jacoco-raportointi löytyy myös repositoriosta. I/O- ja main-paketteja ei toistaiseksi ole yritettykään juuri testata, joten "todellinen" testikattavuus jonkin verran suurempi.

![](test_coverage_24_4.png)


### Suorituskykytestaus

Huffman- ja LZW-pakkauksiin on rakennettu toiminnallisuus, joka mittaa kuluneen ajan mikrosekunteina sekä saavutetun pakkaussuhteen. Näiden avulla on tehty pientä suorituskykymittausta, mutta järjestelmällisempää tarkastelua haittaa se, että tiedosto-I/O on vielä kesken ja sovellus toimii järkevästi vain tekstikäyttöliittymällä. Tiedosto-I/O tarkoitus saada kasaan ensi viikon aikana, jolloin sovellusta pääsee kokeilemaan erilaisella isommalla koedatalla.

Joitain alustavia mittauksia:

Datana käytettiin seuraavaa tekstiä: *"IPv4:ssä on määritelty, että yhden lähetetyn paketin voi matkalla pilkkoa useammaksi eri paketiksi, eli alkuperäisen paketin paloiksi, joita kutsutaan fragmenteiksi. Kun paketti on pilkottu fragmenteiksi, nämä fragmentit kulkevat verkossa kuten mikä tahansa IP-paketti aina vastaanottajalle asti. Vasta vastaanottaja yhdistää fragmentit alkuperäiseksi paketiksi. Kun se on saanut alkuperäisen paketin kokonaisuudessaan, voi se antaa data-osion eteenpäin. Fragmentointi edellyttää reitittimiltä lisätoiminnallisuutta ja hidastaa pakettien uudelleenlähetystä, kun niitä pitää muokata. Toisaalta fragmentointi on välttämätöntä, jos IP-paketti on suurempi kuin mitä linkkikerros pystyy kuljettamaan yhdessä kehyksessä. Mikäli pakettia ei voisi pilkkoa, sitä ei voisi lähettää eteenpäin, joten viestijöiden näkökulmasta se vain katoaisi matkalla. IPv6:ssa suunnittelun lähtökohtana on ollut pakettien uudelleenlähetyksen mahdollisimman sujuva toiminta ja siksi siitä on jätetty kokonaan pois mahdollisuus pakettien fragmentointiin. Siinä on lähettäjälle tarjolla protokolla, jolla lähettäjä voi tarkistaa mikä on maksimipaketin koko reitillä lähettäjältä vastaanottajalle. IPv6:ssa reititin vain pudottaa liian suuren paketin, jota se ei voi lähettää eteenpäin. Se lähettää tällaisesta tilanteesta kontrolliprotokollan (Internet Control Message Protocol v6, ICMPv6) mukaisen viestin paketin alkuperäiselle lähettäjälle. Näin lähettäjä saa tiedon paketin maksimikoosta ja voi jatkossa huolehtia siitä, että lähetettävät paketit ovat tätä pienempiä."*

Huffman-pakkaus kesti 10 millisekuntia ja pakkaussuhde oli 53,9 %. Purku kesti 26 millisekuntia. LZW-pakkaus kesti 3 millisekuntia ja pakkaussuhde oli 48,6 %. Purku kesti 1 millisekunnin. Tämän kokeilun perusteella LZW on huomattavasti nopeampi, mutta pakkaustehossa ei oleellista eroa. Jatkomittauksissa mielenkiintoista nähdä, miten algoritmit eroavat etenkin ajankäytössä, mutta jo tässä vaiheessa epäilen, että Huffmania hidastaa itse tehty ja mahdollisesti tehoton bittijonojen käsittely. LZW on tässä suhteessa "puhtaampi" toteutus.

Alunperin tarkoituksena oli yrittää myös automatisoituja suorituskykytestejä, mutta se taitaa jäädä ajanpuutteen vuoksi tekemättä, ja joka tapauksessa tuollaisesta olisi ollut varsinaista hyötyä vain, jos ne olisivat olleet mukana melkein alusta lähtien, jolloin olisi voinut seurata koodimuutosten vaikutusta.
