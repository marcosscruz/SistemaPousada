package br.com.pousada.pessoas;

/**
 *
 * Classe representativa da entidade Administrador no Sistema
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe Fernades Costa
 */
// Q.1 - Implementar todas as classes com base no diagrama de classes criado
// Q.2 - O sistema será utilizado pelos colaboradores e pelo administrador
public class Administrador extends Funcionario {

    /**
     * Construtor Parametrizado Obs.: Realiza uma chamada ao construtor
     * parametrizado da classe pai (Funcinário)
     *
     * @param nomePessoa      define um nome para o Administrador do programa
     * @param sobrenomePessoa define o sobrenome para o Administrador do programa
     * @param CPF             define o CPF, usado como identificador único, para o
     *                        Administrador do programa
     * @param loginUsuario    define o login utilizado pelo Administrador do
     *                        programa
     * @param senhaUsuario    define a senha utilizada pelo Administrador do
     *                        programa
     */
    // Q.4 - Utilizar a palavra chave super para implementar os construtores das
    // subsclasses
    public Administrador(String nomePessoa, String sobrenomePessoa, String CPF, String loginUsuario,
            String senhaUsuario) {
        super(nomePessoa, sobrenomePessoa, CPF, loginUsuario, senhaUsuario);
    }

    // Construtor padrão realiza uma chamada ao construtor padrão da classe pai
    // (Funcinário)
    // Q.4 - Utilizar a palavra chave super para implementar os construtores das
    // subsclasses
    public Administrador() {
        super();
    }

    // Q.3 - Sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return getCPF() + "    " + getNomePessoa().toUpperCase() + "   " + getSobrenomePessoa().toUpperCase() + "  "
                + getLoginUsuario();
    }
}
