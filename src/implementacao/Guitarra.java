package implementacao;

import java.util.ArrayList;

public class Guitarra extends Instrumento {
    private static final int PALHETA_KEY = 257;

    // private boolean palhetaPressionada = false;
    public Guitarra(String arquivoNotasNome) {
        super("guitarra");

    }

    public void tocar(ArrayList<Tecla> teclas) {

        boolean palhetaFoiPressionada=teclas.contains(PALHETA_KEY) && !teclasFrameAnterior.contains(PALHETA_KEY);
        
        if (palhetaFoiPressionada){
            for (Tecla tecla : teclas) {
                System.out.println(tecla);
                if (notas.containsKey(tecla)) {
                    notas.get(tecla).pararNota();
                    notas.get(tecla).tocarNota();
                }
            }
        }

        for (Tecla tecla : teclasFrameAnterior) {

            boolean teclaFoiDespressionada=!teclas.contains(tecla) && notas.containsKey(tecla);

            if (teclaFoiDespressionada) {
                notas.get(tecla).pararNota();
            }
        }

        teclasFrameAnterior = teclas;
    }
}
