package implementacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract  class Instrumento {

    protected HashMap<Tecla, Nota> notas;
    protected ArrayList<Tecla> teclasFrameAnterior;
    protected boolean estaTocando;

    public Instrumento(String nomeInstrumento) {

        try {
            File arquivoMapNotas = new File("./assets/mapeamento_" + nomeInstrumento + ".txt"); // arquivo texto de mapeamento de notas
            Scanner leitorLinha = new Scanner(arquivoMapNotas);
            notas = new HashMap<Tecla, Nota>();
            teclasFrameAnterior = new ArrayList<Tecla>();
            while (leitorLinha.hasNextLine()) {
                String linhaLida = leitorLinha.nextLine();
                String[] partes = linhaLida.split("@");
                Tecla tecla = new Tecla(partes[0].codePointAt(0), false);
                String nomeNota = partes[1];
                Nota nota = new Nota(nomeNota, nomeInstrumento);
                notas.put(tecla, nota);
            }
            leitorLinha.close();
        } catch (FileNotFoundException e) {
            System.out.println("Houve um erro na leitura do arquivo de mapeamento das teclas para notas.");
            e.printStackTrace();
        }

    }

    /*public void tocar(ArrayList<Integer> teclas){

        for (int tecla : teclas) {
            if (notas.containsKey(tecla)) {
                if(!teclasFrameAnterior.contains(tecla))
                    notas.get(tecla).tocarNota();
                else
                    notas.get(tecla).atualizaNota();
            }
        }
        for (int tecla : teclasFrameAnterior) {
            if (!teclas.contains(tecla) && notas.containsKey(tecla)) {
                notas.get(tecla).pararNota();
            }
        }
        teclasFrameAnterior = teclas;
    }*/

    public void tocar(ArrayList<Tecla> teclas){}

}
