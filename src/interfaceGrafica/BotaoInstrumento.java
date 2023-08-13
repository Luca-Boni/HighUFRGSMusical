package interfaceGrafica;

import com.raylib.Jaylib;
import programaPrincipal.ProgramaPrincipal;

public class BotaoInstrumento {

    private static final Jaylib.Vector2 TAMANHO = new Jaylib.Vector2(400*ProgramaPrincipal.ESCALA, 400*ProgramaPrincipal.ESCALA);
    private final Jaylib.Vector2 POSICAO;
    private final Jaylib.Texture2D TEXTURA_ON_CLARO;
    private final Jaylib.Texture2D TEXTURA_OFF_CLARO;
    private final Jaylib.Texture2D TEXTURA_ON_ESCURO;
    private final Jaylib.Texture2D TEXTURA_OFF_ESCURO;
    private final String nomeInstrumento;

    private boolean modoEscuro;
    private boolean estaAtivo = false;

    public BotaoInstrumento(String nomeInstrumento, Jaylib.Vector2 posicao, boolean modoEscuro, boolean estaAtivo) {
        this.TEXTURA_ON_CLARO = Jaylib
                .LoadTexture("./assets/ui/modo_claro/botoes_instrumentos/on/botao_" + nomeInstrumento + "_on.png");
        this.TEXTURA_OFF_CLARO = Jaylib
                .LoadTexture("./assets/ui/modo_claro/botoes_instrumentos/off/botao_" + nomeInstrumento + "_off.png");
        this.TEXTURA_ON_ESCURO = Jaylib
                .LoadTexture("./assets/ui/modo_escuro/botoes_instrumentos/on/botao_" + nomeInstrumento + "_on.png");
        this.TEXTURA_OFF_ESCURO = Jaylib
                .LoadTexture("./assets/ui/modo_escuro/botoes_instrumentos/off/botao_" + nomeInstrumento + "_off.png");
        this.POSICAO = posicao;
        
        this.modoEscuro = modoEscuro;
        this.estaAtivo = estaAtivo;
        this.nomeInstrumento = nomeInstrumento;
    }

    public boolean isModoEscuro() {
        return modoEscuro;
    }

    public boolean getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public String getInstrumento() {
        return nomeInstrumento;
    }

    public Jaylib.Texture2D reverteEstado(boolean modoEscuro) {
        this.modoEscuro = !modoEscuro;
        return retrieveIMG(modoEscuro);
    }

    public Jaylib.Texture2D retrieveIMG(boolean modoEscuro) {
        return modoEscuro ? retrieveIMGEscuro() : retrieveIMGClaro();
    }

    private Jaylib.Texture2D retrieveIMGClaro() {
        return estaAtivo ? TEXTURA_ON_CLARO : TEXTURA_OFF_CLARO;
        // return TEXTURA_OFF;
    }

    private Jaylib.Texture2D retrieveIMGEscuro() {
        return estaAtivo ? TEXTURA_ON_ESCURO : TEXTURA_OFF_ESCURO;
        // return TEXTURA_OFF;
    }

    public void desenha(boolean modoEscuro) {
        Jaylib.DrawTextureEx(retrieveIMG(modoEscuro), POSICAO, 0, ProgramaPrincipal.ESCALA, Jaylib.WHITE);

        @SuppressWarnings("resource")
        Jaylib.Color corTexto = new Jaylib.Color()
                                          .r((byte) 0x51)
                                          .g((byte) 0x51)
                                          .b((byte) 0x51)
                                          .a((byte) 0xFF);


        if(modoEscuro){
            if(estaAtivo)
                corTexto.r((byte) 0xDA)
                        .g((byte) 0x6C)
                        .b((byte) 0x1C)
                        .a((byte) 0xFF);
            else
                corTexto.r((byte) 0x8A)
                        .g((byte) 0x8A)
                        .b((byte) 0x8A)
                        .a((byte) 0xFF);
        }
        else
            if(estaAtivo)
                corTexto.r((byte) 0x44)
                        .g((byte) 0x80)
                        .b((byte) 0xDC)
                        .a((byte) 0xFF);

        String nomeInstrumentoPrimeiraMaiuscula = nomeInstrumento.substring(0, 1).toUpperCase() + nomeInstrumento.substring(1);

        Jaylib.DrawTextEx(InterfaceGrafica.getFonte(), 
                          nomeInstrumentoPrimeiraMaiuscula, 
                          new Jaylib.Vector2(POSICAO.x() + 200*ProgramaPrincipal.ESCALA - Jaylib.MeasureTextEx(InterfaceGrafica.getFonte(), nomeInstrumentoPrimeiraMaiuscula, 90*ProgramaPrincipal.ESCALA, 0).x()/2,
                                             POSICAO.y() + 450*ProgramaPrincipal.ESCALA),
                          90*ProgramaPrincipal.ESCALA,
                          0,
                          corTexto);
    }

    public boolean foiClicado(){

        @SuppressWarnings("resource")

        Jaylib.Rectangle coordenadasBotao = new Jaylib.Rectangle()
        .x(POSICAO.x())
        .y(POSICAO.y())
        .width(TAMANHO.x())
        .height(TAMANHO.y());

        if(!estaAtivo && Jaylib.IsMouseButtonPressed(Jaylib.MOUSE_LEFT_BUTTON)){
            boolean mouseEstaSobreBotaoInstrumento = Jaylib.CheckCollisionPointRec(Jaylib.GetMousePosition(),
                    coordenadasBotao);

            if(mouseEstaSobreBotaoInstrumento){
                estaAtivo = true;
                return true;
            }
        }

        return false;
    }

}
