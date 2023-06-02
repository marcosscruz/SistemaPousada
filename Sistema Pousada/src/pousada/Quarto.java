/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pousada;

/**
 *
 * @author marce
 */
public class Quarto {

    private int numero;
    private boolean estado; // ocupado, disponivel, em reforma, etc...
    private boolean tipo; // quarto de luxo ou quarto comum

    // construtor
    public Quarto(int numero, boolean tipo) {
        this.numero = numero;
        this.estado = false;
        this.tipo = tipo;
    }

    // get e set
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    // metodo estatico para os quartos da pousada
    public static Quarto[] iniciandoQuartos() {
        Quarto[] quartos = new Quarto[10];
        for (int i = 0; i < quartos.length; i++) {
            if (i < 5) {
                quartos[i] = new Quarto(i + 1, true); // quartos luxos
            } else {
                quartos[i] = new Quarto(i + 1, false); // quartos comuns

            }
        }
        return quartos;
    }
}
