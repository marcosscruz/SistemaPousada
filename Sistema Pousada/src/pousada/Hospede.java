/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pousada;

/**
 *
 * @author marcos
 */
public class Hospede {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private int cpf;  // cpf vai funcionar como o identifcador de cada hóspede

    // cosntrutor
    public Hospede(String nome, String endereco, String telefone, String email, int cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    // set e get
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCfp(int cpf) {
        this.cpf = cpf;
    }

    // sobrescrevendo o classe para toString
    @Override
    public String toString() {
        return String.format(
                "Nome: %s%nEndereço: %s%nTelefone: %s%nE-mail: %s%nPseudo CPF: %s%n",
                nome, endereco, telefone, email, cpf
        );
    }
}
