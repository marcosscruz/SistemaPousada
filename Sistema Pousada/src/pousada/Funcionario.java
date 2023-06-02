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

    public Funcionario(String login, String senha, int id, String nome) {
        super(login, senha, id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // metodos
    public void fazerReserva() {

    }

    public void cancelarReserva() {

    }

    public void editarReserva() {

    }

}
