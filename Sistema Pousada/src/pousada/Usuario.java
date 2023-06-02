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
public class Usuario {

    private String login;
    private String senha;
    private int id;

    // construtor
    public Usuario(String login, String senha, int id) {
        this.login = login;
        this.senha = senha;
        this.id = id;
    }

    // get e set
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // metodos de usuario 
    public void fazerLogin() {

    }

    public void fazerLogout() {

    }
}
