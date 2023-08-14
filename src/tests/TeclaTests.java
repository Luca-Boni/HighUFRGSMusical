package tests;

import implementacao.Tecla;
import static org.junit.Assert.*;

import org.junit.Test;

public class TeclaTests {
    @Test
    public void TeclaTest() {
        Tecla tecla = new Tecla('a', false);
        assertEquals('A', tecla.getTecla());
        
        tecla = new Tecla('b', true);
        assertEquals('B', tecla.getTecla());

        tecla = new Tecla('[', false);
        assertEquals(']', tecla.getTecla());
    }

    @Test
    public void equalsTest() {
        Tecla tecla1 = new Tecla('a', false);
        Tecla tecla2 = new Tecla('a', false);
        Tecla tecla3 = new Tecla('a', true);
        Tecla tecla4 = new Tecla('b', false);
        Tecla tecla5 = new Tecla('b', true);
        Tecla tecla6 = new Tecla('[', false);
        Tecla tecla7 = new Tecla(']', true);

        assertTrue(tecla1.equals(tecla2));
        assertTrue(tecla1.equals(tecla3));
        assertFalse(tecla1.equals(tecla4));
        assertFalse(tecla1.equals(tecla5));
        assertTrue(tecla6.equals(tecla7));
    }
}
