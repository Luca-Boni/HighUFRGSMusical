package interfaceGrafica;

import java.util.ArrayList;

import com.raylib.Jaylib.Vector2;
  

  
public class BotoesInstrumentos {
    private ArrayList<BotaoInstrumento> botoesInstrumentos;
    private ArrayList<Vector2> posicoes;
    
//------------------------------------------------------------------------------------------------------------------------
//     Declara o possicionamento dos botões:

    public BotoesInstrumentos() {
        this.posicoes = new ArrayList<Vector2>();

        this.posicoes.add(new Vector2(90, 90));

        this.posicoes.add(new Vector2(230, 90));

        this.posicoes.add(new Vector2(370, 90));

        this.posicoes.add(new Vector2(510, 90));


        //---------------------------------------------------------------------------------------------------


        this.botoesInstrumentos = new ArrayList<BotaoInstrumento>();

        this.botoesInstrumentos.add(new BotaoInstrumento("baixo"));

        this.botoesInstrumentos.add(new BotaoInstrumento("guitarra"));

        this.botoesInstrumentos.add(new BotaoInstrumento("bateria"));

        this.botoesInstrumentos.add(new BotaoInstrumento("piano"));

    }
    
    public void desenhar(boolean modoEscuro) {
        for (int i = 0; i < this.botoesInstrumentos.size(); i++) {
            this.botoesInstrumentos.get(i).desenhar(this.posicoes.get(i), modoEscuro);
        }
    }

}
