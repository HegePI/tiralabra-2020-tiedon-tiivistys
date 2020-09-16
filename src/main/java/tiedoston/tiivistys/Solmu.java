package tiedoston.tiivistys;

public class Solmu implements Comparable<Solmu> {

    String merkki;
    int arvo;
    Solmu vasenSolmu;
    Solmu oikeaSolmu;

    /**
     * Solmu luokan konstruktori, jossa annetaan solmun arvo ja solmun merkki.
     * Käytetään, kun luodaan Huffmanin puun lehdet.
     * 
     * @param arvo   Solmun arvo
     * @param merkki Solmun merkki
     */
    public Solmu(Integer arvo, String merkki) {
        this.merkki = merkki;
        this.arvo = arvo;
        vasenSolmu = null;
        oikeaSolmu = null;
    }

    /**
     * Solmu luokan konstruktori, jossa annetaan solmun arvo. Käytetään, kun luodaan
     * Huffmanin puun alipuita.
     * 
     * @param arvo Solmun arvo
     */
    public Solmu(Solmu oikeaSolmu, Solmu vasenSolmu) {
        this.arvo = oikeaSolmu.getArvo() + vasenSolmu.getArvo();
        this.oikeaSolmu = oikeaSolmu;
        this.vasenSolmu = vasenSolmu;
    }

    int getArvo() {
        return this.arvo;
    }

    String getMerkki() {
        return this.merkki;
    }

    Solmu getVasenLapsi() {
        return this.vasenSolmu;
    }

    Solmu getOikeaLapsi() {
        return this.oikeaSolmu;
    }

    @Override
    public int compareTo(Solmu solmu) {
        if (this.arvo >= solmu.arvo) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "(" + this.vasenSolmu + " " + this.merkki + " " + this.oikeaSolmu + ")";
    }
}