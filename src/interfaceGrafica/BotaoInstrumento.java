package interfaceGrafica;



import com.raylib.Jaylib;

/**
 * 
 */

public class BotaoInstrumento {
    
        private final Jaylib.Texture2D TEXTURA_ON;
        private final Jaylib.Texture2D TEXTURA_OFF;
        
        private boolean estado = false;
        
    
        public BotaoInstrumento(String nomeInstrumento) {
            this.TEXTURA_ON = Jaylib.LoadTexture("./assets/ui/modo_claro/botoes_instrumentos/on/botao_" + nomeInstrumento + "_on.png");
            this.TEXTURA_OFF = Jaylib.LoadTexture("./assets/ui/modo_claro/botoes_instrumentos/off/botao_" + nomeInstrumento + "_off.png");
        }
        
        
       

        public boolean isEstado() {
            return estado;
        }

        public Jaylib.Texture2D reverteEstado(){
            this.estado = !estado;
            return retrieveIMG();
        }
        private Jaylib.Texture2D retrieveIMG(){
            return estado ? TEXTURA_ON : TEXTURA_OFF;
        }

        public void desenhar (Jaylib.Vector2 posicao){
            Jaylib.DrawTextureEx(retrieveIMG(), posicao, 0, 0.25f, Jaylib.WHITE);
        }

        
}
