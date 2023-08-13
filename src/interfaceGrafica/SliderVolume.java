package interfaceGrafica;

import java.util.ArrayList;
import implementacao.Tecla;
import programaPrincipal.ProgramaPrincipal;

import com.raylib.Jaylib;
import com.raylib.Jaylib.Vector2;

public class SliderVolume {  //provavelmente vai ser completamente reformulada, apenas esboço.

    private Jaylib.Texture2D barraClaro;
    private Jaylib.Texture2D barraEscuro;
    private Jaylib.Texture2D bolaClaro;
    private Jaylib.Texture2D bolaEscuro;

    private Vector2 posicaoBola;
    private final Vector2 POSICAO_BARRA = new Jaylib.Vector2(4400*ProgramaPrincipal.ESCALA, 80*ProgramaPrincipal.ESCALA);

    private final int VOLUME_UP = 265;
    private final int VOLUME_DOWN = 264;

    private float volumeAtual;
    private final float volumeMaximo = 1;
    private final float volumeMinimo = 0;

    public SliderVolume(){
        this.posicaoBola = new Vector2(4390*ProgramaPrincipal.ESCALA, 585*ProgramaPrincipal.ESCALA);
        this.volumeAtual = 0.5f;
        this.barraClaro = Jaylib.LoadTexture("./assets/ui/modo_claro/slider_volume/barra_volume.png");
        this.bolaClaro = Jaylib.LoadTexture("./assets/ui/modo_claro/slider_volume/bola_claro.png");
        this.barraEscuro = Jaylib.LoadTexture("./assets/ui/modo_escuro/slider_volume/barra_volume.png");
        this.bolaEscuro = Jaylib.LoadTexture("./assets/ui/modo_escuro/slider_volume/bola_escuro.png");
    }

    public void desenha(boolean modoEscuro, Jaylib.Color corTexto){ //Tenho que mudar isso daqui
        if (modoEscuro){
            Jaylib.DrawTextureEx(barraEscuro, POSICAO_BARRA, 0, ProgramaPrincipal.ESCALA , Jaylib.WHITE);
            Jaylib.DrawTextureEx(bolaEscuro, posicaoBola, 0, ProgramaPrincipal.ESCALA, Jaylib.WHITE);
        }
        else{
            Jaylib.DrawTextureEx(barraClaro, POSICAO_BARRA, 0, ProgramaPrincipal.ESCALA , Jaylib.WHITE);
            Jaylib.DrawTextureEx(bolaClaro, posicaoBola, 0, ProgramaPrincipal.ESCALA, Jaylib.WHITE);
        }

        Jaylib.DrawTextEx(InterfaceGrafica.getFonte(),
                          "Volume",
                          new Vector2(POSICAO_BARRA.x() - 25*ProgramaPrincipal.ESCALA, POSICAO_BARRA.y() + 1250*ProgramaPrincipal.ESCALA),
                          80*ProgramaPrincipal.ESCALA,
                          0,
                          corTexto);
    }

    
    public void alterouVolume(ArrayList<Tecla> teclas) {
        for (Tecla tecla : teclas) {
            if (tecla.equals(new Tecla(VOLUME_UP,false))) {
                volumeAtual += 0.01f;
                
                if (volumeAtual > volumeMaximo) {
                    volumeAtual = volumeMaximo;
                }
                else{
                    posicaoBola.y(posicaoBola.y() - 11*ProgramaPrincipal.ESCALA);
                }
                Jaylib.SetMasterVolume(volumeAtual);
            }
            else if (tecla.equals(new Tecla(VOLUME_DOWN,false))){
                volumeAtual -= 0.01f;
                
                if (volumeAtual < volumeMinimo) {
                    volumeAtual = volumeMinimo;
                }
                else{
                    posicaoBola.y(posicaoBola.y() + 11*ProgramaPrincipal.ESCALA);
                }
                Jaylib.SetMasterVolume(volumeAtual);
            }
        }
    }

}
