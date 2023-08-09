package implementacao;

    public Baixo(String arquivoNotasNome) {
        super(arquivoNotasNome);
    }

    public void tocar(ArrayList<Integer> teclas) {
        if (teclas.contains(PALHETA_KEY) && !notasFrameAnterior.contains(PALHETA_KEY)){
            for (int tecla : teclas) {
                System.out.println(tecla);
                if (notas.containsKey(tecla)) {
                    notas.get(tecla).pararNota();
                    notas.get(tecla).tocarNota();
                }
            }
        }
        else { 
            for (int tecla : teclas){
                if (notas.containsKey(tecla)){
                        notas.get(tecla).atualizaNota();        
                 }
            }
        }
        for (int tecla : notasFrameAnterior) {
            if (!teclas.contains(tecla) && notas.containsKey(tecla)) {
                notas.get(tecla).pararNota();
            }
        }
        notasFrameAnterior = teclas;
    }
}
