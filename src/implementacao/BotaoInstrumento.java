package implementacao;

/**
 * 
 */

public class BotaoInstrumento {
        private String caminhoImgON;
        private String caminhoImgOFF;
        private boolean estado;
        
    
        public BotaoInstrumento(String caminhoImgON, String caminhoImgOFF) {
            this.caminhoImgON = caminhoImgON;
            this.caminhoImgOFF = caminhoImgOFF;
        }
        
        public String reverteEstado(){
            this.estado = !estado;
            return retrieveIMG();
        }
        private String retrieveIMG(){
            return estado ? caminhoImgON : caminhoImgOFF;
        }
    
}
