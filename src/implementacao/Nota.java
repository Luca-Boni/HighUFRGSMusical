package implementacao;

import com.raylib.Jaylib;

public class Nota {

    private Jaylib.Sound som;

    public Nota(String nomeNota, String nomeInstrumento) {
        this.som = Jaylib.LoadSound("./assets/sound/" + nomeInstrumento + "/" + nomeNota + ".mp3");
    }

    public void tocarNota() {
        Jaylib.PlaySound(som);
    }

    public void pararNota() {
        Jaylib.StopSound(som);
    }
}
