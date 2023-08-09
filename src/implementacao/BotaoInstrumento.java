package implementacao;

import java.util.Vector;

import com.raylib.Jaylib;
import com.raylib.Jaylib.Vector2;
import com.raylib.Raylib.Texture2D;

/**
 * 
 */

public class BotaoInstrumento {
        private final Jaylib.Texture2D TEXTURA_ON;
        private final Jaylib.Texture2D TEXTURA_OFF;
        
        private boolean estado = false;
        
    
        public BotaoInstrumento(String nomeInstrumento, Vector2 posicao) {
            this.TEXTURA_ON = Jaylib.LoadTexture("./assets/ui/modo_claro/botoes_instrumentos/on/botao_" + nomeInstrumento + "_on.png");
            this.TEXTURA_OFF = Jaylib.LoadTexture("./assets/ui/modo_claro/botoes_instrumentos/off/botao_" + nomeInstrumento + "_off.png");
        }
        
        
       

        public boolean isEstado() {
            return estado;
        }

        public Texture2D reverteEstado(){
            this.estado = !estado;
            return retrieveIMG();
        }
        private Texture2D retrieveIMG(){
            return estado ? TEXTURA_ON : TEXTURA_OFF;
        }
    
}
