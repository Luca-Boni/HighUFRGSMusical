import implementacao.*;
import interfaceGrafica.*;

import com.raylib.Jaylib;
import java.util.ArrayList;


public class ProgramaPrincipal {

    public static void main(String[] args) throws Exception {
        
        ProgramaPrincipal.inicializaJanela();
        //Jaylib.Font fonte = Jaylib.LoadFontEx("./assets/ui/fonts/BwQuintaPro-Light.ttf", 400, (IntBuffer)null, 0);
        // exemplo de como carregar fonte

        Instrumento aa = new Piano();
        BotaoModoEscuro bb = new BotaoModoEscuro();
        TecladoInterfaceGrafica tecladointerface = new TecladoInterfaceGrafica("piano");
        ArrayList<Tecla> teclas;

        while (!Jaylib.WindowShouldClose()) {

            teclas = Teclado.leEntradas();
            aa.tocar(teclas);
            bb.desenha();
            bb.foiClicado();
            tecladointerface.desenha(bb.estaModoEscuro(), teclas);
            Jaylib.BeginDrawing();
            Jaylib.ClearBackground(Jaylib.RAYWHITE);

            

            //Jaylib.DrawTextEx(fonte, String.valueOf(Jaylib.GetFPS()), new Jaylib.Vector2(100, 100), 100, 20, Jaylib.LIGHTGRAY);
            Jaylib.DrawText(String.valueOf(Jaylib.GetFPS()), 100, 100, 100, Jaylib.BLACK);
            // exemplo de como desenhar texto com fonte custom
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
