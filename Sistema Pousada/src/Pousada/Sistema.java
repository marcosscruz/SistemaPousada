package Pousada;

import java.io.IOException;
import java.util.Locale;

/**
 * Classe principal para o Sistema da Pousada contendo o método main()
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 * @version 1.0
 */
// Q.1 - Implementar todas as classes com base no diagrama de classes criado
public class Sistema {

    /**
     * 
     * @throws IOException a declaração throws IOException é usada para indicar que o método pode lançar uma exceção relacionada à operação de entrada e saída (IO), como erros ao ler ou escrever arquivos.
     */
    public static void main(String[] args) throws IOException {
        Locale locale = new Locale("pt", "BR");
        Locale.setDefault(locale);
    }

    // Q.3 - Sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return "Sistema Pousada";
    }
}
