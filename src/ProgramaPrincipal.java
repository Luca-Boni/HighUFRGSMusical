import implementacao.*;
import com.raylib.Jaylib;

public class ProgramaPrincipal {

    public static void main(String[] args) throws Exception {
        Jaylib.InitWindow(800, 450, "raylib [core] example - basic window");
        Jaylib.SetTargetFPS(240);
        Jaylib.InitAudioDevice();

        Instrumento aa = new Instrumento("./assets/mapeamentoNotas.txt");

        while (!Jaylib.WindowShouldClose()) {

            aa.tocar(Teclado.leEntradas());
            Jaylib.BeginDrawing();
            Jaylib.ClearBackground(Jaylib.RAYWHITE);

            Jaylib.DrawText(String.valueOf(Jaylib.GetFPS()), 190, 300, 20, Jaylib.LIGHTGRAY);
            Jaylib.EndDrawing();
        }
    }

}
