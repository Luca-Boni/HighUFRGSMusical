package tests;

import implementacao.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class BaixoTests {
    private final int PALHETA_KEY = 257;
    private final int TECLA_TESTE = 81;
    private Baixo baixo = new Baixo();
    
    @Before
    public void init(){
        this.baixo = baixo.baixoCopy();
    }

    @Test
    public void testaTocar(){
        ArrayList<Tecla> teclas = new ArrayList<Tecla>();
        teclas.add(new Tecla(TECLA_TESTE, false));
        teclas.add(new Tecla(PALHETA_KEY, false));
        baixo.setTeclasAnteriores(new ArrayList<Tecla>());
        assertEquals(true, baixo.tocar(teclas));
    }
    
}
