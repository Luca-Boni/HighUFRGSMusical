package programaPrincipal;
import implementacao.*;
import interfaceGrafica.*;

import com.raylib.Jaylib;
import java.util.ArrayList;

public class ProgramaPrincipal {

    public static final float ESCALA = 0.35f;

    public static void main(String[] args) throws Exception {
        
        ProgramaPrincipal.inicializaJanela();

        Instrumento instrumento = new Piano();
        
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
        ArrayList<Tecla> teclas;

        while (!Jaylib.WindowShouldClose()) {

            teclas = Teclado.leEntradas();
            interfaceGrafica.desenha(teclas);
            instrumento.tocar(teclas);

            Jaylib.BeginDrawing();
            Jaylib.ClearBackground(Jaylib.RAYWHITE);
            
            Jaylib.EndDrawing();
        }
    }

    private static void inicializaJanela() {
        Jaylib.InitWindow((int)(4800*ESCALA), (int)(2400*ESCALA), "High UFRGS Musical - Road to INFinity");
        Jaylib.SetTargetFPS(240);
        Jaylib.InitAudioDevice();
        Jaylib.SetMasterVolume(0.5f);
    }

}
