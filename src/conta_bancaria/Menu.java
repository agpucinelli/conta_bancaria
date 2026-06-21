package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);		
		
		int opcao;
		
		do {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLUE_BACKGROUND);	
		System.out.println("*******************************************************");
		System.out.println("                                                       ");
		System.out.println("                    BANCO MIL GRAU                     ");
		System.out.println("                                                       ");
		System.out.println("*******************************************************");
		System.out.println("                                                       ");
		System.out.println("                  1 - CRIAR CONTA                      ");
		System.out.println("                  2 - LISTAR TODAS CONTAS              ");
		System.out.println("                  3 - BUSCAR CONTA P/ NUMERO           ");
		System.out.println("                  4 - ATUALIZAR DADOS DA CONTA         ");
		System.out.println("                  5 - APAGAR CONTA                     ");
		System.out.println("                  6 - SACAR                            ");
		System.out.println("                  7 - DEPOSITAR                        ");
		System.out.println("                  8 - TRANSFERIR VALORES               ");
		System.out.println("                  0 - SAIR                             ");
		System.out.println("                                                       ");
		System.out.println("*******************************************************");
		
		
		opcao = leia.nextInt();
		
		if(opcao == 0) {
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "BANCO MIL GRAU  - SEMPRE COM VOCE");
		}
		
		switch(opcao) {
		
		case 1:
			System.out.println("Criar conta \n\n");
			break;
		
		case 2:
			System.out.println("Listar contas \n\n");
			break;
		case 3:
			System.out.println("Buscar conta por número \n\n");
			break;
		case 4:
			System.out.println("Atualizar dados da conta \n\n");
			break;
		case 5:
			System.out.println("Apagar conta \n\n");
			break;
		case 6:
			System.out.println("Sacar \n\n");
			break;
		case 7:
			System.out.println("Depositar \n\n");
			break;
		case 8:
			System.out.println("Transferir Valores \n\n");
			break;
		case 0:
			System.out.println("Sair \n\n");
			break;
			
			
		}
		
		
		} while (!(opcao == 0));
			System.out.println("SISTEMA ENCERRADO");
		
		leia.close();
	}

}
