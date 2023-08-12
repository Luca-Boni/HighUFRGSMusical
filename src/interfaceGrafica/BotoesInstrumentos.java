package interfaceGrafica;

import java.util.ArrayList;

import com.raylib.Jaylib.Vector2;
import programaPrincipal.ProgramaPrincipal;

public class BotoesInstrumentos {
    private ArrayList<BotaoInstrumento> botoesInstrumentos;
    private ArrayList<Vector2> posicoes;

    // ------------------------------------------------------------------------------------------------------------------------
    // Declara o possicionamento dos botões:

    public BotoesInstrumentos() {
        this.posicoes = new ArrayList<Vector2>();

        final float POSICAO_Y = 160*ProgramaPrincipal.ESCALA;
        this.posicoes.add(new Vector2(160*ProgramaPrincipal.ESCALA, POSICAO_Y));
        this.posicoes.add(new Vector2(720*ProgramaPrincipal.ESCALA, POSICAO_Y));
        this.posicoes.add(new Vector2(1280*ProgramaPrincipal.ESCALA, POSICAO_Y));
        this.posicoes.add(new Vector2(1840*ProgramaPrincipal.ESCALA, POSICAO_Y));

        // ---------------------------------------------------------------------------------------------------

        this.botoesInstrumentos = new ArrayList<BotaoInstrumento>();
        this.botoesInstrumentos.add(new BotaoInstrumento("piano"));
        this.botoesInstrumentos.add(new BotaoInstrumento("guitarra"));
        this.botoesInstrumentos.add(new BotaoInstrumento("baixo"));
        this.botoesInstrumentos.add(new BotaoInstrumento("bateria"));

    }

    public void desenha(boolean modoEscuro) {
        for (int i = 0; i < this.botoesInstrumentos.size(); i++) {
            this.botoesInstrumentos.get(i).desenha(this.posicoes.get(i), modoEscuro);
        }
    }

}
