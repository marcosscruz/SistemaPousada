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
public class Administrador extends Funcionario {

    // construtor herdado de funcionário que herdou de usuário
    public Administrador(String login, String senha, String nome) {
        super(login, senha, nome);
    }

    // metodos do adm em relação ao gerenciamento de funcionários
    protected void adicionarFuncinario() {

    }

    protected void removerFuncionario() {

    }

    protected void editarFuncionario() {

    }

    // gerenciamento de despesas da pousada
    protected void gerarBalancoMensal() {

    }

}
