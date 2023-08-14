package tests;

import static org.junit.Assert.*;
import implementacao.Nota;
import org.junit.Test;

public class NotaTests {
    private Nota notas = new Nota("D2", "piano");
    @Test
    public void testNota() {
        notas.tocarNota();
        assertEquals(true, notas.estaTocandoNota());
        notas.pararNota();
        assertEquals(false, notas.estaTocandoNota());
        
    }

}