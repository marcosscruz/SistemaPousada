package br.com.pousada.pessoas;

/**
 *
 * Classe representativa da entidade Usuário do Sistema
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
// Q.1 - Implementar todas as classes com base no diagrama de classes criado
public class Usuario extends Pessoa {

    private String loginUsuario;
    private String senhaUsuario;

    /**
     * Construtor Parametrizado Realiza uma chamada ao construtor da classe pai
     * (Pessoa)
     *
     * @param nomePessoa      Define um nome para o usuário
     * @param sobrenomePessoa Define um sobrenome para o usuário
     * @param CPF             Define um número de CPF para o usuário
     * @param loginUsuario    Define um login (e-mail) de acesso para o usuário
     * @param senhaUsuario    Define uma senha de acesso para o usuário
     */
    public Usuario(String nomePessoa, String sobrenomePessoa, String CPF, String loginUsuario, String senhaUsuario) {
        super(nomePessoa, sobrenomePessoa, CPF);
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    // Construtor Padrão Realiza uma chamada ao construtor padrão da classe pai (Pessoa)
    // Questão 4 - Utilizar a palavra chave super para implementar os construtores das subsclasses
    public Usuario() {
        super();
    }

    // getters e setters
    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    // Q.3 - sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return getCPF() + " " + getNomePessoa().toUpperCase() + "   " + getSobrenomePessoa().toUpperCase() + "  "
                + loginUsuario;
    }
}
