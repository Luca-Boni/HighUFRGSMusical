package interfaceGrafica;

import com.raylib.Jaylib;
import programaPrincipal.ProgramaPrincipal;

public class TeclaInterfaceGrafica {

    private final Jaylib.Vector2 POSICAO;
    private final Jaylib.Texture2D TEXTURA_ON_CLARO;
    private final Jaylib.Texture2D TEXTURA_ON_ESCURO;
    private static float posicaoInicialX = (264*ProgramaPrincipal.ESCALA);
    private static float tamanhoTecla = (204*ProgramaPrincipal.ESCALA);
    private static float tamanhoOitava = (1428*ProgramaPrincipal.ESCALA);

    public TeclaInterfaceGrafica(String nota, int oitava) {

        if (nota.length() == 2) {
            this.TEXTURA_ON_CLARO = Jaylib.LoadTexture("./assets/ui/modo_claro/piano/on/sharp.png");
            this.TEXTURA_ON_ESCURO = Jaylib.LoadTexture("./assets/ui/modo_escuro/piano/on/sharp.png");

            final float POSICAO_Y = 1448*ProgramaPrincipal.ESCALA;

            switch (nota.charAt(0)) {
                case 'C':
                    this.POSICAO = new Jaylib.Vector2(ProgramaPrincipal.ESCALA*380 + oitava * tamanhoOitava, POSICAO_Y);
                    break;
                case 'D':
                    this.POSICAO = new Jaylib.Vector2(ProgramaPrincipal.ESCALA*600 + oitava * tamanhoOitava, POSICAO_Y);
                    break;
                case 'F':
                    this.POSICAO = new Jaylib.Vector2(ProgramaPrincipal.ESCALA*992 + oitava * tamanhoOitava, POSICAO_Y);
                    break;
                case 'G':
                    this.POSICAO = new Jaylib.Vector2(ProgramaPrincipal.ESCALA*1204 + oitava * tamanhoOitava, POSICAO_Y);
                    break;
                case 'A':
                    this.POSICAO = new Jaylib.Vector2(ProgramaPrincipal.ESCALA*1416 + oitava * tamanhoOitava, POSICAO_Y);
                    break;
                default:
                    this.POSICAO = new Jaylib.Vector2(0, 0);
                    break;
            }

        }

        else {
            this.TEXTURA_ON_CLARO = Jaylib.LoadTexture("./assets/ui/modo_claro/piano/on/" + nota + ".png");
            this.TEXTURA_ON_ESCURO = Jaylib.LoadTexture("./assets/ui/modo_escuro/piano/on/" + nota + ".png");

            int posicaoNotaOitava = nota.charAt(0) - 'C';
            if (posicaoNotaOitava < 0) {
                posicaoNotaOitava += 7;
            }

            final float POSICAO_Y = 1468*ProgramaPrincipal.ESCALA;

            this.POSICAO = new Jaylib.Vector2(
                    posicaoInicialX + (posicaoNotaOitava * tamanhoTecla) + tamanhoOitava * oitava, POSICAO_Y);
        }
    }

    public void desenha(boolean modoEscuro) {
        if (!modoEscuro)
            Jaylib.DrawTextureEx(TEXTURA_ON_CLARO, POSICAO, 0, ProgramaPrincipal.ESCALA, Jaylib.WHITE);
        else
            Jaylib.DrawTextureEx(TEXTURA_ON_ESCURO, POSICAO, 0, ProgramaPrincipal.ESCALA, Jaylib.WHITE);
    }

}
