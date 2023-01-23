package conta;
import java.util.Scanner;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		int opcao;
		
		while (true) {
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "                                           ");
			System.out.println("*******************************************"); 
			System.out.println("              Banco do Planeta             ");
			System.out.println("*******************************************");
			System.out.println("                                           ");
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
		
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println(Cores.ANSI_BLUE_BACKGROUND_BRIGHT + "                                           ");
				System.out.println(Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_BLACK_BOLD + " Obrigada por utilizar os nossos serviços! ");
				System.out.println(Cores.ANSI_BLUE_BACKGROUND_BRIGHT + "                                           ");
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println("\nCriar Conta\n\n");

				break;
			case 2:
				System.out.println("\nListar todas as Contas\n\n");

				break;
			case 3:
				System.out.println("\nBuscar conta por número\n\n");

				break;
			case 4:
				System.out.println("\nAtualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println("\nApagar Conta\n\n");

				break;
			case 6:
				System.out.println("\nSacar dinheiro\n\n");

				break;
			case 7:
				System.out.println("\nDepositar dinheiro\n\n");

				break;
			case 8:
				System.out.println("\nTransferir valores entre contas\n\n");

				break;
			default:
				System.out.println(Cores.ANSI_RED_BACKGROUND + "                                           ");
				System.out.println(Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_BLACK_BOLD + "      Opção inválida! Tente novamente      ");
				System.out.println(Cores.ANSI_RED_BACKGROUND + "                                           ");
				break;
		

			}
		}
	}	
}
