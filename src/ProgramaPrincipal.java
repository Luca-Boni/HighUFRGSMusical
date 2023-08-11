import implementacao.*;
import interfaceGrafica.*;

import com.raylib.Jaylib;


public class ProgramaPrincipal {

    public static void main(String[] args) throws Exception {
        
        ProgramaPrincipal.inicializaJanela();
        //Jaylib.Font fonte = Jaylib.LoadFontEx("./assets/ui/fonts/BwQuintaPro-Light.ttf", 400, (IntBuffer)null, 0);
        // exemplo de como carregar fonte

        Instrumento aa = new Bateria("./assets/mapeamentoBateria.txt");
        BotaoModoEscuro bb = new BotaoModoEscuro();

        while (!Jaylib.WindowShouldClose()) {

            aa.tocar(Teclado.leEntradas());
            bb.desenha();
            if(bb.foiClicado())
                System.out.println("clicou");
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
