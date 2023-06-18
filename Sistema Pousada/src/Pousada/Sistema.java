package Pousada;

import java.io.IOException;
import java.util.Locale;

import br.com.pousada.pessoas.Hospede;
import br.com.pousada.servicos.GerenciadorAdm;
import br.com.pousada.servicos.GerenciadorFunci;
import br.com.pousada.servicos.Reserva;

/**
 * Classe principal para o Sistema da Pousada contendo o método main()
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 * @version 1.0.07
 */
// Q.1 - Implementar todas as classes com base no diagrama de classes criado
public class Sistema {

    /**
     * Q.12 - Criar um método de classe para classe Sistema que deverá retornar
     * quantas instâncias foram criadas dos tipos Cliente e Reserva;
     */
    private static int contadorHospedes = 0;
    private static int contadorReservas = 0;

    /**
     * @return número de instâncias de Hospede/Cliente
     */
    public static int getContadorHospedes() {
        return contadorHospedes;
    }

    /**
     * @return número de instâncias de Reserva
     */
    public static int getContadorReservas() {
        return contadorReservas;
    }

    /**
     * Função responsável por contar o número de instâncias de Hospede/Cliente
     */
    public static void setContadorHospedes() {
        for (Hospede hospede : GerenciadorAdm.getListaHospedes()) {
            if (hospede != null) {
                Sistema.contadorHospedes++;
            }
        }
    }

    /**
     * Função responsável por contar o número de instâncias de Reserva
     */
    public static void setContadorReservas() {
        for (Reserva reserva : GerenciadorFunci.getListaReservas()) {
            if (reserva != null) {
                Sistema.contadorReservas++;
            }
        }
    }

    /**
     * 
     * @param args
     * @throws IOException a declaração throws IOException é usada para indicar que
     *                     o método pode lançar uma exceção relacionada à operação
     *                     de entrada e saída (IO), como erros ao ler ou escrever
     *                     arquivos.
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
