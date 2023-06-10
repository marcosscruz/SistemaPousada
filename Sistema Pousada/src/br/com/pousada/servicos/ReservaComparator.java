package br.com.pousada.servicos;

import java.util.*;

/**
 *
 * Classe comparator para a classe Reserva
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
public class ReservaComparator implements Comparator<Reserva> {

    /**
     * Implementação do método Comparator
     *
     * @param r1 Objeto do tipo Pedido
     * @param r2 Objeto do tipo Pedido
     * @return Resultado da comparação (0 : iguais | 1 : r1 é maior que r2 | -1
     * : r1 é menor que r2)
     */
    @Override
    public int compare(Reserva r1, Reserva r2) {
        if (r1.getIdReserva() == r2.getIdReserva()) {
            return 0;
        } else if (r1.getIdReserva() > r2.getIdReserva()) {
            return 1;
        } else {
            return -1;
        }
    }

    // Q.3 - Sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return "ReservaComparator";
    }
}
