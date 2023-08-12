package implementacao;

import java.util.ArrayList;

public class Piano extends Instrumento {

    public Piano() {
        super("piano");
    }

    public void tocar(ArrayList<Tecla> teclas) {

        for (Tecla tecla : teclas) {
            boolean teclaFoiPressionada = notas.containsKey(tecla);
            if (teclaFoiPressionada) {
                if (!teclasFrameAnterior.contains(tecla))
                    notas.get(tecla).tocarNota();
            }
        }
        for (Tecla tecla : teclasFrameAnterior) {

            boolean teclaPressionadaFrameAnterior = !teclas.contains(tecla) && notas.containsKey(tecla);

            if (teclaPressionadaFrameAnterior) {
                notas.get(tecla).pararNota();
            }
        }
        teclasFrameAnterior = teclas;

    }
}
