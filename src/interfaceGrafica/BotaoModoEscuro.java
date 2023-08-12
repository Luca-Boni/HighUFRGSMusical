package interfaceGrafica;

import com.raylib.Jaylib;
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

        this.POSICAO = new Jaylib.Vector2(893, 38);

        this.TAMANHO = new Jaylib.Vector2(76, 42);

        Calendar tempoAtual = Calendar.getInstance();

        int horaAtual = tempoAtual.get(Calendar.HOUR_OF_DAY);

boolean estaNoite=horaAtual < 6 || horaAtual >= 18;

        if (estaNoite)
            this.estaModoEscuro = true;
        else
            this.estaModoEscuro = false;
    }

    public void desenha() {
        if (estaModoEscuro)
            Jaylib.DrawTextureEx(TEXTURA_ON, POSICAO, 0, 0.25f, Jaylib.WHITE);
        else
            Jaylib.DrawTextureEx(TEXTURA_OFF, POSICAO, 0, 0.25f, Jaylib.WHITE);
    }

    public boolean foiClicado(){

        if(Jaylib.IsMouseButtonPressed(Jaylib.MOUSE_LEFT_BUTTON)){
            
            @SuppressWarnings("resource")

            Jaylib.Rectangle coordenadasBotao = new Jaylib.Rectangle()
            .x(POSICAO.x())
            .y(POSICAO.y())
            .width(TAMANHO.x())
            .height(TAMANHO.y());

            boolean mouseEstaSobreBotaoModoEscuro=Jaylib.CheckCollisionPointRec(Jaylib.GetMousePosition(), coordenadasBotao);

            if(mouseEstaSobreBotaoModoEscuro){
                this.estaModoEscuro = !this.estaModoEscuro;
                return true;
            }
        }
        return false;
    }

    public boolean estaModoEscuro(){
        return this.estaModoEscuro;
    }

}