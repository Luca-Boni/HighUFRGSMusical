package implementacao;

import java.util.ArrayList;

public class Baixo extends Instrumento {
    public Baixo(String arquivoNotasNome) {
        super(arquivoNotasNome);
    }

    public void tocar(ArrayList<Integer> teclas) {
        for (int tecla : teclas) {
            if (notas.containsKey(tecla)) {
                if (!notasFrameAnterior.contains(tecla) && teclas.contains(20))
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
