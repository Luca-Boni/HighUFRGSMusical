package interfaceGrafica;

import java.util.ArrayList;

public class SliderVolume {  //provavelmente vai ser completamente reformulada, apenas esboço.

    private String caminhoIMG;

    private ArrayList<Integer> posicao= new ArrayList<Integer>();

    private int volumeAtual;

    private final int volumeMaximo = 100;

    private final int volumeMinimo = 0;



    
    
    public SliderVolume(ArrayList<Integer> posicao) {
        posicao.add(0);
        posicao.add(0);
        posicao.add(0);
        this.volumeAtual = 50;
    }

    public void atualizaVolume(int volume) {
        this.volumeAtual = volume;
        rotaciona(volume);
    }

    public void atualizaPosicao(int x, int y) {
        posicao.set(0, x);
        posicao.set(1, y);
    }

    private void rotaciona(int angulo) {
        posicao.set(2, angulo);
    }


}
