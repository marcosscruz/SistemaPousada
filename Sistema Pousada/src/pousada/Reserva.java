/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pousada;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
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
    private List<Hospede> listaHospedes;

    // construtor
    public Reserva(LocalDate dataInicio, LocalDate dataFim, double preco, String numeroCartao, Quarto quarto) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.preco = preco;
        this.numeroCartao = numeroCartao;
        this.quarto = quarto;
        this.listaHospedes = new ArrayList<>();
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

    public List<Hospede> getListaHospedes() {
        return listaHospedes;
    }

    public void setListaHospedes(List<Hospede> listaHospedes) {
        this.listaHospedes = listaHospedes;
    }

    // metodos
    public void realizarReservaPreliminar() { // colentando dados do hóspede

        // coleta dos dados pessoais
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome do Hóspede: ");
        String nome = scanner.nextLine();

        System.out.println("Endereço do Hóspede: ");
        String endereco = scanner.nextLine();

        System.out.println("Telefone do Hóspede: ");
        String telefone = scanner.nextLine();

        System.out.println("E-mail do Hóspede: ");
        String email = scanner.nextLine();

        System.out.println("Pseudo CPF do Hóspede: ");
        int cpf = scanner.nextInt();

        Hospede hospede = new Hospede(nome, endereco, telefone, email, cpf); // cria a instância de hóspede

        listaHospedes.add(hospede); // adiciona o hóspede a lista de hóspedes na classe reserva

        System.out.println("Dados do Hóspede adicionado com sucesso!");

        // dados referente a reserva do(s) quarto(s)
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

            Reserva reservaPreliminar;
            reservaPreliminar = new Reserva(dataInicio, dataFim, preco, numeroCartao, quarto);
            System.out.print("Reserva preliminar realizada com sucesso!");
            System.out.println(reservaPreliminar.toString());
        } else {
            System.out.println("Desculpe, o quarto não está disponível para as datas informadas.");
        }
    }

    public void realizarReservaDefinitiva() {
        // verifica se a reserva preliminar está dentro do prazo
        LocalDate umMesAntes = LocalDate.now().plusMonths(1);
        if (dataInicio.isBefore(umMesAntes)) {
            System.out.print("Prazo para confirmação expirado, reserva não confirmada!");
            return;
        }
        // atualiza o estado do quarto 
        quarto.setEstado(true);
        // reserva preliminar vira definitiva 
        System.out.print("Reserva difinitiva confirmada!");
        System.out.println(toString());
    }

    public double calcularPreco(LocalDate dataInicio, LocalDate dataFim) {
        // calcula a quantidade de dias da reserva
        long dias = ChronoUnit.DAYS.between(dataInicio, dataFim);
        // classe ChronoUnit do pacote java.time.temporal para calcular a diferença em dias

        // definindo o preço de acordo com o tipo do quarto
        double precoBase = quarto.isTipo() ? 200.0 : 100.0; // valor hipotetico pra os preços de cada quarto

        // supondo que a diaria será no valor de 50.0
        double precoTotal = precoBase * dias + 50.0 * dias;

        return precoTotal;
    }
}
