package implementacao;

import java.util.ArrayList;

public class Bateria extends Instrumento{

    /*private HashMap<Integer, Nota> notas;
    private ArrayList<Integer> notasFrameAnterior;
    private boolean estaTocando;*/
    
    public Bateria(String arquivoNotasNome) {
        super (arquivoNotasNome, "bateria");
    }

    public void tocar (ArrayList<Integer> teclas){
        for (int tecla : teclas){
            if (notas.containsKey(tecla)){
                notas.get(tecla).tocarNota();
                if (!notasFrameAnterior.contains(tecla))
                    notasFrameAnterior.add(tecla);
            }
        }

        for (int nota : notasFrameAnterior){
            notas.get(nota).atualizaNota();
            if (!notasFrameAnterior.contains(nota))
                notasFrameAnterior.add(nota);
        }
    }

}
