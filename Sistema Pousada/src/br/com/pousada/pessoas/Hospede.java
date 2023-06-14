package br.com.pousada.pessoas;

import java.util.ArrayList;
import br.com.pousada.servicos.*;

/**
 *
 * Classe representativa da entidade Cliente/Hóspede no Sistema
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
// Q.1 - Implementar todas as classes com base no diagrama de classes criado
public class Hospede extends Pessoa {

    private String enderecoHospede;
    private String telefoneHospede;
    private String emailHospede;
    private ArrayList<Reserva> reservasHospede = new ArrayList<>();

    /**
     * Construtor parametrizado para o obejeto Hospede
     * Realiza uma chamada ao construtor parametrizado da classe pai (Pessoa)
     * 
     * @param nomePessoa      define um nome para o Hóspede
     * @param sobrenomePessoa define um sobrenome para o Hóspede
     * @param CPF             define um número de CPF para o Hóspede
     * @param enderecoHospede define um endereço para o Hóspede
     * @param telefoneHospede define um telefone de contato para o Hóspede
     * @param emailHospde     define um email de contato para o Hóspede
     */
    // Q.4 - Utilizar a palavra chave super para implementar os construtores das subsclasses
    public Hospede(String nomePessoa, String sobrenomePessoa, String CPF, String enderecoHospede,
            String telefoneHospede, String emailHospde) {
        super(nomePessoa, sobrenomePessoa, CPF);
        this.enderecoHospede = enderecoHospede;
        this.telefoneHospede = telefoneHospede;
        this.emailHospede = emailHospde;
    }

    // Construtor padrão realiza uma chamada ao construtor padrão da classe pai
    // (Pessoa)
    // Q.4 - Utilizar a palavra chave super para implementar os construtores das
    // subsclasses
    public Hospede() {
        super();
    }

    // getters e setters
    public String getEnderecoHospede() {
        return enderecoHospede;
    }

    public void setEnderecoHospede(String enderecoHospede) {
        this.enderecoHospede = enderecoHospede;
    }

    public String getTelefoneHospede() {
        return telefoneHospede;
    }

    public void setTelefoneHospede(String telefoneHospede) {
        this.telefoneHospede = telefoneHospede;
    }

    public String getEmailHospede() {
        return emailHospede;
    }

    public void setEmailHospede(String emailHospede) {
        this.emailHospede = emailHospede;
    }

    public ArrayList<Reserva> getReservasHospede() {
        return reservasHospede;
    }

    public void setReservasHospede(Reserva novaReserva) {
        this.reservasHospede.add(0, novaReserva);
    }

    // Q.3 - Sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return getCPF() + " " + getNomePessoa().toUpperCase() + "   " + getSobrenomePessoa().toUpperCase() + "  "
                + getEnderecoHospede()
                + "    " + getTelefoneHospede() + "    " + getEmailHospede();
    }
}
