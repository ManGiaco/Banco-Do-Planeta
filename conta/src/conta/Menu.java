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

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
	
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
			System.out.println(Cores.ANSI_RESET_BACKGROUND + "                                           ");
			
			try {
				opcao = leia.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}	
			
			if (opcao == 9) {
				System.out.println("");
				System.out.println(Cores.ANSI_BLUE_BACKGROUND_BRIGHT + "                                           ");
				System.out.println(Cores.TEXT_BLACK_BOLD + " OBRIGADA POR UTILIZAR OS NOSSOS SERVIÇOS! ");
				System.out.println("                                           ");
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			
			//------------------------------------------------------------------------//
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "\n* CRIAR CONTA *");
				System.out.println("\nDigite o número da agência: ");
				agencia = leia.nextInt();
	
				System.out.println("\nDigite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				System.out.println("\nDigite o tipo da conta:");
				System.out.println("1- Conta corrente");
				System.out.println("2- Conta poupança");
				tipo = leia.nextInt(); 
				 
				if (tipo != 1 && tipo != 2) {
					System.out.println("                                           ");
					System.out.println(Cores.ANSI_RED_BACKGROUND + "                                           ");
					System.out.println("      OPÇÃO INVÁLIDA! TENTE NOVAMENTE      ");
					System.out.println("                                           " + Cores.ANSI_RESET_BACKGROUND);
					System.out.println("                                           ");
					keyPress();
					break;
				} else {				
				System.out.println("\nDigite o saldo da conta (em reais): ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				
					case 1 -> {
						System.out.println("\nDigite o limite de crédito (em reais): ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
				
					case 2 -> {
						System.out.println("\nDigite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
			}	
			keyPress();
			break;
			
			//------------------------------------------------------//
				
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "\n* LISTA DE TODAS AS CONTAS *");
				contas.listarTodas();
				keyPress();
				break;
			
			//-------------------------------------------------------
				
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "\n* BUSCAR CONTA POR NÚMERO *");
				System.out.println("\nDigite o número da conta: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			
			//---------------------------------------------------------
				
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "\n* ATUALIZAR DADOS DA CONTA *");
				System.out.println("\nDigite o número da conta: ");
				numero = leia.nextInt();
				
				if (contas.buscarNaCollection(numero) != null) {
					
					System.out.println("\nDigite o Numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("\nDigite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					System.out.println("\nDigite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					tipo = contas.retornaTipo(numero);
					
					switch(tipo) {
						case 1 -> {
							System.out.println("\nDigite o Limite de Crédito (R$): ");
							limite = leia.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("\nDigite o dia do Aniversario da Conta: ");
							aniversario = leia.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default ->{
							System.out.println("");				
							System.out.println(Cores.ANSI_RED_BACKGROUND + "                                  ");
							System.out.println(Cores.ANSI_RESET_BACKGROUND + Cores.TEXT_WHITE_BOLD + "      TIPO DE CONTA INVÁLIDO      ");
							System.out.println(Cores.ANSI_RED_BACKGROUND + "                                   ");
							System.out.println(Cores.ANSI_RESET_BACKGROUND + "");
							
						}
					}
					
				}else {
				System.out.println("");				
				System.out.println(Cores.ANSI_RED_BACKGROUND +   "                                 ");
				System.out.println(Cores.ANSI_RESET_BACKGROUND + "      CONTA NÃO ENCONTRADA!      ");
				System.out.println(Cores.ANSI_RED_BACKGROUND +   "                                 ");
				System.out.println(Cores.ANSI_RESET_BACKGROUND + "");
				}					
				keyPress();
				break;
				
			//------------------------------------------
				
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "\n* APAGAR CONTA *");
				System.out.println("\nDigite o número da conta: ");
				numero = leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
				
			//--------------------------------------------	
				
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "\n* SACAR *");
				System.out.println("\nDigite o Numero da conta: ");
				numero = leia.nextInt();	
				do {
					System.out.println("\nDigite o Valor do Saque (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				contas.sacar(numero, valor);
				keyPress();
				break;
				
			//---------------------------------------------	
				
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "\n* DEPOSITAR *");
				System.out.println("\nDigite o Numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("\nDigite o Valor do Depósito (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				contas.depositar(numero, valor);
				keyPress();
				break;
				
			//----------------------------------------------	
				
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "\n* TRANFERÊNCIA ENTRE CONTAS *");
				System.out.println("\nDigite o Numero da Conta de Origem: ");
				numero = leia.nextInt();
				System.out.println("\nDigite o Numero da Conta de Destino: ");
				numeroDestino = leia.nextInt();
				do {
					System.out.println("\nDigite o Valor da Transferência (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);		
				keyPress();
				break;
				
			//--------------------------------------------------
				
			default:
				System.out.println(Cores.ANSI_RED_BACKGROUND + "                                           ");
				System.out.println(Cores.ANSI_RESET_BACKGROUND + "      OPÇÃO INVÁLIDA! TENTE NOVAMENTE      ");
				System.out.println(Cores.ANSI_RED_BACKGROUND + "                                           ");
				System.out.println(Cores.ANSI_RESET_BACKGROUND + "                                           ");
				keyPress();
				break;
			}
		}
	}	
		
	
	public static void keyPress() {

		try {
			System.out.println(Cores.TEXT_RESET + "Pressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
