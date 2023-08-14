package implementacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Guitarra extends Instrumento {
    private static final Tecla PALHETA_KEY = new Tecla(257, false);

    // private boolean palhetaPressionada = false;
    public Guitarra() {
        super("guitarra");

    }

    public boolean tocar(ArrayList<Tecla> teclas) {

        boolean estaTocando = false;
        boolean palhetaFoiPressionada=teclas.contains(PALHETA_KEY) && !teclasFrameAnterior.contains(PALHETA_KEY);
        
        if (palhetaFoiPressionada){
            for (Tecla tecla : teclas) {
                if (notas.containsKey(tecla)) {
                    notas.get(tecla).pararNota();
                    notas.get(tecla).tocarNota();
                    estaTocando = true;
                }
            }
        }

        for (Tecla tecla : teclasFrameAnterior) {

            boolean teclaFoiDespressionada=!teclas.contains(tecla) && notas.containsKey(tecla);

            if (teclaFoiDespressionada) {
                notas.get(tecla).pararNota();
            }
        }

        teclasFrameAnterior = teclas;
        return estaTocando;
    }

    public Guitarra GuitarraCopy() {
        try {
            File arquivoMapNotas = new File("D:/GitHub/HighUFRGSMusical/assets/mapeamento_guitarra.txt"); // arquivo texto de
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
                Nota nota = new Nota(nomeNota, "guitarra");
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
