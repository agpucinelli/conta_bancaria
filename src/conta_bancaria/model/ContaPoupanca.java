package conta_bancaria.model;

public class ContaPoupanca extends Conta {
	
	
	String date;
	float saldoP;
	float rendimento;
	
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, String date, float saldoP, float rendimento) {
		super(numero, agencia, tipo, titular, saldo);
		// TODO Auto-generated constructor stub
		
		this.date = date;
		this.saldoP = saldoP;		
		this.rendimento = rendimento;
		
	}

	public float getRendimento() {
		return rendimento;
	}

	public void setRendimento(float rendimento) {
		this.rendimento = rendimento;
	}

	public float getSaldoP() {
		return saldoP;
	}

	public void setSaldoP(float saldoP) {
		this.saldoP = saldoP;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public boolean sacar(float valor) {
		
		if ((this.getSaldoP()) < valor)
			return false;
		
		this.setSaldoP(this.getSaldoP() - valor);
		return true;
	}

	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("Saldo da Poupança: R$ %.2f%n", this.saldoP);
		System.out.printf("Rendimento: %.2f%% ao mês %n", this.rendimento );
		System.out.printf("Data da conta: %s%n", this.date );
		
	};
	

}
