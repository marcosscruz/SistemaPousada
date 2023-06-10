package br.com.pousada.pessoas;

/**
 *
 * Classe abstrata para representação da entidade Pessoa no Sistema
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
public abstract class Pessoa {

    private String nomePessoa;
    private String sobrenomePessoa;
    private String CPF;

    /**
     * Construtor parametrizado
     *
     * @param nomePessoa deifne um nome para a pessoa
     * @param sobrenomePessoa deifne um sobrenome para a pessoa
     * @param CPF define um número de CPF para a pessoa
     */
    public Pessoa(String nomePessoa, String sobrenomePessoa, String CPF) {
        this.nomePessoa = nomePessoa;
        this.sobrenomePessoa = sobrenomePessoa;
        this.CPF = CPF;
    }

    // construtor padrão
    public Pessoa() {

    }

    // getters e setters
    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getSobrenomePessoa() {
        return sobrenomePessoa;
    }

    public void setSobrenomePessoa(String sobrenomePessoa) {
        this.sobrenomePessoa = sobrenomePessoa;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    // Q.3 - sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return CPF + "  " + nomePessoa.toUpperCase() + "    " + sobrenomePessoa.toUpperCase();
    }
}
