package implementacao;

public class Tecla {
    
    private int tecla;

    public Tecla(int tecla, boolean estaCodificado){
        this.tecla = tecla;
        
        if(!estaCodificado){
            switch (this.tecla) {
                case '\'':
                    this.tecla = '`';
                    break;
                case ';':
                    this.tecla = '/';
                    break;
                case '´':
                    this.tecla = '[';
                    break;
                case ']':
                    this.tecla = '\\';
                    break;
                case '\\':
                    this.tecla = '¢';
                    break;
                case '~':
                    this.tecla = '\'';
                    break;
                case '[':
                    this.tecla = ']';
                    break;
                case 'ç':
                    this.tecla = ';';
                    break;
            }
        }
        
        if (tecla >= 'a' && tecla <= 'z')
                this.tecla -= 32; // converte para maiúscula
    }

    public int getTecla(){
        return this.tecla;
    }


    /* Para garantir que o HashMap de notas em Instrumento funcione corretamente, é preciso sobrescrever os seguintes métodos.
       Isso porque, a cada tecla pressionada, uma nova Tecla é criada, que é diferente da Tecla que está no HashMap.
       O método equals() é usado para comparar se duas Teclas são iguais, e é utilizado na busca no HashMap. */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tecla) {
            Tecla tecla = (Tecla) obj;
            return this.tecla == tecla.getTecla();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.tecla;
    }

}
