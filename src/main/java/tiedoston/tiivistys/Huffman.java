package tiedoston.tiivistys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

    String tiedosto;
    HashMap<String, Integer> merkkienMaarat;
    HashMap<String, String> merkkienBittiesitykset;
    PriorityQueue<Solmu> solmut;

    /**
     * <pre>
     * Konstruktori, joka luo Huffman olion, joka tiivistää ja tarvittaessa purkaa
     * annetun tiedoston.
     * </pre>
     * 
     * @param tiedosto Tiivistettävä tiedosto.
     */
    Huffman(String tiedosto) {
        this.tiedosto = tiedosto;
        this.merkkienMaarat = new HashMap<>();
        this.merkkienBittiesitykset = new HashMap<>();
        this.solmut = new PriorityQueue<>();
    }

    /**
     * <pre>
     * Metodi, joka kompressoi konstruktorissa annetun tiedoston. Käyttää Huffman
     * -olioon kapsuloituja apumetodeja.
     * </pre>
     * 
     * @throws FileNotFoundException Antaa virheen, jos annettua tiedostoa ei löydy.
     */
    void kompressoi() throws FileNotFoundException {
        LaskeTiedostonMerkit();
        luoHuffmaninPuu();
        luoMerkkienBittiesitykset();
        tallennaTiedostoon();
    }

    /**
     * <pre>
     * Metodi, joka laskee jokaisen yksittäisen tiedostossa olevan merkin
     * esiintymislukumäärät ja tallentaa tiedon HashMappiin, jossa avaimena toimii
     * merkki ja arvona luku, joka kertoo kuinka monta kertaa merkki esiintyi
     * tiedostossa.
     * </pre>
     * 
     * @throws FileNotFoundException Antaa virheen, jos annettua tiedostoa ei löydy
     */
    private void LaskeTiedostonMerkit() throws FileNotFoundException {
        File tiedosto = new File(this.tiedosto);
        Scanner lukija = new Scanner(tiedosto);
        while (lukija.hasNext()) {
            String rivi = lukija.nextLine();
            String[] merkit = rivi.split("");
            for (String merkki : merkit) {
                if (merkkienMaarat.containsKey(merkki)) {
                    merkkienMaarat.put(merkki, merkkienMaarat.get(merkki) + 1);
                } else {
                    merkkienMaarat.put(merkki, 1);
                }
            }
        }
        lukija.close();
    }

    /**
     * <pre>
     * Metodi, joka ensimmäisessä vaiheessa luo solmuja jotka sisältävät tiedon
     * yksittäisestä merkistä ja sen esiintymislukumäärästä ja lisää ne
     * prioriteettijonoon. Prioriteettijono ensimmäisenä on solmu, jonka arvo on
     * pienin. Arvo määräytyy merkin esiintymislukumäärän mukaan.
     * 
     * Toisessa vaiheessa metodi ottaa jonosta kaksi solmua kerrallaan ja luo näiden
     * perusteella uuden solmun, jolla ei ole merkkiä ja jonka arvo on kahden solmun
     * arvojen summa. Lisäksi uuden solmun lapsisolmuiksi asetetaan jonosta nostetut
     * solmut ja uusi solmu lisätään prioriteetti jonoon. Tätä käydään kunnes
     * jonossa on enään yksi solmu jäljellä.
     * </pre>
     */
    private void luoHuffmaninPuu() {
        for (String merkki : merkkienMaarat.keySet()) {
            this.solmut.add(new Solmu(this.merkkienMaarat.get(merkki), merkki));
        }

        while (solmut.size() > 1) {
            Solmu eka = solmut.poll();
            Solmu toka = solmut.poll();
            solmut.add(new Solmu(eka.getArvo() + toka.getArvo(), eka, toka));
        }
    }

    /**
     * <pre>
     * Metodi, joka luo jokaisella merkille sitä vastaavan bittiesityksen käyttäen
     * apunaan luotua Huffmanin -puuta. metodi käyttää apunaan rekursiivista metodia
     * rekursio, joka käy koko puun läpi ja tallentaa bittiesitykset HashMappiin,
     * jossa avaimena toimii merkki ja arvona on merkkiä vastaava bittiesitys.
     * </pre>
     */
    private void luoMerkkienBittiesitykset() {
        rekursio(this.solmut.poll(), "");
    }

    /**
     * <pre>
      * Metodi, joka rekursiivisesti käy läpi luodun Huffmanin puun ja tallentaa
      * merkkien bittiesitykset taulukkoon. Aina kun metodi löytää solmun, johon on
      * tallennettu merkki, niin metodi tallentaa merkin ja sitä vastaavan
      * bittiesityksen taulukkoon. Jos solmu ei sisällä merkkiä, niin metodi sii1rtyy
      * solmun oikeaan lapseen lisäten bittiesitykseen merkin '1' ja kun metodi palaa
      * oikeasta lapsesta siirtyy se vasempaan lapseen lisäten bittiesitykseen merkin
      * '0'
     * </pre>
     * 
     * @param solmu       Nykyinen solmu, jossa metodi on. Alussa annetaan
     *                    aloitussolmu, eli prioriteettijonon ainoa solmu.
     * @param bittiEsitys Nykyistä solmua vastaava bittiesitys. Bittiesitys
     *                    tallenetaan tauluun, kun päästään solmuun, jossa on
     *                    merkki.
     */
    private void rekursio(Solmu solmu, String bittiEsitys) {
        if (solmu.getMerkki() != null) {
            this.merkkienBittiesitykset.put(solmu.getMerkki(), bittiEsitys);
            return;
        }
        rekursio(solmu.getOikeaLapsi(), bittiEsitys.concat("1"));
        rekursio(solmu.getVasenLapsi(), bittiEsitys.concat("0"));
    }

    /**
     * Metodi, joka tallentaa tiedoston merkit niiden tiivistetyssä muodossa
     * tiedostoon. Kirjoittaa konsoliin, joko että kirjoittaminen onnistui ja minne
     * tiedostoon data kirjoitettiin, tai virheen stackTracen.
     */
    private void tallennaTiedostoon() {
        String tiedostonNimi = tiedosto.split("\\.")[0];
        File tiedosto = new File(this.tiedosto);
        try (FileOutputStream fos = new FileOutputStream("tiivistetty-" + tiedostonNimi + ".huff")) {
            Scanner lukija = new Scanner(tiedosto);
            while (lukija.hasNextLine()) {
                String[] merkit = lukija.nextLine().split("");
                for (String merkki : merkit) {
                    char[] bitit = merkkienBittiesitykset.get(merkki).toCharArray();
                    BitSet bs = new BitSet(bitit.length);
                    for (int i = 0; i < bitit.length; i++) {
                        if (bitit[i] == '1') {
                            bs.set(i);
                        }
                    }
                    fos.write(bs.toByteArray());
                }
            }
            lukija.close();
            System.out.println("Tiedosto kompressoitu tiedostoon tiivistetty-" + tiedostonNimi + ".huff");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
