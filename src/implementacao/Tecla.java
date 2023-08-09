package implementacao;

public class Tecla {
    public static int converteTecla(int tecla) { // método converte do layout ABNT2 para o layout americano, utilizado
        // pela Raylib
        switch (tecla) {
        case '\'':
        tecla = '`';
        break;
        case ';':
        tecla = '/';
        break;
        case '´':
        tecla = '[';
        break;
        case ']':
        tecla = '\\';
        break;
        case '\\':
        tecla = '¢';
        break;
        case '~':
        tecla = '\'';
        break;
        case '[':
        tecla = ']';
        break;
        case 'ç':
        tecla = ';';
        break;
        }
        return tecla;
    }
}
