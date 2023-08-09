package implementacao;

import java.util.ArrayList;

public class Guitarra extends Instrumento {
    private static final int PALHETA_KEY = 257;

    // private boolean palhetaPressionada = false;
    public Guitarra(String arquivoNotasNome) {
        super(arquivoNotasNome);

    }

    public void tocar(ArrayList<Integer> teclas) {
        if (teclas.contains(PALHETA_KEY) && !notasFrameAnterior.contains(PALHETA_KEY)){//checa se a palheta esta pressionada e se n foi pressionada no frame anterior
            for (int tecla : teclas) {//percorre o array de teclas procurando pelas teclas pressionadas
                System.out.println(tecla);
                if (notas.containsKey(tecla)) {//se a tecla exitsir
                    notas.get(tecla).pararNota();
                    notas.get(tecla).tocarNota();//toca a nota
                }
            }
        }
        else { 
            for (int tecla : teclas){
                if (notas.containsKey(tecla)){
                        notas.get(tecla).atualizaNota();        
                 }
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
