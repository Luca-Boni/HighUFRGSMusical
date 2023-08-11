package implementacao;

import java.util.ArrayList;

public class Bateria extends Instrumento{

    /*private HashMap<Integer, Nota> notas;
    private ArrayList<Integer> notasFrameAnterior;
    private boolean estaTocando;*/
    
    public Bateria(String arquivoNotasNome) {
        super(arquivoNotasNome, "bateria");
    }

    @Override
    public void tocar (ArrayList<Integer> teclas){
        for (int tecla : teclas){
            if (notas.containsKey(tecla) && !notasFrameAnterior.contains(tecla)){
                notas.get(tecla).tocarNota();
            }
        }

        for (Nota nota : notas.values())
            nota.atualizaNota();

        notasFrameAnterior = teclas;
    }

}
