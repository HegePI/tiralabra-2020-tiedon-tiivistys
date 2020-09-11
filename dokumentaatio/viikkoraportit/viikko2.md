# 2. Viikon raportti

## Mitä olen tehnyt tällä viikolla

Tällä viikolla olen aloittanut toteuttamaan Huffmanin algoritmia. Olen toteutuksessa käyttänyt javan valmiita tietorakenteita (PriorityQueu ja HashMap). Olen saanut toteutettua algoritmin perusperiaatteen, eli algoritmi nyt antaa jokaiselle koompressoitavassa tekstissä olevalle merkille sen bittiesityksen käyttäen huffmanin puuta. Lisäksi algoritmi tallentaa tiedoston merkit tiedostoon käyttäen luotuja merkkien bittiesityksiä. Ohjelma ei kuitenkaan pysty lukemaan dataa tiedostosta ja luomaan alkuperäistä dataa sen perusteella. En ole vielä aloittanut LZW -algoritmin toteuttamista.

## Ohjelman edistyminen

Ohjelma on edistynyt hyvin ja kaikki tarvittavat työkalut on saatu toimimaan projektissa. Ohjelmassa on pilkottu eri algoritmien ja tarvittavien osien toimintaa omiin luokkiinsa.

## Tällä viikolla opittua

Mitä tietorakenteita tarvitaan Huffmanin algoritmin toteuttamiseksi.

## Epäselväksi jäänyttä

Epäselväksi minulle on jäänyt, kuinka pystyn tallentamaan Javassa pelkkiä bittejä tiedostoon. Liäksi minun tulee vielä selvittää, kuinka tallennan algoritmin luoman hajautustaulun tiedostoon ja kuinka saan sen luettua ja luotua uudestaan. Tätä tarvitsen, kun luon huffmanin puun uudestaan, kun muutan tiivistetyn tiedoston biteistä takaisin ymmärrettävään muotoon.

## Mitä teen seuraavaksi

Seuraavksi selvitän, kuinka saan tallennettua tiivistetyn tekstin ja luodun hajautustaulun tiedostoon ja kuinka saan luettua ne sieltä. Lisäksi aloitan paremman ohjelman testaamisen ja alan jo miettiä, kuinka toteutan jo huffmanin algoritmissa käytössä olevat tietorakenteet itse. Jos näiltä tehtäviltä kerkeän, niin alan myös miettiä kuinka alan toteuttamaan LZW -algoritmia.
