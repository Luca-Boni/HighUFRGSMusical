import implementacao.*;
import interfaceGrafica.*;

import com.raylib.Jaylib;
import java.util.ArrayList;


public class ProgramaPrincipal {

    public static void main(String[] args) throws Exception {
        
        ProgramaPrincipal.inicializaJanela();

        Instrumento instrumento = new Bateria();
        
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
        Jaylib.InitWindow(1200, 600, "raylib [core] example - basic window");
        Jaylib.SetTargetFPS(240);
        Jaylib.InitAudioDevice();
        Jaylib.SetMasterVolume(0.5f);
    }

}
