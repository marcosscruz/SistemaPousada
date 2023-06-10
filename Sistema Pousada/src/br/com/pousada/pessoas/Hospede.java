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

    /**
     * Q.11 - Criar duas variáveis de classe (static) que irão armazenar quantas
     * instâncias foram criadas dos tipos Cliente dentro da classe Sistema
     * usando duas soluções diferentes:
     *
     * a. Uma delas utilizando o enfoque de encapsulamento de acordo com a
     * engenharia de software (atributo private static e métodos get e set);
     *
     * b. Na segunda estratégia, implementar usando o controle de acesso do tipo
     * protect;
     */
    private static int hospedeCount1;
    private static int hospedeCount2;

    // Q.4 - Utilizar a palavra chave super para implementar os construtores das subsclasses
    public Hospede(String nomePessoa, String sobrenomePessoa, String CPF, String enderecoHospede, String telefoneHospede, String emailHospde) {
        super(nomePessoa, sobrenomePessoa, CPF);
        this.enderecoHospede = enderecoHospede;
        this.telefoneHospede = telefoneHospede;
        this.emailHospede = emailHospde;
        setHospedeCount1(hospedeCount1);
        setHospedeCount2(hospedeCount2);
    }

    // Construtor padrão realiza uma chamada ao construtor padrão da classe pai (Pessoa)
    // Q.4 - Utilizar a palavra chave super para implementar os construtores das subsclasses
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

    // Q.11 - a. Utilizando o enfoque de encapsulamento de acordo com a engenharia de software
    public static int getHospedeCount1() {
        return hospedeCount1;
    }

    public static void setHospedeCount1(int hospedeCount1) {
        Hospede.hospedeCount1 = hospedeCount1 + 1;
    }

    // Q.11 - b. Usando o controle de acesso do tipo protect
    public static int getHospedeCount2() {
        return hospedeCount2;
    }

    public static void setHospedeCount2(int hospedeCount2) {
        Hospede.hospedeCount2 = hospedeCount2 + 1;
    }

    // Q.3 - Sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return getCPF() + " " + getNomePessoa().toUpperCase() + "   " + getSobrenomePessoa().toUpperCase() + "  " + getEnderecoHospede()
                + "    " + getTelefoneHospede() + "    " + getEmailHospede();
    }
}
