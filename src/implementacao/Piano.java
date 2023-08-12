package implementacao;

import java.util.ArrayList;

public class Piano extends Instrumento{
    
    public Piano() {
        super("piano");
    }

    public void tocar(ArrayList<Tecla> teclas){

        for (Tecla tecla : teclas) {
            
            if (notas.containsKey(tecla)) {
                if(!teclasFrameAnterior.contains(tecla))
                    notas.get(tecla).tocarNota();
                else
                    notas.get(tecla).atualizaNota();
            }
        }
        for (Tecla tecla : teclasFrameAnterior) {
            if (!teclas.contains(tecla) && notas.containsKey(tecla)) {
                notas.get(tecla).pararNota();
            }
        }
        teclasFrameAnterior = teclas;

    }
}
