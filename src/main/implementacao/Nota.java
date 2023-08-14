package implementacao;

import com.raylib.Jaylib;

public class Nota {

    private Jaylib.Sound som;
    private boolean estaTocando;

    public Nota(String nomeNota, String nomeInstrumento) {
        this.som = Jaylib.LoadSound("./assets/sound/" + nomeInstrumento + "/" + nomeNota + ".mp3");
    }

    public void tocarNota() {
        Jaylib.PlaySound(som);
        this.estaTocando = true;
    }

    public void pararNota() {
        Jaylib.StopSound(som);
        this.estaTocando = false;
    }

    public boolean estaTocandoNota(){
        return this.estaTocando;
    }
}
