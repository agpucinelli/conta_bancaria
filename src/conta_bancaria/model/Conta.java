package conta_bancaria.model;

public class Conta {
	
	/* Atributos da classe */
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	
	/*METODO CONTRUTOR - GERAR INSTANCIAS(OBJETOS) DA CLASSE */
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getAgencia() {
		return agencia;
	}


	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	//metodos auxiliares//
	
	public boolean sacar(float valor) {
			
			if (this.saldo < valor)
				return false;
			
			this.saldo -= valor;
			return true;
		}
	
	public void depositar(float valor) {
		this.saldo += valor;
	}
	
	public void visualizar() {
		
		String tipo = "";
		
		switch(this.tipo) {
			case 1:
				tipo = "Conta Corrente";
			break;
			case 2: 
				tipo = "Conta Poupança";
			break;
		}
	
	
		System.out.println("*********************************************");
		System.out.println("             DADOS DA CONTA                   ");
		System.out.println("*********************************************");
		System.out.printf("Numero da conta: %d%n", this.numero);
		System.out.printf("Numero da agencia: %d%n", this.agencia);
		System.out.printf("Tipo da conta: %d%n", this.tipo);
		System.out.printf("Nome do Titular: %s%n", this.titular);
		System.out.printf("Saldo da conta R$: %.2f%n", this.saldo);
		
		
		
		
	}
	
	
}
