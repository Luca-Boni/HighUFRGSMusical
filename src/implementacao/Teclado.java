package implementacao;

import com.raylib.Jaylib;
import java.util.ArrayList;



public class Teclado {
    
    private static final int maiorTeclaPermitida=346;
    // private static final int TECLA_VAZIA = 0;

        ArrayList<Tecla> teclasPressionadas = new ArrayList<Tecla>();

        for (int teclaCodificada = 0; teclaCodificada <= 346; teclaCodificada++) { // 346 é o maior código associado a uma tecla em Raylib
            if (Jaylib.IsKeyDown(teclaCodificada)) {
                Tecla tecla = new Tecla(teclaCodificada, true);
                teclasPressionadas.add(tecla);
                // System.out.println(tecla);
            }
        }

        return teclasPressionadas;
    }

}