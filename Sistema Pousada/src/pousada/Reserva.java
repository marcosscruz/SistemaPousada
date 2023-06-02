/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pousada;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author marcos
 */
public class Reserva {

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double preco;
    private String numeroCartao;
    private Quarto quarto;

    // construtor
    public Reserva(LocalDate dataInicio, LocalDate dataFim, double preco, String numeroCartao, Quarto quarto) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.preco = preco;
        this.numeroCartao = numeroCartao;
        this.quarto = quarto;
    }

    // get e set
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    // metodos
    public void realizarReservaPreliminar() {
        // colentando dados do hóspede
        Scanner scanner = new Scanner(System.in);
        System.out.print("Data início: (DD/MM/AAAA)");
        String dataInicioStr = scanner.nextLine();
        LocalDate dataInicio = LocalDate.parse(dataInicioStr);

        System.out.print("Data fim: (DD/MM/AAAA)");
        String dataFimStr = scanner.nextLine();
        LocalDate dataFim = LocalDate.parse(dataFimStr);

        System.out.print("Número do cartão de Crédito: ");
        String numeroCartao = scanner.nextLine();

        // verifica se há quartos
        boolean disponivel = quarto.verificarDisponibilidade(dataInicio, dataFim);

        if (disponivel) {
            // calcula o preço da reserva preliminar
            double preco = calcularPreco(dataInicio, dataFim);

            // cria a reserva preliminar
            Reserva reservaPreliminar = new Reserva(dataInicio, dataFim, preco, numeroCartao, quarto);
            System.out.print("Reserva preliminar realizada com sucesso!");
            System.out.println(reservaPreliminar.toString());
        } else {
            System.out.println("Desculpe, o quarto não está disponível para as datas informadas.");
        }
    }

    private double calcularPreco(LocalDate dataInicio, LocalDate dataFim) {
        // calcula a quantidade de dias da reserva
        long dias = ChronoUnit.DAYS.between(dataInicio, dataFim);
        // classe ChronoUnit do pacote java.time.temporal para calcular a diferença em dias

        // definindo o preço de acordo com o tipo do quarto
        double precoBase = quarto.isTipo() ? 200.0 : 100.0; // valor hipotetico pra os preços de cada quarto

        // supondo que a diaria será no valor de 50.0
        double precoTotal = precoBase * dias + 50.0 * dias;

        return precoTotal;
    }

    public boolean verificarDisponibilidade() {

    }

    public void confirmarReserva() {

    }

    public void cancelarReserva() {

    }

}
