package implementacao;

import java.util.ArrayList;

import com.raylib.Jaylib.Vector2;
  

  
public class BotoesInstrumentos {
    private ArrayList<BotaoInstrumento> botoesInstrumentos;
    private ArrayList<Vector2> posicoes;
    // private String caminhoImgBaixo;
    // private String caminhoImgGuitarra;
    // private String caminhoImgBateria;
    // private String caminhoImgPiano;

/*piano: 90
guitarra: 230
baixo: 370
bateria: 510
y 90 para todos*/


    public BotoesInstrumentos() {
        this.posicoes = new ArrayList<Vector2>();
        this.posicoes.add(new Vector2(90, 90));
        this.posicoes.add(new Vector2(230, 90));
        this.posicoes.add(new Vector2(370, 90));
        this.posicoes.add(new Vector2(510, 90));
        this.botoesInstrumentos = new ArrayList<BotaoInstrumento>();
        this.botoesInstrumentos.add(new BotaoInstrumento("baixo", this.posicoes.get(0)));
        this.botoesInstrumentos.add(new BotaoInstrumento("guitarra", this.posicoes.get(1)));
        this.botoesInstrumentos.add(new BotaoInstrumento("bateria", this.posicoes.get(2)));
        this.botoesInstrumentos.add(new BotaoInstrumento("piano", this.posicoes.get(3)));
    }
    

}
