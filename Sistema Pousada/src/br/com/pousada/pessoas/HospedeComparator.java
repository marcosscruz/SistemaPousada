package br.com.pousada.pessoas;

import java.util.*;

/**
 *
 * Classe Comparator para a classe Cliente/Hóspede
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
// Q.1 - Implementar todas as classes com base no diagrma de classes criado
// Q.13 - Implementar a interface Comparator para as classes Cliente e Reserva
public class HospedeComparator implements Comparator<Hospede> {

    /**
     * Implementação do método comparator para Clientes
     *
     * @param h1 Objeto do tipo cliente
     * @param h2 Objeto do tipo cliente
     * @return Resultado da comparação (0: são iguais | + : h1 é maior que h2 |
     * - : h1 é maior que h2)
     */
    @Override
    public int compare(Hospede h1, Hospede h2) {
        if (h1.getCPF().equals(h2.getCPF())) {
            return 0;
        }
        return h1.getCPF().compareTo(h2.getCPF());
    }

    // Q.3 - Sobrescrevaer o método toString() da todas as classes implementadas
    @Override
    public String toString() {
        return "HospedeComparator";
    }
}
