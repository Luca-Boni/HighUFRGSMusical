package programaPrincipal;

import implementacao.*;
import interfaceGrafica.*;
import com.raylib.Jaylib;
import java.util.ArrayList;

public class ProgramaPrincipal {

    public static final float ESCALA = 0.35f;
    private static final Piano piano = new Piano();
    private static final Guitarra guitarra = new Guitarra();
    private static final Baixo baixo = new Baixo();
    private static final Bateria bateria = new Bateria();

    private static Instrumento instrumento = piano;

    public static void main(String[] args) throws Exception {

        inicializaJanela();

        InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
        ArrayList<Tecla> teclas;

        while (!Jaylib.WindowShouldClose()) {

            teclas = Teclado.leEntradas();
            selecionaInstrumento(interfaceGrafica);

            interfaceGrafica.desenha(teclas);
            instrumento.tocar(teclas);

            atualizaJanela();
        }
    }

    private static void inicializaJanela() {
        Jaylib.InitWindow((int)(4800 * ESCALA), (int)(2400 * ESCALA), "High UFRGS Musical - Road to INFinity");
        Jaylib.SetTargetFPS(240);
        Jaylib.InitAudioDevice();
        Jaylib.SetMasterVolume(0.5f);
    }

    private static void selecionaInstrumento(InterfaceGrafica interfaceGrafica) {
        if (interfaceGrafica.selecionaInstrumento()) {
            String nomeInstrumento = interfaceGrafica.getInstrumento();

            switch (nomeInstrumento) {
                case "piano":
                    instrumento = piano;
                    break;
                case "guitarra":
                    instrumento = guitarra;
                    break;
                case "baixo":
                    instrumento = baixo;
                    break;
                case "bateria":
                    instrumento = bateria;
                    break;
                default:
                    break;
            }
        }
    }

    private static void atualizaJanela(){
        Jaylib.BeginDrawing();
        Jaylib.ClearBackground(Jaylib.RAYWHITE);
        Jaylib.EndDrawing();
    }

}
