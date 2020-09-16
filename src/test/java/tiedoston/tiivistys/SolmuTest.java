package tiedoston.tiivistys;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolmuTest {

    Solmu lehtiSolmu;
    Solmu oikeaSolmu;
    Solmu vasenSolmu;
    Solmu juuriSolmu;

    @Before
    public void setUp() {
        lehtiSolmu = new Solmu(1, "a");
        oikeaSolmu = new Solmu(2, "b");
        vasenSolmu = new Solmu(3, "c");
        juuriSolmu = new Solmu(oikeaSolmu, vasenSolmu);
    }

    @Test
    public void testLehtiSolmunArvo() {
        assertEquals(1, lehtiSolmu.getArvo());
    }

    @Test
    public void testLehtiSolmunMerkki() {
        assertEquals("a", lehtiSolmu.getMerkki());
    }

    @Test
    public void testJuuriSolmunArvo() {
        assertEquals(5, juuriSolmu.getArvo());
    }

    @Test
    public void testJuuriSolmunOikeanLapsenMerkki() {
        assertEquals("b", juuriSolmu.getOikeaLapsi().getMerkki());
    }

    @Test
    public void testJuuriSolmunVasenmanLapsenMerkki() {
        assertEquals("c", juuriSolmu.getVasenLapsi().getMerkki());
    }
}
