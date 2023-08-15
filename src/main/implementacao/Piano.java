package implementacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Piano extends Instrumento {

    public Piano() {
        super("piano");
    }

    public boolean tocar(ArrayList<Tecla> teclas) {

        boolean estaTocando = false;
        for (Tecla tecla : teclas) {
            boolean teclaFoiPressionada = notas.containsKey(tecla);
            if (teclaFoiPressionada) {
                if (!teclasFrameAnterior.contains(tecla)){
                    notas.get(tecla).tocarNota();
                    estaTocando = true;
                }
            }
        }
        for (Tecla tecla : teclasFrameAnterior) {

            boolean teclaPressionadaFrameAnterior = !teclas.contains(tecla) && notas.containsKey(tecla);

            if (teclaPressionadaFrameAnterior) {
                notas.get(tecla).pararNota();
            }
        }
        teclasFrameAnterior = teclas;
        return estaTocando;
    }

    public Piano PianoCopy() {
        try {
            File arquivoMapNotas = new File("D:/GitHub/HighUFRGSMusical/assets/mapeamento_piano.txt"); // arquivo texto de
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
