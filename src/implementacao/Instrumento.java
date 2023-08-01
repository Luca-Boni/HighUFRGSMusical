package implementacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public /* abstract */ class Instrumento {

    private HashMap<Integer, Nota> notas;
    private ArrayList<Integer> notasFrameAnterior;
    private boolean estaTocando;

    public Instrumento(String arquivoNotasNome) {

        try {
            File arquivoMapNotas = new File(arquivoNotasNome); // arquivo texto de mapeamento de notas
            Scanner leitorLinha = new Scanner(arquivoMapNotas);
            notas = new HashMap<Integer, Nota>();
            notasFrameAnterior = new ArrayList<Integer>();
            while (leitorLinha.hasNextLine()) {
                String linhaLida = leitorLinha.nextLine();
                String[] partes = linhaLida.split(" ");
                int tecla = partes[0].codePointAt(0);
                tecla = converteTecla(tecla);
                if (tecla >= 'a' && tecla <= 'z')
                    tecla -= 32; // converte para maiúscula
                String nomeNota = partes[1];
                Nota nota = new Nota(nomeNota, "piano");
                notas.put(tecla, nota);
            }
            leitorLinha.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static int converteTecla(int tecla) { // método converte do layout ABNT2 para o layout americano, utilizado
                                                  // pela Raylib
        switch (tecla) {
            case '\'':
                tecla = '`';
                break;
            case ';':
                tecla = '/';
                break;
            case '´':
                tecla = '[';
                break;
            case ']':
                tecla = '\\';
                break;
            case '\\':
                tecla = '¢';
                break;
            case '~':
                tecla = '\'';
                break;
            case '[':
                tecla = ']';
                break;
            case 'ç':
                tecla = ';';
                break;
        }
        return tecla;
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
