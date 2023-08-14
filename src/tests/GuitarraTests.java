package tests;

import implementacao.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class GuitarraTests {
    private final int PALHETA_KEY = 257;
    private final int TECLA_TESTE = 81;
    private Guitarra guitarra = new Guitarra();
    
    @Before
    public void init(){
        this.guitarra = guitarra.GuitarraCopy();
    }

    @Test
    public void testaTocar(){
        ArrayList<Tecla> teclas = new ArrayList<Tecla>();
        teclas.add(new Tecla(TECLA_TESTE, false));
        teclas.add(new Tecla(PALHETA_KEY, false));
        guitarra.setTeclasAnteriores(new ArrayList<Tecla>());
        assertEquals(true, guitarra.tocar(teclas));
    }
    
}