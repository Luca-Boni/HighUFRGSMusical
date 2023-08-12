package interfaceGrafica;

import com.raylib.Jaylib;
import programaPrincipal.ProgramaPrincipal;

/**
 * 
 */

public class BotaoInstrumento {

    private final Jaylib.Texture2D TEXTURA_ON_CLARO;
    private final Jaylib.Texture2D TEXTURA_OFF_CLARO;
    private final Jaylib.Texture2D TEXTURA_ON_ESCURO;
    private final Jaylib.Texture2D TEXTURA_OFF_ESCURO;

    private boolean estado = false;

    public BotaoInstrumento(String nomeInstrumento) {
        this.TEXTURA_ON_CLARO = Jaylib
                .LoadTexture("./assets/ui/modo_claro/botoes_instrumentos/on/botao_" + nomeInstrumento + "_on.png");
        this.TEXTURA_OFF_ESCURO = Jaylib
                .LoadTexture("./assets/ui/modo_claro/botoes_instrumentos/off/botao_" + nomeInstrumento + "_off.png");
        this.TEXTURA_ON_ESCURO = Jaylib
                .LoadTexture("./assets/ui/modo_escuro/botoes_instrumentos/on/botao_" + nomeInstrumento + "_on.png");
        this.TEXTURA_OFF_CLARO = Jaylib
                .LoadTexture("./assets/ui/modo_escuro/botoes_instrumentos/off/botao_" + nomeInstrumento + "_off.png");

    }

    public boolean isEstado() {
        return estado;
    }

    public Jaylib.Texture2D reverteEstado(boolean modoEscuro) {
        this.estado = !estado;
        return retrieveIMG(modoEscuro);
    }

    public Jaylib.Texture2D retrieveIMG(boolean modoEscuro) {
        return modoEscuro ? retrieveIMGClaro() : retrieveIMGEscuro();
    }

    private Jaylib.Texture2D retrieveIMGClaro() {
        return estado ? TEXTURA_ON_CLARO : TEXTURA_OFF_CLARO;
        // return TEXTURA_OFF;
    }

    private Jaylib.Texture2D retrieveIMGEscuro() {
        return estado ? TEXTURA_ON_ESCURO : TEXTURA_OFF_ESCURO;
        // return TEXTURA_OFF;
    }

    public void desenha(Jaylib.Vector2 posicao, boolean modoEscuro) {
        Jaylib.DrawTextureEx(retrieveIMG(modoEscuro), posicao, 0, ProgramaPrincipal.ESCALA, Jaylib.WHITE);
    }

}
