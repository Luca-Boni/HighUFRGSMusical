package implementacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Bateria extends Instrumento{

    /*private HashMap<Integer, Nota> notas;
    private ArrayList<Integer> teclasFrameAnterior;
    private boolean estaTocando;*/
    
    public Bateria() {
        super("bateria");
    }



    @Override
    public boolean tocar (ArrayList<Tecla> teclas){
        
        boolean estaTocando = false;
        for (Tecla tecla : teclas){

            boolean teclaFoiPressionadaNesteFrame=notas.containsKey(tecla) && !teclasFrameAnterior.contains(tecla);

            if (teclaFoiPressionadaNesteFrame){
                notas.get(tecla).tocarNota();
                estaTocando = true;
            }
        }

        teclasFrameAnterior = teclas;
        return estaTocando;
    }

    public Bateria BateriaCopy() {
        try {
            File arquivoMapNotas = new File("D:/GitHub/HighUFRGSMusical/assets/mapeamento_bateria.txt"); // arquivo texto de
                                                                                                // mapeamento de notas
            Scanner leitorLinha = new Scanner(arquivoMapNotas);
            notas = new HashMap<Tecla, Nota>();
            teclasFrameAnterior = new ArrayList<Tecla>();

            // --------------------------------------------------------------------------------------------------
            // percorre os arquivos de textos e associa as notas as respectivas teclas do
            // teclado:

            while (leitorLinha.hasNextLine()) {
                String linhaLida = leitorLinha.nextLine();
                String[] partes = linhaLida.split("@");
                Tecla tecla = new Tecla(partes[0].codePointAt(0), false);
                String nomeNota = partes[1];
                Nota nota = new Nota(nomeNota, "piano");
                notas.put(tecla, nota);
            }

            // ------------------------------------------------------------------------------------------------

            leitorLinha.close();

        } catch (FileNotFoundException e) {
            System.out.println("Houve um erro na leitura do arquivo de mapeamento das teclas para notas.");
            e.printStackTrace();
        }
        return this;

    }

}
