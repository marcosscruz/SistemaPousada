package br.com.pousada.servicos;

import java.time.*;
import java.time.format.*;
import java.util.ArrayList;

/**
 * Classe representativa da entidade Reserva no Sistema
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
// Q.1 - Implementar todas as classes com base no diagrama de classes criado
public class Reserva {

    private static int numReserva = 0;
    private int idReserva;

    private String dataInicioReserva;
    private String dataFimReserva;
    private String horaReserva;
    private double precoReserva;
    private String numeroCartao;
    private int numeroApartamento;

    private ArrayList<Quarto> listaQuartos = new ArrayList<>();

    /**
     * Construtor parametrizado
     *
     * @param dataInicioReserva define o dia do início da reserva
     * @param dataFimReserva define o fim da reserva
     * @param horaReserva define a hora em que a reserva foi criada
     * @param precoReserva define o valor que a reserva vale
     * @param numeroCartao define os dados do cartão de crédito do cliente
     * @param numeroApartamento define número do quarto
     */
    public Reserva(String dataInicioReserva, String dataFimReserva, String horaReserva, double precoReserva, String numeroCartao, int numeroApartamento) {
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.horaReserva = horaReserva;
        this.precoReserva = precoReserva;
        this.numeroCartao = numeroCartao;
        this.numeroApartamento = numeroApartamento;
    }

    // Construtor padrão
    public Reserva() {
    }

    // getters e setters
    public static int getNumReserva() {
        return numReserva;
    }

    public static void setNumReserva(int numReserva) {
        Reserva.numReserva = numReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva() {
        this.idReserva = Reserva.getNumReserva();
    }

    public String getDataInicioReserva() {
        return dataInicioReserva;
    }

    public void setDataInicioReserva(String dataInicioReserva) {
        this.dataInicioReserva = dataInicioReserva;
    }

    public String getDataFimReserva() {
        return dataFimReserva;
    }

    public void setDataFimReserva(String dataFimReserva) {
        this.dataFimReserva = dataFimReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public double getPrecoReserva() {
        return precoReserva;
    }

    public void setPrecoReserva(double precoReserva) {
        this.precoReserva = precoReserva;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(int numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public ArrayList<Quarto> getListaQuartos() {
        return listaQuartos;
    }

    public void setListaQuartos(ArrayList<Quarto> listaQuartos) {
        this.listaQuartos = listaQuartos;
    }

    // Q.3 - Implementar o método toString() de todas as classes implementadas
    @Override
    public String toString() {// incompleto
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd/mm/aaaa");
        DateTimeFormatter localHourFormatter = DateTimeFormatter.ofPattern("hh:mm");

        String status = " ";

        return getDataInicioReserva() + " " + getDataFimReserva() + " " + getPrecoReserva() + "   " + getNumeroCartao() + "   " + getNumeroApartamento() + "  " + getNumeroCartao();
    }

}
