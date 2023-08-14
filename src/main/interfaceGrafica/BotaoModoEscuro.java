package interfaceGrafica;

import com.raylib.Jaylib;

import programaPrincipal.ProgramaPrincipal;

import java.util.Calendar;

public class BotaoModoEscuro {
    private final Jaylib.Vector2 POSICAO;
    private final Jaylib.Vector2 TAMANHO;
    private final Jaylib.Texture2D TEXTURA_ON;
    private final Jaylib.Texture2D TEXTURA_OFF;
    private boolean estaModoEscuro;

    public BotaoModoEscuro() {

        this.TEXTURA_OFF = Jaylib.LoadTexture("./assets/ui/modo_claro/modo/botao_modo.png");
        this.TEXTURA_ON = Jaylib.LoadTexture("./assets/ui/modo_escuro/modo/botao_modo.png");
        this.POSICAO = new Jaylib.Vector2(3572 * ProgramaPrincipal.ESCALA, 152 * ProgramaPrincipal.ESCALA);
        this.TAMANHO = new Jaylib.Vector2(304 * ProgramaPrincipal.ESCALA, 168 * ProgramaPrincipal.ESCALA);

        Calendar tempoAtual = Calendar.getInstance();

        int horaAtual = tempoAtual.get(Calendar.HOUR_OF_DAY);

        boolean estaNoite = horaAtual < 6 || horaAtual >= 18;

        if (estaNoite)
            this.estaModoEscuro = true;
        else
            this.estaModoEscuro = false;
    }

    public void desenha(Jaylib.Color corTexto) {
        if (estaModoEscuro)
            Jaylib.DrawTextureEx(TEXTURA_ON, POSICAO, 0, ProgramaPrincipal.ESCALA, Jaylib.WHITE);
        else
            Jaylib.DrawTextureEx(TEXTURA_OFF, POSICAO, 0, ProgramaPrincipal.ESCALA, Jaylib.WHITE);
        
        Jaylib.DrawTextEx(InterfaceGrafica.getFonte(), "Modo Escuro", new Jaylib.Vector2(POSICAO.x() - 25*ProgramaPrincipal.ESCALA, POSICAO.y() + 175*ProgramaPrincipal.ESCALA), 80*ProgramaPrincipal.ESCALA, 0, corTexto);
    }

    public boolean foiClicado() {

        if (Jaylib.IsMouseButtonPressed(Jaylib.MOUSE_LEFT_BUTTON)) {

            @SuppressWarnings("resource")

            Jaylib.Rectangle coordenadasBotao = new Jaylib.Rectangle()
                    .x(POSICAO.x())
                    .y(POSICAO.y())
                    .width(TAMANHO.x())
                    .height(TAMANHO.y());

            boolean mouseEstaSobreBotaoModoEscuro = Jaylib.CheckCollisionPointRec(Jaylib.GetMousePosition(),
                    coordenadasBotao);

            if (mouseEstaSobreBotaoModoEscuro) {
                this.estaModoEscuro = !this.estaModoEscuro;
                return true;
            }
        }
        return false;
    }

    public boolean estaModoEscuro() {
        return this.estaModoEscuro;
    }

}