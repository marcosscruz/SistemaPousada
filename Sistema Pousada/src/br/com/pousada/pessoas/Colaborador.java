package br.com.pousada.pessoas;

/**
 * CLasse representativa da entidade Colaborador no Sistema
 * 
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe Fernades Costa
 */
// Q.1 - Implementar todas as classes com base no diagrama de classes criado
// Q.2 - O sistema será utilizado pelos colaboradores e pelo administrador
public class Colaborador extends Usuario {

    /**
     * Construtor parametrizado realiza uma chamada para o construtor parametrizado
     * da classe pai (Usuário)
     * 
     * @param nomePessoa      define um nome para o Colaborador
     * @param sobrenomePessoa deifine um sobrenome para o Colaborador
     * @param CPF             define o CPF para o Colaborador
     * @param loginUsusario   define o login de acesso para o Colaborador
     * @param senhaUsuario    define uma senha de acesso para o Colaborador
     */
    // Q.4 - Utilizar a palavra chave super para implementar os construtores das
    // subclasses
    public Colaborador(String nomePessoa, String sobrenomePessoa, String CPF, String loginUsuario, String senhaUsuario) {
        super(nomePessoa, sobrenomePessoa, CPF, loginUsuario, senhaUsuario);
    }

    // Construtor padrão realiza uma chamada ao construtor padrão da classe pai
    // (Usuário)
    // Q.4 - Utilizar a palavra chave super para implementar os construtores das
    // subclasses
    public Colaborador() {
        super();
    }

    // Q.3 - Sobrescrever o método toString() de todas as clsses implementadas
    @Override
    public String toString() {
        return getCPF() + " " + getNomePessoa().toUpperCase() + "   " + getSobrenomePessoa().toUpperCase() + "  " + getLoginUsuario();
    }
}
