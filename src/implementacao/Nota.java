package implementacao;

import com.raylib.Jaylib;

public class Nota {

    private Jaylib.Music som;

    public Nota(String nomeNota, String nomeInstrumento) {
        this.som = Jaylib.LoadMusicStream("./assets/sound/" + nomeInstrumento + "/" + nomeNota + ".mp3");
    }

    public void tocarNota() {
        Jaylib.PlayMusicStream(som);
    }

    public void atualizaNota() {
        Jaylib.UpdateMusicStream(som);
    }

    public void pararNota() {
        Jaylib.StopMusicStream(som);
    }
}
