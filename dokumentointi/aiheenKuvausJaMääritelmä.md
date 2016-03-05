**Aihe:** Toteutetaan kaksinpelinä pelattava shakkipeli, johon on myöhemmin mahdollista kirjoittaa myös tekoäly. Peliin tulee yksinkertainen graafinen käyttöliittymä.

**Käyttäjät:** Pelaaja/t.

**Ydintoiminnot:**
* Siirron tekeminen
* Voittaminen (ohjelma ilmoittaa, kun jompi kumpi pelaajista voittaa tai peli päättyy tasapeliin)

**Tulevat laajennukset (ei vielä tässä versiossa):**
* Pelin lataus ja tallennus
* Tekoäly

![Määrittelyvaiheen luokkakaavio](https://github.com/tiikkala/shakki/blob/master/dokumentointi/shakki-UML.png)

Pelilautaa edustaa Board-luokka, ja se koostuu ruutuja edustavista Tile-olioista. Tile-luokka on abstrakti, ja sillä on alaluokat OccupiedTile ja EmptyTile. Pelilauta tuntee pelaajat (Player), siirrot (Move) sekä nappulat (Pieces).

OccupiedTile tuntee ruudussa olean Piecen. Piece on abstrakti luokka, jolla on aluluokkina eri nappuloita edustavat luokat.

Board-luokkaan liittyy abstrakti Player-luokka, jolla on aliluokat WhitePlayer ja BlackPlayer. Pelaaja tuntee pelilaudan ja siirtonsa (Move-luokka). BoardUtils-luokasta löytyy ohjelmassa käytettäviä vakioita ja apumetodeita. Board-olioita luodaan BoardBuilderilla. 

Abstrakti Move-luokka edustaa siirtoja. Tärkeimmät aliluokat ovat NormalMove sekä AttackMove, joista jälkimmäinen eroaa edellisestä siinä, että siirron myötä syödään vastustajan nappula. Lisäksi erikoissiirroilla (tornitus, én passe, sotilaan syönti) ja sotilaan siirroilla on omat Move-aliluokkansa. Move-olioita luodmiseksi on olemassa MoveFactory-luokka. (Tätä ja Move-aliluokkia ei ole kaaviossa, jotta se pysyisi selkeänä. Move-luokkia on näin paljon osin siitä syystä, että se helpottaa edessä olevaa tekoälyn koodausta.)

MoveTransiosion luokka on Move-luokan ja Board-luokan välissä ja sen avulla viimekädessä hallitaan siirtojen laillisuutta. MoveTransiosion luokka sisältää Board-attribuutin, joka edustaa pelilaudan tilaa sen jälkeen, kun siirto on tehty. Mikäli pelilaudan tilanne on shakin sääntöjen vastainen (esimerkiksi juuri siirtäneen pelaajan kuningas on uhattuna), on siirto laiton ja tämä selviää MoveTransision-oliosta.

![Sekvenssikaavio](https://github.com/tiikkala/shakki/blob/master/dokumentointi/ohjelmanKäynnistysAloituspelialaudanLuonti.png)

![Sekvenssikaavio](https://github.com/tiikkala/shakki/blob/master/dokumentointi/valkoinenPelaajaTekeeSiirron.png)
