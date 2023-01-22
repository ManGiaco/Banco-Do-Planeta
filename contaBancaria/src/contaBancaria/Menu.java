package contaBancaria;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		while (true) {
			System.out.println("**************************************"); 
			System.out.println("           Banco do Planeta           ");
			System.out.println("**************************************");
			System.out.println("                                      ");
			System.out.println("   1- Criar conta                     ");
			System.out.println("   2- Listar todas as contas          ");
			System.out.println("   3- Buscar conta por número         ");
			System.out.println("   4- Atualizar dados da conta        ");
			System.out.println("   5- Apagar conta                    ");
			System.out.println("   6- Sacar dinheiro                  ");
			System.out.println("   7- Depositar dinheiro              ");
			System.out.println("   8- Transferir valores entre contas ");
			System.out.println("   9- Sair                            ");
			System.out.println("                                      ");
			System.out.println("                                      ");
			System.out.println("   Digite a opção desejada:           ");
			System.out.println("                                      ");
			
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println("Obrigada por utilizar os nossos serviços!");
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println("Buscar conta por número\n\n");

				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println("Apagar Conta\n\n");

				break;
			case 6:
				System.out.println("Sacar dinheiro\n\n");

				break;
			case 7:
				System.out.println("Depositar dinheiro\n\n");

				break;
			case 8:
				System.out.println("Transferir valores entre contas\n\n");

				break;
			default:
				System.out.println("\nOpção Inválida! Tente novamente\n");
				break;
			}		
		}
	}
}
