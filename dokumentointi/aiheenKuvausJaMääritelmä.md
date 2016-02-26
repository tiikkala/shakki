**Aihe:** Toteutetaan kaksinpelinä pelattava shakkipeli, johon on myöhemmin mahdollista kirjoittaa myös tekoäly. Peliin tulee yksinkertainen graafinen käyttöliittymä.

**Käyttäjät:** Pelaaja/t.

**Ydintoiminnot:**
* Siirron tekeminen
* Voittaminen (ohjelma ilmoittaa matista)

**Mahdolliset laajennukset:**
* Pelin tallennus
* Tekoäly

![Määrittelyvaiheen luokkakaavio](https://github.com/tiikkala/shakki/blob/master/dokumentointi/shakki-UML.png)

Pelilautaa edustaa Board-luokka, ja se koostuu ruutuja edustavista Tile-olioista. Tile-luokka on abstrakti, ja sillä on alaluokat OccupiedTile ja EmptyTile. 

OccupiedTile tuntee ruudussa olean Piecen. Piece on abstrakti luokka, jolla on aluluokkina eri nappuloita edustavat luokat.

![Sekvenssikaavio](https://github.com/tiikkala/shakki/blob/master/dokumentointi/ohjelmanKäynnistysAloituspelialaudanLuonti.png)

![Sekvenssikaavio](https://github.com/tiikkala/shakki/blob/master/dokumentointi/valkoinenPelaajaTekeeSiirron.png)
