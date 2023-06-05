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
public class Funcionario extends Usuario {

    private String nome;
    
    // cosntrutor herdado de usuário com a adição do nome
    public Funcionario(String login, String senha, String nome) {
        super(login, senha);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // métodos que os funcionários e administrador poderam executar
    protected void realizarReserva() {

    }

    protected void cancelarReserva() {

    }

    protected void editarReserva() {

    }

}
