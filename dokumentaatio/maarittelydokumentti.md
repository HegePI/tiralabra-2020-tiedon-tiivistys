# Määrittelydokumentti

Projektissa toteutetaan ohjelma, jonka avulla voidaan tiivistää käyttäjän antama tekstitiedosto. Ohjelmassa käyttäjä voi käyttää tämän toteuttamiseksi joko Huffmanin -algoritmia tai LZW -algoritmia. Ohjelma lukee käyttäjän syöttämän tekstitiedoston sisällön ja tulostaa algoritmin tulosteen toiseen tekstitiedostoon.

Ohjelma toteutetaan Javalla.

## Käytettävät tietorakenteet

Huffman -algoritmissa käytetään listaa ja prioritettijonoa. Listaan tallenetaan syötteen eri merkkien esiintymislukumäärä ja prioritettijonoon tallenetaan solmut, joissa on tieto merkistä ja sen esiintymismäärästä. Prioriteettijonon avulla muodostetaan sitten huffmanin -puu, jota hyödyntämällä annettu syöte kompressoidaan. Kompressoitu syöte ja puu tallenetaan sitten tiedostoon. Kun puu tallenetaan kompressoidun syötteen kanssa, niin on jälkikäteen mahdollista muodostaa alkuperäinen syöte.

LZW -algoritmissa toteutetaan lista tietorakenne, jossa on talletettuna syötteen eri merkkijonoja, joita voidaan hakea indeksin perusteella.

## Aika -ja tilavaatimukset

Alustavat aika -ja tilavaatimukset algoritmeille.

| algoritmi | aikavaativuus | tilavaativuus |
| --------- | ------------- | ------------- |
| Huffman   | O(nlogn)      | O(n)          |
| LZW       | O(n)          | O(n)          |

## Lähteet

https://en.wikipedia.org/wiki/Huffman_coding

https://en.wikipedia.org/wiki/Lempel%E2%80%93Ziv%E2%80%93Welch

Pu, I. M., & Pu, I. M. (2005). Fundamental data compression. ProQuest Ebook Central https://ebookcentral-proquest-com.libproxy.helsinki.fi

### Opinto-ohjelma

TKT
