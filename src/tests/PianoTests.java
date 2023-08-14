package tests;

import implementacao.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class PianoTests {
    private final int TECLA_TESTE = 81;
    private Piano piano = new Piano();
    
    @Before
    public void init(){
        this.piano = piano.PianoCopy();
    }

    @Test
    public void testaTocar(){
        ArrayList<Tecla> teclas = new ArrayList<Tecla>();
        teclas.add(new Tecla(TECLA_TESTE, false));
        piano.setTeclasAnteriores(new ArrayList<Tecla>());
        assertEquals(true, piano.tocar(teclas));
    }
}