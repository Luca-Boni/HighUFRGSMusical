package tests;

import implementacao.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class BateriaTests {
    private final int TECLA_TESTE = (int)'v';
    private Bateria bateria = new Bateria();
    
    @Before
    public void init(){
        this.bateria = bateria.BateriaCopy();
    }

    @Test
    public void testaTocar(){
        ArrayList<Tecla> teclas = new ArrayList<Tecla>();
        teclas.add(new Tecla(TECLA_TESTE, false));
        bateria.setTeclasAnteriores(new ArrayList<Tecla>());
        assertEquals(true, bateria.tocar(teclas));
    }
    
}