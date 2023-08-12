package implementacao;

import java.util.ArrayList;

public class Bateria extends Instrumento{

    /*private HashMap<Integer, Nota> notas;
    private ArrayList<Integer> teclasFrameAnterior;
    private boolean estaTocando;*/
    
    public Bateria() {
        super("bateria");
    }

    @Override
    public void tocar (ArrayList<Tecla> teclas){
        for (Tecla tecla : teclas){

            boolean teclaFoiPressionadaNesteFrame=notas.containsKey(tecla) && !teclasFrameAnterior.contains(tecla);

            if (teclaFoiPressionadaNesteFrame){
                notas.get(tecla).tocarNota();
            }
        }

        teclasFrameAnterior = teclas;
    }

}
