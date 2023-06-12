package br.com.pousada.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.com.pousada.pessoas.Colaborador;

/**
 * Classe intermediária para funcionalidades direcionadas aos Administradores
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
// Q.1 - Implementar todas as classes com base no diagrma de classes criado
public class GerenciadorADM {

    private List<Colaborador> colaboradores = new ArrayList<>();

    // Construtor padrão
    public GerenciadorADM() {
    }

    // get 
    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void addColab(Colaborador colaborador) {
        colaboradores.add(0, colaborador);
    }

    /**
     * Função de cadastro de novos colaboradores no sistema
     * 
     * Q.6 - Deve ser possível cadastrar os colaboradores no sistema, alterar ou
     * editar seus atributos
     */
    public void cadastroColab() {
        String nomeColab, sobrenomeColab, CPF, loginColab, senhaColab;
        Scanner scanner = new Scanner(System.in);

        // entrada de dados
        System.out.printf("Nome: ");
        nomeColab = scanner.nextLine();

        System.out.printf("Sobrenome: ");
        sobrenomeColab = scanner.nextLine();

        do {
            System.out.printf("CPF: ");
            CPF = scanner.nextLine();

            if (validaCPF(CPF) == false || consultaColab(CPF) != null) {
                System.out.println("Número de CPF inválido ou já cadastrado. Tente novamente!");
            }
        } while (validaCPF(CPF) == false || consultaColab(CPF) != null);

        System.out.println("Login: ");
        loginColab = scanner.nextLine();

        System.out.println("Senha: ");
        senhaColab = scanner.nextLine();

        // cadastro
        Colaborador colaborador = new Colaborador(nomeColab, sobrenomeColab, CPF, loginColab, senhaColab);
        addColab(colaborador);
        System.out.println("Cadastro realizado com sucesso!");
    }

    /**
     * Função padrão para a validação do número de CPF
     * 
     * @param cpf dado fornecido pelo usuário
     * @return validade do CPF
     */
    public static boolean validaCPF(String cpf) {
        // verificando se o CPF é formado apenas por números iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999") || (cpf.length() != 11)) {
            System.out.println("CPF inválido. Digite novamente!");
            return false;
        }

        // variáveis do 10º e 11º digito
        char digito10, digito11;
        int soma, r, numero, peso;

        try {
            // calculando o primeiro digito 'verificador'
            soma = 0;
            peso = 0;

            for (int i = 0; i < 9; i++) {
                // o '48' representa o 0 (zero) na tabela ASCII
                numero = (int) (cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            r = 11 - (soma % 11);
            if ((r == 10) || (r == 11)) {
                digito10 = '0';
            } else {
                digito10 = (char) (r + 48);
            }

            // calculando o segundo 'verificador'
            soma = 0;
            peso = 11; // peso é 11 já que o primeiro verificador já foi calculado
            for (int i = 0; i < 10; i++) {
                // x5 é a variável a qual vai receber os valores das somas
                numero = (int) (cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                // o xpeso sempre diminui de uma soma para a outra
                peso = peso - 1;
            }

            r = 11 - (soma % 11);
            if ((r == 10) || (r == 11)) {
                digito11 = '0';
            } else {
                digito11 = (char) (r + 48);
            }

            // valida se os números informados batem o valor com os números
            if (digito10 == cpf.charAt(9) && (digito11 == cpf.charAt(10))) {
                return (true);
            } else {
                System.out.println("CPF inválido. Digite novamente!");
                return (false);
            }
        } catch (Exception exception) {
            System.out.println("Não foi possível validar o CPF!");
            return (false);
        }
    }

    /*
     * Função padrão para consulta a um objeto do tipo Colaborador
     * 
     * @param cpf chave de comparação entre objetos do tipo Colaborador
     * @return objeto do tipo colaborador caso a chave esteja cadastrada no sistema
     */
    public Colaborador consultaColab(String cpf) {
        String cpfColab = cpf;
        Colaborador attColab = null;

        for (Colaborador colab : this.getColaboradores()) {
            if (colab != null) {
                if (cpfColab.equals(colab.getCPF())) {
                    attColab = colab;
                    break;
                }
            }
        }
        return attColab;
    }

    // Q.3 - Sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return "Gerendiador ADM";
    }
}
