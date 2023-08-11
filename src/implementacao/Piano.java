package implementacao;

import java.util.ArrayList;

public class Piano extends Instrumento{
    
    public Piano(String arquivoNotasNome) {
        super(arquivoNotasNome, "piano");
    }

    public void tocar(ArrayList<Integer> teclas){

        for (int tecla : teclas) {
            if (notas.containsKey(tecla)) {
                if(!notasFrameAnterior.contains(tecla))
                    notas.get(tecla).tocarNota();
                else
                    notas.get(tecla).atualizaNota();
            }
        }
        for (int tecla : notasFrameAnterior) {
            if (!teclas.contains(tecla) && notas.containsKey(tecla)) {
                notas.get(tecla).pararNota();
            }
        }
        notasFrameAnterior = teclas;

    }
}
