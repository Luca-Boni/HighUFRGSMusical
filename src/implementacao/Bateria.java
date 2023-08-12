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
            if (notas.containsKey(tecla) && !teclasFrameAnterior.contains(tecla)){
                notas.get(tecla).tocarNota();
            }
        }

        for (Nota nota : notas.values())
            nota.atualizaNota();

        teclasFrameAnterior = teclas;
    }

}
