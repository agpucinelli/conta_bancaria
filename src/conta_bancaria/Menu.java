package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);		
		
		int opcao;
		
		/*INSTANCIAR OBJETOS DA CLASSE CONTA */
		
		/*Conta c1 = new Conta(1, 123, 1, "Andre", 20000.00f);		
		c1.visualizar();
		
		Conta c2 = new Conta(1, 321, 1, "Tamiris", 200000.00f);
		c2.visualizar();
		
		
		/* Alteração do Saldo*/
		/*c1.setSaldo(300000.00f);
		c1.setTitular("Bob");
		c1.visualizar();
		
		
		/* INSTACIAR OBJETOS DA CLASSE ContaCorrente.
		 * 
		 * 
		 */
		
		ContaCorrente cc1 = new ContaCorrente(3, 789,1, "Andre",10.00f, 10.00f);
		ContaPoupanca cp1 = new ContaPoupanca(3, 789,2, "Andre",10.00f, "10/10/2025", 15000f, 3.0f );
		cc1.visualizar();
		cp1.visualizar();
		cp1.setSaldoP(16000);
		
		System.out.println("\nSacar R$ 10,00 da conta Poupança : " + (cp1.sacar(20.00f) ? 
				cp1.getSaldoP() + "Saque efetuado com sucesso!" :  cp1.getSaldoP() + "Saldo Insuficiente"));
		
		System.out.println("\nSacar R$ 300.000,00 da conta Poupança C2: " + (cp1.sacar(300000.00f) ? 
				"Saque efetuado com sucesso!" : cp1.getSaldoP() + " - Saldo Insuficiente"));
		
		cp1.visualizar();
		
		/**
		 * Saque na conta c2
		 * if ternário
		 * 
		 * condição ? ação se for verdadeiro : ação se for falso
		 * */
		
		/*System.out.println("\nSacar R$ 10,00 da conta : " + (cc1.sacar(20.00f) ? 
				cc1.getSaldo() + "Saque efetuado com sucesso!" :  cc1.getSaldo() + "Saldo Insuficiente"));
		
		System.out.println("\nSacar R$ 300.000,00 da conta C2: " + (cc1.sacar(300000.00f) ? 
				"Saque efetuado com sucesso!" : cc1.getSaldo() + " - Saldo Insuficiente"));
		
		cc1.visualizar();
		cc1.depositar(1000);
		cc1.visualizar();
		
		
		/* Depósito na Conta c2*/
		
		/*c2.depositar(50000.00f);
		c2.visualizar(); 
		
		*/
		
		
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
