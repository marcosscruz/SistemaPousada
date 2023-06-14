package br.com.pousada.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.pousada.pessoas.Hospede;

/**
 * Classe intermediária para funcionalidades direcionadas aos Administradores
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
// Q.1 - Implementar todas as classes com base no diagrma de classes criado
public class GerenciadorFunci {

    private List<Hospede> hospedeQuartos = new ArrayList<>(); // lista de hóspedes

    // Q.5 - O sistema deverá armazenar de forma estática os 10 quartos da pousada.
    private static Quarto quartosLuxo[] = new Quarto[5];
    private static Quarto quartosComum[] = new Quarto[5];

    /**
     * Q.11 - Criar duas variáveis de classe (static) que irão armazenar quantas
     * instâncias foram criadas dos tipos Cliente dentro da classe Sistema
     * usando duas soluções diferentes:
     *
     * a. Uma delas utilizando o enfoque de encapsulamento de acordo com a
     * engenharia de software (atributo private static e métodos get e set);
     *
     * b. Na segunda estratégia, implementar usando o controle de acesso do tipo
     * protect;
     */
    private static int hospedeCount1 = 0;
    private static int hospedeCount2 = 0;

    // Construtor
    public GerenciadorFunci() {
        setHospedeCount1(hospedeCount1);
        setHospedeCount2(hospedeCount2);
    }

    // Q.11 - a. Utilizando o enfoque de encapsulamento de acordo com a engenharia
    // de software
    // get e set
    public static int getHospedeCount1() {
        return hospedeCount1;
    }

    public static void setHospedeCount1(int hospedeCount1) {
        GerenciadorFunci.hospedeCount1 = hospedeCount1 + 1;
    }

    // Q.11 - b. Usando o controle de acesso do tipo protect
    protected static int getHospedeCount2() {
        return hospedeCount2;
    }

    protected static void setHospedeCount2(int hospedeCount2) {
        GerenciadorFunci.hospedeCount2 = hospedeCount2 + 1;
    }

    /**
     * @return Lista de quartos cadastrados no Sistema
     */
    public static Quarto[] getQuartosLuxo() {
        return quartosLuxo;
    }

    public static Quarto[] getQuartosComum() {
        return quartosComum;
    }

    /**
     * @param quartos lista de objetos Quarto representando a lista de quartos de
     *                luxo e comuns
     */
    public static void setQuartosLuxo(Quarto[] quartos) {
        GerenciadorFunci.quartosLuxo = quartos;
    }

    public static void setQaurtosComum(Quarto[] quartos) {
        GerenciadorFunci.quartosComum = quartos;
    }

    /**
     * Função para adição de novos quartos de luxo à lista mantida pelo Sistema
     * 
     * @param quarto objeto quarto a ser adicionado à lista de quartos de luxo
     */
    public void adicionarQuartoLuxo(Quarto quarto) {
        for (int i = 0; i < 5; i++) {
            if (GerenciadorFunci.quartosLuxo[i] == null) {
                GerenciadorFunci.quartosLuxo[i] = quarto;
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
            if (GerenciadorFunci.quartosComum[i] == null) {
                GerenciadorFunci.quartosComum[i] = quarto;
                break;
            }
        }
    }

    public void cadastroQuarto() {
        int numQuarto, tipoQuarto;
        String statuQaurto = "Disponível";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Número do quarto: ");
        numQuarto = scanner.nextInt();

        System.out.printf("Tipo do quarto (1. Luxo ou 2. Comum): ");
        tipoQuarto = scanner.nextInt();

        boolean condicao = false;
        do {
            if (tipoQuarto == 1) {
                Quarto quarto = new Quarto(numQuarto, statuQaurto, tipoQuarto);
                adicionarQuartoLuxo(quarto);
                statuQaurto = "Reservado";
                condicao = true;
            } else if (tipoQuarto == 2) {
                Quarto quarto = new Quarto(numQuarto, statuQaurto, tipoQuarto);
                adicionarQuartoComum(quarto);
                statuQaurto = "Reservado";
                condicao = true;
            } else {
                System.out.print("Tipo de quarto inválido. Tente novamente!");
            }
        } while (condicao == false);

        System.out.println("Cadastro realizado com sucesso!");
    }

    // Q.3 - sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return "Gerenciador Funcionário.";
    }
}
