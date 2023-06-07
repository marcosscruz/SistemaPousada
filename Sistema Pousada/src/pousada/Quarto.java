/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pousada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marcos
 */
public class Quarto {

    private int numero; // pode se interpretar o número de cada quarto sendo seu respectivo Id
    private boolean estado; // ocupado, disponivel, em reforma, etc...
    private boolean tipo; // quarto de luxo ou quarto comum
    private List<Reserva> reservas;

    private static Quarto[] quartosLuxo = new Quarto[5];
    private static Quarto[] quartosComuns = new Quarto[5];
    private static int contadorLuxo;
    private static int contadorComum;

    // construtor
    public Quarto(int numero, boolean estado, boolean tipo) {
        this.numero = numero;
        this.estado = estado;
        this.tipo = tipo;
        this.reservas = new ArrayList<>();
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

    public List<Reserva> getReservas() {
        return reservas;
    }

    // metodo estatico para os quartos da pousada
    public static void adicionarQuarto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número do quarto: (1 à 10)");
        int numero = scanner.nextInt();

        System.out.print("Estado do quarto: (true - disponível || false - ocupado, etc...) ");
        boolean estado = scanner.nextBoolean();

        System.out.print("Tipo do quarto: (true - luxo || false - comum) ");
        boolean tipo = scanner.nextBoolean();

        Quarto quarto = new Quarto(numero, estado, tipo);

        if (tipo == true) {
            if (contadorLuxo < quartosLuxo.length) {
                quartosLuxo[contadorLuxo] = quarto;
                contadorLuxo++;
                System.out.print("Quarto de luxo reservado com sucesso!");
            } else {
                System.out.print("Não foi possível reservar o quarto de luxo!");
            }
        } else {
            if (contadorComum < quartosComuns.length) {
                quartosComuns[contadorComum] = quarto;
                contadorComum++;
                System.out.print("Quarto comum reservado com sucesso!");
            } else {
                System.out.print("Não foi possível reservar o quarto comum!");
            }
        }
    }

    public static void removerQuarto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número do quarto a ser removido: ");
        int numero = scanner.nextInt();

        boolean removido = false;

        if (removerQuartoLuxo(numero)) {
            removido = true;
        } else if (removerQuartoComum(numero)) {
            removido = true;
        }

        if (removido) {
            System.out.print("Quarto removido com sucesso!");
        } else {
            System.out.print("Quarto não encontrado!");
        }
    }

    public static boolean removerQuartoLuxo(int numero) {
        for (int i = 0; i < contadorLuxo; i++) {
            if (quartosLuxo[i].getNumero() == numero) {
                for (int j = 0; j < contadorLuxo; j++) {
                    quartosLuxo[j] = quartosLuxo[j + 1];
                }
                quartosLuxo[contadorLuxo - 1] = null;
                contadorLuxo--;
                return true;
            }
        }
        return false;
    }

    public static boolean removerQuartoComum(int numero) {
        for (int i = 0; i < contadorComum; i++) {
            if (quartosComuns[i].getNumero() == numero) {
                for (int j = 0; j < contadorComum; j++) {
                    quartosComuns[j] = quartosComuns[j + 1];
                }
                quartosComuns[contadorComum - 1] = null;
                contadorComum--;
                return false;
            }
        }
        return false;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public boolean verificarDisponibilidade(LocalDate dataInicio, LocalDate dataFim) {
        for (Reserva reserva : reservas) {
            LocalDate reservaInicio = reserva.getDataInicio();
            LocalDate reservaFim = reserva.getDataFim();

            if (dataInicio.isBefore(dataInicio) && dataFim.isAfter(dataFim)
                    || (dataFim.isAfter(reservaInicio) && dataFim.isBefore(reservaFim))
                    || (dataInicio.isEqual(reservaInicio) || dataFim.isEqual(reservaFim))) {
                return false; // data indisponível 
            }
        }
        return true; // data disponível 
    }

    public void realizarReservaDefinitiva(Reserva reserva) {
        if (estado) {
            System.out.println("Quarto já ocupado!");
            return;
        }

        LocalDate umMesAntes = LocalDate.now().plusMonths(1);
        if (reserva.getDataInicio().isBefore(umMesAntes)) {
            System.out.println("Não foi possível realizar a reserva definitiva, prazo expirado!");
            return;
        }

        estado = true; // atualiza estado do quarto para ocupado
        adicionarReserva(reserva); // adiciona reserva a lista de reservas

        System.out.println("Reserva definitiva confirmada!");
        System.out.println(toString());
    }
}
