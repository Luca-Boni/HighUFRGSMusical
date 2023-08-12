package interfaceGrafica;

import java.util.ArrayList;
import implementacao.Tecla;

import com.raylib.Jaylib;
import com.raylib.Jaylib.Vector2;

public class SliderVolume {  //provavelmente vai ser completamente reformulada, apenas esboço.

    private Jaylib.Texture2D textura_Claro;

    private final int VOLUME_UP = 265;
    
    private final int VOLUME_DOWN = 264;
 
    private Jaylib.Texture2D textura_Escuro;

    private Vector2 posicao;

    private int angulo;

    private float volumeAtual;

    private final int volumeMaximo = 100;

    private final int volumeMinimo = 0;

    public SliderVolume(){
        this.posicao = new Vector2(0,90);
        this.angulo = 0;
        this.volumeAtual = 0.5f;
        this.textura_Claro = Jaylib.LoadTexture("./assets/ui/modo_claro/slider_volume/knob_e_indicador.png");
        this.textura_Escuro = Jaylib.LoadTexture("./assets/ui/modo_escuro/slider_volume/knob_e_indicador.png");
    }

    
    private Jaylib.Texture2D retrieveTexture(boolean modoEscuro){
        return modoEscuro? textura_Escuro : textura_Claro;
    } 
    
    


    private void desenhar (boolean modoEscuro){
        Jaylib.DrawTextureEx(retrieveTexture(modoEscuro), posicao, angulo, 0.25f , Jaylib.WHITE);
    }

    
    public void criaBotaoVolume(boolean modoEscuro,ArrayList<Tecla> teclas) {
        for (Tecla tecla : teclas) {
            if (tecla.equals(new Tecla(VOLUME_UP,false))) {
                volumeAtual += 0.1f;
                angulo += 10;
                
                if (volumeAtual > volumeMaximo) {
                    volumeAtual = volumeMaximo;
                }
                Jaylib.SetMasterVolume(volumeAtual);
            }
            else if (tecla.equals(new Tecla(VOLUME_DOWN,false))){
                volumeAtual -= 0.1f;
                angulo -= 10;
                
                if (volumeAtual < volumeMinimo) {
                    volumeAtual = volumeMinimo;
                }
                Jaylib.SetMasterVolume(volumeAtual);
            }
        }
        desenhar(modoEscuro);

    }

}
