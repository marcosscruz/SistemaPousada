package br.com.pousada.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.com.pousada.pessoas.Colaborador;

/**
 * Classe intermediária para funcionalidades direcionadas aos Administradores,
 * além das funcionalidades que os Funcionários já exercem
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
// Q.1 - Implementar todas as classes com base no diagrma de classes criado
public class GerenciadorAdm extends GerenciadorFunci {

    private List<Colaborador> colaboradores = new ArrayList<>();

    /**
     * Q.4 - Utilizar a palavra chave super para implementar os construtores das
     * subsclasses
     */
    public GerenciadorAdm() {
        super();
    }

    // get
    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void addColab(Colaborador colaborador) {
        colaboradores.add(colaborador);
    }

    public void removeColab(Colaborador colaborador) {
        colaboradores.remove(colaborador);
    }

    /**
     * Função de cadastro de novos colaboradores no sistema
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
     * Função padrão de acesso às opções de modificações do Colaborador
     * Q.6 - Deve ser possível cadastrar os clientes no sistema e alterar seus
     * atributos
     * 
     * @param cpf chave de busca do objeto Colaborador na base de colaboradores
     *            do sistema
     */
    public void editarColab(String cpf) {
        Scanner scanner = new Scanner(System.in);
        boolean menuAnaterior = false;

        do {
            String cpfColab = cpf;
            if (consultaColab(cpfColab) != null) {
                Colaborador edtColab = consultaColab(cpfColab);
                System.out.println("Dados Colaborador");
                System.out.println(edtColab + "\n--------------------------\n");
                System.out.println(
                        "Escolha uma opção: \n1 - Alterar nome \n2 - Alterar CPF \n3 - Alterar login \n4 - Fechar");

                int i = scanner.nextInt();
                Scanner entraDado = new Scanner(System.in);

                switch (i) {
                    case 1: {
                        entraDado = new Scanner(System.in);
                        System.out.printf("Novo nome: ");
                        String dado = entraDado.nextLine();
                        edtColab.setNomePessoa(dado);

                        System.out.printf("Novo sobrenome: ");
                        dado = entraDado.nextLine();
                        edtColab.setSobrenomePessoa(dado);

                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }
                    case 2: {
                        String dado;
                        do {
                            System.out.printf("Novo CPF: ");
                            dado = entraDado.nextLine();
                            if (validaCPF(dado) == false || consultaColab(cpf) != null) {
                                System.out.println("Número de CPF inválido ou já cadastrado. Tente novamente!");
                            }
                        } while (validaCPF(dado) == false || consultaColab(cpf) != null);

                        edtColab.setCPF(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        cpfColab = dado;
                        break;
                    }
                    case 3: {
                        String novoLogin, confirmaLogin;
                        do {
                            System.out.printf("Novo login: ");
                            novoLogin = entraDado.nextLine();
                            System.out.printf("Confirmar novo login: ");
                            confirmaLogin = entraDado.nextLine();

                            if (novoLogin.equals(confirmaLogin)) {
                                edtColab.setLoginUsuario(confirmaLogin);
                                System.out.println("Alteração realizada com sucesso!");
                            } else {
                                System.out.println("Dados não conferem. Tente novamente!\n");
                            }
                        } while (!novoLogin.equals(confirmaLogin));
                        break;
                    }
                    case 4: {
                        menuAnaterior = true;
                        break;
                    }
                    default: {
                        System.out.println("Opção Inválida!");
                    }
                }
            } else {
                System.out.println("CPF Inválido!");
            }
        } while (menuAnaterior == false);
    }

    /**
     * Função padrão para exclusão de um Colaborador
     * Q.6 - Deve ser possível cadastrar os clientes no sistema e alterar seus
     * atributos
     * 
     * @param cpf chave de busca do objeto Colaborador na base de colaboradores do
     *            Sistema
     */
    public void excluirColab(String cpf) {
        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getCPF().equals(cpf)) {
                removeColab(colaborador);
                System.out.println("Alteração feita com sucesso!");
                break;
            }
        }
        System.out.println("CPF não encontrado!");
    }

    /**
     * Função padrão para impressão de dados dos colaboradores do sistema
     */
    public void imprimirColabs() {
        if (colaboradores.isEmpty()) {
            System.out.println("Não há colaboradores cadastrados!");
        } else {
            for (Colaborador colab : colaboradores) {
                System.out.println(colab);
            }
        }
    }

    /**
     * Função para exibição de dados referentes a um colaborador específico
     * cadastrado no Sistema
     * 
     * @param cpf chave de busca do objeto na base de colaboradores do Sistema
     */
    public void imprimirColab(String cpf) {
        Colaborador colaborador = consultaColab(cpf);
        if (colaborador != null) {
            System.out.println(colaborador);
        } else {
            System.out.println("Coloaborador não cadastrado!");
        }
    }

    // =======================================================================================================================================================

    /**
     * Função padrão para a validação do número de CPF repassado como parâmetro
     * em cadastros de Clientes e Colaboradores
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

    // Q.3 - Sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return "Gerendiador Administrador";
    }
}
