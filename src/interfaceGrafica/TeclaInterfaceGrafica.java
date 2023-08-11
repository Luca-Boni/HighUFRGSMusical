package interfaceGrafica;

import com.raylib.Jaylib;

public class TeclaInterfaceGrafica {
    
    private final Jaylib.Vector2 POSICAO;
    private final Jaylib.Texture2D TEXTURA_ON_CLARO;
    private final Jaylib.Texture2D TEXTURA_ON_ESCURO;

    private static int posicaoInicialX = 66;
    private static int tamanhoTecla = 51;
    private static int tamanhoOitava = 357;

    public TeclaInterfaceGrafica(String nota, int oitava){
        
        if(nota.length() == 2){
            this.TEXTURA_ON_CLARO = Jaylib.LoadTexture("./assets/ui/modo_claro/piano/on/sharp.png");
            this.TEXTURA_ON_ESCURO = Jaylib.LoadTexture("./assets/ui/modo_escuro/piano/on/sharp.png");
            
            switch(nota.charAt(0)){
                case 'C':
                    this.POSICAO = new Jaylib.Vector2(95 + oitava * tamanhoOitava, 362);
                    break;
                case 'D':
                    this.POSICAO = new Jaylib.Vector2(150 + oitava * tamanhoOitava, 362);
                    break;
                case 'F':
                    this.POSICAO = new Jaylib.Vector2(248 + oitava * tamanhoOitava, 362);
                    break;
                case 'G':
                    this.POSICAO = new Jaylib.Vector2(301 + oitava * tamanhoOitava, 362);
                    break;
                case 'A':
                    this.POSICAO = new Jaylib.Vector2(354 + oitava * tamanhoOitava, 362);
                    break;
                default:
                    this.POSICAO = new Jaylib.Vector2(0, 0);
                    break;
            }
        }
        else{
            this.TEXTURA_ON_CLARO = Jaylib.LoadTexture("./assets/ui/modo_claro/piano/on/" + nota + ".png");
            this.TEXTURA_ON_ESCURO = Jaylib.LoadTexture("./assets/ui/modo_escuro/piano/on/" + nota + ".png");

            int posicaoNotaOitava = nota.charAt(0) - 'C';
            if(posicaoNotaOitava < 0){
                    posicaoNotaOitava += 7;
            }

            this.POSICAO = new Jaylib.Vector2(posicaoInicialX + (posicaoNotaOitava * tamanhoTecla) + tamanhoOitava*oitava, 367);
        }
    }

    public void desenha(boolean modoClaro){
        if(modoClaro)
            Jaylib.DrawTextureEx(TEXTURA_ON_CLARO, POSICAO, 0, 0.25f, Jaylib.WHITE);
        else
            Jaylib.DrawTextureEx(TEXTURA_ON_ESCURO, POSICAO, 0, 0.25f, Jaylib.WHITE);
    }

}
