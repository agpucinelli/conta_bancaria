package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int opcao;
		criarContasTeste();
		
		
		
		
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
		System.out.println("                  9 - CONSULTA POR TITULAR             ");
		System.out.println("                  0 - SAIR                             ");
		System.out.println("                                                       ");
		System.out.println("*******************************************************");
		
		
		
		
		
		try {
			opcao = leia.nextInt();
			leia.nextLine();
		} catch(InputMismatchException e) {
			opcao = -1;
			System.out.println("\nDigite um número inteiro entre 0 e 8");
			leia.nextLine();
		}
		
		if(opcao == 0) {
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "BANCO MIL GRAU  - SEMPRE COM VOCE");
		}
		
		switch(opcao) {
		
		case 1:
			System.out.println("Criar conta \n\n");
			cadastrarConta();
			keyPress();
			break;
		
		case 2:
			System.out.println("Listar contas \n\n");
			listarContas();
			keyPress();
			
			break;
		case 3:
			System.out.println("Buscar conta por número \n\n");
			procurarContaPorNumero();
			keyPress();
			break;
			
		case 4:
			System.out.println("Atualizar dados da conta \n\n");
			atualizarConta();
			keyPress();
			break;
			
		case 5:
			System.out.println("Apagar conta \n\n");
			deletarConta();
			keyPress();
			break;
			
		case 6:
			System.out.println("Sacar \n\n");
			sacar();
			keyPress();
			break;
		case 7:
			System.out.println("Depositar \n\n");
			depositar();
			keyPress();
			break;
		case 8:
			System.out.println("Transferir Valores \n\n");
			transferir();
			keyPress();
			break;
		case 9:
			System.out.println("Transferir Valores \n\n");
			listarPorTitular();
			keyPress();
			break;
		case 0:
			System.out.println("Sair \n\n");
			keyPress();
			leia.close();
			System.exit(0);
			
			
			
			
		}
		
		
		
		
		
		
		
		} while (!(opcao == 0));
			System.out.println("SISTEMA ENCERRADO");
		
		leia.close();
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}	
	
	public static void listarContas() {
		contaController.listarTodas();
	}
	
	
	public static void  criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Tamiris Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(
				new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
	}

	public static void cadastrarConta() {
		System.out.println("Digite o numero da agencia: ");
		int agencia = leia.nextInt();
		System.out.println("Digite o nome do titular da conta: ");
		leia.skip("\\R");
		String titular = leia.nextLine();
		System.out.println("Digite o tipo da conta (1 -CONTA CORRENTE 2 - CONTA POUPANÇA) ");
		int tipo = leia.nextInt();
		System.out.println("Digite o saldo da conta: ");
		float saldo = leia.nextFloat();
		
		switch(tipo) {
		
		case 1 ->{
			System.out.println("Digite o limite da conta: ");
			float limite = leia.nextFloat();
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite ));
		}
		case 2 ->{
			System.out.println("Digite o dia do aniversário da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();

			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválida!" + Cores.TEXT_RESET);
		}
	}
		
		public static void procurarContaPorNumero() {

			System.out.println("Digite o número da conta: ");
			int numero = leia.nextInt();
			leia.nextLine();

			contaController.procurarPorNumero(numero);

		}

		public static void deletarConta() {

			System.out.println("Digite o número da conta: ");
			int numero = leia.nextInt();
			leia.nextLine();

			Optional<Conta> conta = contaController.buscarNaCollection(numero);

			if (conta.isPresent()) {

				// Confirmação da exclusão

				System.out.printf("\nTem certeza que você deseja excluir a conta numero %d (S/N)?", numero);
				String confirmacao = leia.nextLine();

				if (confirmacao.equalsIgnoreCase("S"))
					contaController.deletar(numero);
				else
					System.out.println("\nOperação cancelada!");

			} else {
				System.out.printf("\nA conta número %d não foi encontrada!", numero);
			}

		}

		public static void atualizarConta() {

			System.out.println("Digite o número da conta: ");
			int numero = leia.nextInt();
			leia.nextLine();

			Optional<Conta> conta = contaController.buscarNaCollection(numero);

			if (conta.isPresent()) {

				// Obtém os dados atuais da conta
				int agencia = conta.get().getAgencia();
				String titular = conta.get().getTitular();
				int tipo = conta.get().getTipo();
				float saldo = conta.get().getSaldo();

				// Atualiza a agência ou mantém o valor atual
				System.out.printf("Agência atual: %d"
						+ "%nDigite o número da nova agência (Pressione ENTER para manter o valor atual)", agencia);
				String entrada = leia.nextLine();

				agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);

				// Atualiza o titular ou mantém o valor atual
				System.out.printf("Titular atual: %s"
						+ "%nDigite o nome do novo titular (Pressione ENTER para manter o valor atual)", titular);
				entrada = leia.nextLine();

				titular = entrada.isEmpty() ? titular : entrada;
				
				// Atualiza o saldo ou mantém o valor atual
				System.out.printf("Saldo atual: %.2f"
						+ "%nDigite o novo saldo (Pressione ENTER para manter o valor atual)", saldo);
				entrada = leia.nextLine();

				saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",","."));
				
				switch(tipo) {
					case 1 ->{
						ContaCorrente contaCorrente = (ContaCorrente) conta.get();
						float limite = contaCorrente.getLimite();
						
						// Atualiza o limite ou mantém o valor atual
						System.out.printf("Limite atual: %.2f"
								+ "%nDigite o novo limite (Pressione ENTER para manter o valor atual)", limite);
						entrada = leia.nextLine();
		
						limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada.replace(",","."));
						
						contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						
					}
					case 2 -> {
						ContaPoupanca contaPoupanca = (ContaPoupanca) conta.get();
						int aniversario = contaPoupanca.getAniversario();
						
						// Atualiza o aniversario ou mantém o valor atual
						System.out.printf("Dia do aniversário atual: %d"
								+ "%nDigite o novo dia do aniversário da conta "
								+ "(Pressione ENTER para manter o valor atual)", aniversario);
						entrada = leia.nextLine();
		
						aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
						
						contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> System.out.println(Cores.TEXT_RED + "Tipo da conta é inválido!" + Cores.TEXT_RESET);
				}

			} else {
				System.out.printf("\nA conta número %d não foi encontrada!", numero);
			}
			
			
			
			
			
		
	}
		
		public static void sacar() {
			
			System.out.println("digite o numero da conta: ");
			int numero = leia.nextInt();
			
			System.out.println("digite o valor do saque: ");
			float valor = leia.nextFloat();
			
			contaController.sacar(numero, valor);
			
		}
		
		public static void depositar() {
			
			System.out.println("digite o numero da conta: ");
			int numero = leia.nextInt();
			
			System.out.println("digite o valor do deposito: ");
			float valor = leia.nextFloat();
			
			contaController.depositar(numero, valor);
			
		}
		
		public static void transferir() {
			
			System.out.println("digite o numero da conta de origem: ");
			int numeroOrigem = leia.nextInt();
			System.out.println("digite o numero da conta de destino: ");
			int numeroDestino = leia.nextInt();
			
			System.out.printf("digite o valor do transferencia: ");
			float valor = leia.nextFloat();	
			
			contaController.transferir(numeroOrigem, numeroDestino, valor);
		}
		
		public static void listarPorTitular() {
			
			System.out.println("Digite o nome do titular da conta: ");
			
			//leia.skip("\\R");
			String titular = leia.nextLine();
			
			contaController.listarPorTitular(titular);
					
		}
		
		
}
