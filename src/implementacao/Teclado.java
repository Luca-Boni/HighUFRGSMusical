package implementacao;

import com.raylib.Jaylib;
import java.util.ArrayList;

public class Teclado {

    // private static final int TECLA_VAZIA = 0;

    public static ArrayList<Integer> leEntradas() {

        ArrayList<Integer> teclasPressionadas = new ArrayList<Integer>();

        for (int tecla = 0; tecla <= 346; tecla++) { // 346 é o maior código associado a uma tecla em Raylib
            if (Jaylib.IsKeyDown(tecla)) {
                teclasPressionadas.add(tecla);
                // System.out.println(tecla);
            }
        }

        return teclasPressionadas;
    }

}