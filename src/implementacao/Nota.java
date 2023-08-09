package implementacao;

import com.raylib.Jaylib;

public class Nota {

    private Jaylib.Music som;
    private double duracao;

    public Nota(String nomeNota, String nomeInstrumento) {
        this.som = Jaylib.LoadMusicStream("./assets/sound/" + nomeInstrumento + "/" + nomeNota + ".mp3");
        this.duracao = Jaylib.GetMusicTimeLength(som);
    }

    public void tocarNota() {
        Jaylib.PlayMusicStream(som);
    }

    public void atualizaNota() {
        if (this.duracao - Jaylib.GetMusicTimePlayed(som) > 0.01){//1.0d / 240d){
            System.out.println (this.duracao - Jaylib.GetMusicTimePlayed(som));
            System.out.println (Jaylib.GetMusicTimePlayed(som));
            Jaylib.UpdateMusicStream(som);
        }
        else
            Jaylib.StopMusicStream(som);
    }

    public void pararNota() {
        Jaylib.StopMusicStream(som);
    }
}
