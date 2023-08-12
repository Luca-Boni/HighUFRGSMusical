package implementacao;

import com.raylib.Jaylib;
import java.util.ArrayList;

public class Teclado {

    public static ArrayList<Tecla> leEntradas() {

        ArrayList<Tecla> teclasPressionadas = new ArrayList<Tecla>();

        for (int teclaCodificada = 0; teclaCodificada <= 346; teclaCodificada++) { // 346 é o maior código associado a uma tecla em Raylib
            if (Jaylib.IsKeyDown(teclaCodificada)) {
                System.out.println("Tecla pressionada: " + teclaCodificada);
                Tecla tecla = new Tecla(teclaCodificada, true);
                teclasPressionadas.add(tecla);
            }
        }

        return teclasPressionadas;
    }

}