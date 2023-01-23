package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
		
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
	
		while (true) {
			
			System.out.println(Cores.ANSI_BLACK_BACKGROUND +  "                                           ");
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "             ******************            "); 
			System.out.println(                               "              BANCO DO PLANETA             ");
			System.out.println(                               "             ******************            ");                                         
			System.out.println(Cores.ANSI_BLACK_BACKGROUND +  "                                           ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "    1-" + Cores.TEXT_BLUE_BOLD + "Criar conta                          ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "    2-" + Cores.TEXT_BLUE_BOLD + "Listar todas as contas               ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "    3-" + Cores.TEXT_BLUE_BOLD + "Buscar conta por número              ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "    4-" + Cores.TEXT_BLUE_BOLD + "Atualizar dados da conta             ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "    5-" + Cores.TEXT_BLUE_BOLD + "Apagar conta                         ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "    6-" + Cores.TEXT_BLUE_BOLD + "Sacar dinheiro                       ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "    7-" + Cores.TEXT_BLUE_BOLD + "Depositar dinheiro                   ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "    8-" + Cores.TEXT_BLUE_BOLD + "Transferir valores entre contas      ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "    9-" + Cores.TEXT_BLUE_BOLD + "Sair                                 ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "                                           ");
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "    Digite a opção desejada:               ");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "                                           ");
		
			try {
				opcao = leia.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}
						
			
			if (opcao == 9) {
				System.out.println(Cores.ANSI_BLUE_BACKGROUND_BRIGHT + "                                           ");
				System.out.println(Cores.TEXT_BLACK_BOLD + " OBRIGADA POR UTILIZAR OS NOSSOS SERVIÇOS! ");
				System.out.println("                                           ");
				leia.close();
				System.exit(0);
			}
			
			
			switch (opcao) {
			
			case 1:
				System.out.println("\nCriar Conta\n\n");
				System.out.println("\nDigite o número da agência: \n\n");
				agencia = leia.nextInt();
				System.out.println("\nDigite o nome do titular: \n\n");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o tipo da conta:");
					System.out.println("1- Conta corrente");
					System.out.println("2- Conta poupança");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);
				
				System.out.println("Digite o saldo da conta (em reais): ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o limite de crédito (em reais): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
			}
				keyPress();
				break;
				
			case 2:
				System.out.println("\nListar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
				
			case 3:
				System.out.println("\nBuscar conta por número\n\n");
				keyPress();
				break;
				
			case 4:
				System.out.println("\nAtualizar dados da Conta\n\n");
				keyPress();
				break;
				
			case 5:
				System.out.println("\nApagar Conta\n\n");
				keyPress();
				break;
				
			case 6:
				System.out.println("\nSacar dinheiro\n\n");
				keyPress();
				break;
				
			case 7:
				System.out.println("\nDepositar dinheiro\n\n");
				keyPress();
				break;
				
			case 8:
				System.out.println("\nTransferir valores entre contas\n\n");
				keyPress();
				break;
				
			default:
				System.out.println(Cores.ANSI_RED_BACKGROUND + "                                           ");
				System.out.println(Cores.TEXT_WHITE_BOLD + "      OPÇÃO INVÁLIDA! TENTE NOVAMENTE      ");
				System.out.println("                                           ");
				keyPress();
				break;
			}
		}
	}	
		
	
	public static void keyPress() {

		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
