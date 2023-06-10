package br.com.pousada.servicos;

import java.util.Scanner;

/**
 *
 * @author Marcos Vinícius Santos Cruz
 * @author Filipe
 */
public class Sistema {

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            exibirMenu();

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
                    break;
            }
        }
        System.out.println("\nEncerrando o sistema...");
    }

    public void exibirMenu() {
        System.out.println("\n=== Sistema de Gerenciamento de Pousada ===");
        System.out.println("\t1. Adicionar Hóspede");
        System.out.println("\t2. Adicionar Reserva");
        System.out.println("\t3. Exibir Hóspedes");
        System.out.println("\t4. Exibir Quartos Disponíveis");
        System.out.println("\t5. Exibir Reservas Realizadas");
        System.out.println("\t6. Sair");
        System.out.print("\nEscolha uma opção: ");
    }
}
