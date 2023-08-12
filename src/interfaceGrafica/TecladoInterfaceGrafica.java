package interfaceGrafica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.raylib.Jaylib;
import implementacao.*;

public class TecladoInterfaceGrafica {

    private final HashMap<Tecla, String> NOTAS;

    private final Jaylib.Texture2D TEXTURA_CLARO;

    private final Jaylib.Texture2D TEXTURA_ESCURO;

    private final HashMap<Tecla, TeclaInterfaceGrafica> TECLAS;

    private int menorOitava;





    public TecladoInterfaceGrafica(String instrumentoNome) {

        this.NOTAS = new HashMap<Tecla, String>();
        this.menorOitava = 99;

        try {
            File arquivoMapNotas = new File("./assets/mapeamento_" + instrumentoNome + ".txt"); // arquivo texto de
                                                                                                // mapeamento de notas
            Scanner leitorLinha = new Scanner(arquivoMapNotas);
            while (leitorLinha.hasNextLine()) {
                String linhaLida = leitorLinha.nextLine();
                String[] partes = linhaLida.split("@");
                Tecla tecla = new Tecla(partes[0].codePointAt(0), false);
                String nomeNota = partes[1];

                char oitavaChar = partes[1].charAt(partes[1].length() - 1);
                int oitava = oitavaChar - '0';
                if (nomeNota.charAt(0) == 'C' && oitava < menorOitava) {
                    this.menorOitava = oitava;
                }
                NOTAS.put(tecla, nomeNota);
            }
            leitorLinha.close();
        } catch (FileNotFoundException e) {
            System.out.println("Houve um erro na leitura do arquivo de mapeamento das teclas para notas.");
            e.printStackTrace();
        }

        this.TECLAS = new HashMap<Tecla, TeclaInterfaceGrafica>();
        for (Tecla tecla : NOTAS.keySet()) {
            String nota = NOTAS.get(tecla);
            TECLAS.put(tecla, new TeclaInterfaceGrafica(nota.substring(0, nota.length() - 1),
                    nota.charAt(nota.length() - 1) - '0' - menorOitava));
        }

        this.TEXTURA_CLARO = Jaylib.LoadTexture("./assets/ui/modo_claro/piano/default.png");
        this.TEXTURA_ESCURO = Jaylib.LoadTexture("./assets/ui/modo_escuro/piano/default.png");
    }

    public void desenha(boolean modoEscuro, ArrayList<Tecla> teclas) {

        if (!modoEscuro) {
            Jaylib.DrawTextureEx(TEXTURA_CLARO, new Jaylib.Vector2(0, 326), 0, 0.25f, Jaylib.WHITE);
        } else {
            Jaylib.DrawTextureEx(TEXTURA_ESCURO, new Jaylib.Vector2(0, 326), 0, 0.25f, Jaylib.WHITE);
        }

        for (Tecla tecla : teclas) {
            if (NOTAS.containsKey(tecla)) {
                String nomeNota = NOTAS.get(tecla);
                int oitava = nomeNota.charAt(nomeNota.length() - 1) - '0' - menorOitava;

                if (oitava >= 0 && oitava < 3) {
                    TECLAS.get(tecla).desenha(modoEscuro);
                }
            }
        }
    }

}
