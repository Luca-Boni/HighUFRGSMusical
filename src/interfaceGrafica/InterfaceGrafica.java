package interfaceGrafica;

import implementacao.*;
import programaPrincipal.ProgramaPrincipal;

import com.raylib.Jaylib;
import java.nio.IntBuffer;
import java.util.ArrayList;

public class InterfaceGrafica {

    private BotoesInstrumentos botoesInstrumentos;
    private SliderVolume sliderVolume;
    private BotaoModoEscuro botaoModoEscuro;
    private TecladoInterfaceGrafica tecladoInterfaceGrafica;
    private Jaylib.Texture2D TEXTURA_FUNDO_CLARO;
    private Jaylib.Texture2D TEXTURA_FUNDO_ESCURO;
    private boolean modoEscuro;
    private static final Jaylib.Font fonte = Jaylib.LoadFontEx("./assets/ui/fonts/BwQuintaPro-Light.ttf", 400,
            (IntBuffer) null, 0);

    public InterfaceGrafica() {
        this.botoesInstrumentos = new BotoesInstrumentos(modoEscuro);
        this.sliderVolume = new SliderVolume();
        this.botaoModoEscuro = new BotaoModoEscuro();
        this.tecladoInterfaceGrafica = new TecladoInterfaceGrafica("piano");
        this.TEXTURA_FUNDO_CLARO = Jaylib.LoadTexture("./assets/ui/modo_claro/background.png");
        this.TEXTURA_FUNDO_ESCURO = Jaylib.LoadTexture("./assets/ui/modo_escuro/background.png");

        this.modoEscuro = botaoModoEscuro.estaModoEscuro();

    }

    public boolean selecionaInstrumento() {
        return botoesInstrumentos.selecionaInstrumento();
    }

    public String getInstrumento() {
        return botoesInstrumentos.getInstrumento();
    }

    public void desenha(ArrayList<Tecla> teclas) {

        Jaylib.Color corTexto = new Jaylib.Color();

        if (botaoModoEscuro.foiClicado())
            modoEscuro = !modoEscuro;

        if (modoEscuro) {
            corTexto.r((byte) 0x8A)
                    .g((byte) 0x8A)
                    .b((byte) 0x8A)
                    .a((byte) 0xFF);

            Jaylib.DrawTextureEx(TEXTURA_FUNDO_ESCURO, new Jaylib.Vector2(0, 0), 0, 1, Jaylib.WHITE);
        } else {
            corTexto.r((byte) 0x51)
                    .g((byte) 0x51)
                    .b((byte) 0x51)
                    .a((byte) 0xFF);

            Jaylib.DrawTextureEx(TEXTURA_FUNDO_CLARO, new Jaylib.Vector2(0, 0), 0, 1, Jaylib.WHITE);
        }

        Jaylib.DrawFPS(10, 10);

        Jaylib.DrawTextEx(fonte, "Modo Escuro", new Jaylib.Vector2(3540*ProgramaPrincipal.ESCALA, 320*ProgramaPrincipal.ESCALA), 80*ProgramaPrincipal.ESCALA, 0, corTexto);
        botaoModoEscuro.desenha();
        tecladoInterfaceGrafica.desenha(modoEscuro, teclas);
        botoesInstrumentos.desenha(this.modoEscuro);
        sliderVolume.criaBotaoVolume( modoEscuro, teclas);
        // sliderVolume.desenha(modoEscuro);

    }

}
