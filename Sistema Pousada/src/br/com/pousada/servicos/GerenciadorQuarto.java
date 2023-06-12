package br.com.pousada.servicos;

/**
 * Classe intermediária para as funcionalidades dos Quartos
 * 
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
// Q.1 - Implementar todas as classes com base no diagrama de classes criado
public class GerenciadorQuarto {

    // Construtor padrão
    public GerenciadorQuarto() {
    }

    // Q.5 - O sistema deverá armazenar de forma estática os 10 quartos da pousada.
    private static Quarto quartosLuxo[] = new Quarto[5];
    private static Quarto quartosComum[] = new Quarto[5];

    /**
     * 
     * @return Lista de quartos cadastrados no Sistema
     * 
     */
    public static Quarto[] getQuartosLuxo() {
        return quartosLuxo;
    }

    public static Quarto[] getQuartosComum() {
        return quartosComum;
    }

    /**
     * Função para adição de novos quartos de luxo à lista mantida pelo Sistema
     * 
     * @param quarto objeto quarto a ser adicionado à lista de quartos de luxo
     */
    public void adicionarQuartoLuxo(Quarto quarto) {
        for (int i = 0; i < 5; i++) {
            if (GerenciadorQuarto.quartosLuxo[i] == null) {
                GerenciadorQuarto.quartosLuxo[i] = quarto;
                break;
            }
        }
    }

    /**
     * Função para adição de novos quartos comuns à lista mantida pelo Sistema
     * 
     * @param quarto objeto quarto a ser adicionado à lista de quartos comuns
     */
    public void adicionarQuartoComum(Quarto quarto) {
        for (int i = 0; i < 5; i++) {
            if (GerenciadorQuarto.quartosComum[i] == null) {
                GerenciadorQuarto.quartosComum[i] = quarto;
                break;
            }
        }
    }

    /**
     * 
     * @param quartos lista de objetos Quarto representando a lista de quartos de
     *                luxo e comuns
     */
    public static void setQuartosLuxo(Quarto[] quartos) {
        GerenciadorQuarto.quartosLuxo = quartos;
    }

    public static void setQaurtosComum(Quarto[] quartos) {
        GerenciadorQuarto.quartosComum = quartos;
    }
}
