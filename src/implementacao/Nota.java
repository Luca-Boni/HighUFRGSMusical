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

    public void atualizaNota() {
        /*if (this.duracao - Jaylib.GetSoundTimePlayed(som) > 0.01){//1.0d / 240d){
            if(Jaylib.IsSoundPlaying(som)){
                System.out.println (this.duracao - Jaylib.GetSoundTimePlayed(som));
                System.out.println (Jaylib.GetSoundTimePlayed(som));
            }
            Jaylib.UpdateSoundStream(som);
        }
        else
            Jaylib.StopSoundStream(som);*/
        //Jaylib.UpdateSound(som);
    }

    public void pararNota() {
        Jaylib.StopSound(som);
    }
}
