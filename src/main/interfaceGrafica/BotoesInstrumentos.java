package interfaceGrafica;

import java.util.ArrayList;

import com.raylib.Jaylib.Vector2;
import programaPrincipal.ProgramaPrincipal;

public class BotoesInstrumentos {
    private ArrayList<BotaoInstrumento> botoesInstrumentos;

    // ------------------------------------------------------------------------------------------------------------------------
    // Declara o possicionamento dos botões:

    public BotoesInstrumentos(boolean modoEscuro) {
        
        final float POSICAO_Y = 160*ProgramaPrincipal.ESCALA;

        this.botoesInstrumentos = new ArrayList<BotaoInstrumento>();
        this.botoesInstrumentos.add(new BotaoInstrumento("piano", new Vector2(160*ProgramaPrincipal.ESCALA, POSICAO_Y), modoEscuro, true));
        this.botoesInstrumentos.add(new BotaoInstrumento("guitarra", new Vector2(720*ProgramaPrincipal.ESCALA, POSICAO_Y), modoEscuro, false));
        this.botoesInstrumentos.add(new BotaoInstrumento("baixo", new Vector2(1280*ProgramaPrincipal.ESCALA, POSICAO_Y), modoEscuro, false));
        this.botoesInstrumentos.add(new BotaoInstrumento("bateria", new Vector2(1840*ProgramaPrincipal.ESCALA, POSICAO_Y), modoEscuro, false));
    }

    public void desenha(boolean modoEscuro) {
        for (int i = 0; i < this.botoesInstrumentos.size(); i++) {
            this.botoesInstrumentos.get(i).desenha(modoEscuro);
        }
    }

    public String getInstrumento() {
        for (BotaoInstrumento botao : botoesInstrumentos) {
            if (botao.getEstaAtivo())
                return botao.getInstrumento();
        }
        return null;
    }

    public boolean selecionaInstrumento() {
        for (BotaoInstrumento botao : botoesInstrumentos) {
            if (botao.foiClicado()) {
                
                for (BotaoInstrumento botaoADesselecionar : botoesInstrumentos) {
                    if(botaoADesselecionar != botao)
                        botaoADesselecionar.setEstaAtivo(false);
                }
                return true;
            }
        }
        return false;
    }

}
