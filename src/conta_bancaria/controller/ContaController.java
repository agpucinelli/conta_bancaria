package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.contaRepository;


public class ContaController implements contaRepository {

	private List<Conta> listaContas = new ArrayList<Conta>();
	
	int numero = 0;
	
	
	
	
	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		// TODO Auto-generated method stub
			listaContas.add(conta);
			System.out.printf("A conta número %d foi criada com sucesso! %n", conta.getNumero());
	}

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if (conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		
		
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.printf("\nA conta número %d foi atualizada com sucesso!", conta.getNumero());
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", conta.getNumero());
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if (conta.isPresent()) {
			if (listaContas.remove(conta.get()))
				System.out.printf("\nA conta número %d foi excluída com sucesso!", numero);
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if (conta.isPresent()) {
			if (conta.get().sacar(valor))
				System.out.printf("\nO saque no valor de R$%.2f, na conta numero %d foi efetuado com sucesso!", valor,numero);
			
			else System.out.printf("\nO saque no valor de R$%.2f, na conta numero %d não foi possível devido ao saldo!", valor,numero);
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if (conta.isPresent()) {
			conta.get().depositar(valor);
				System.out.printf("\nO depósito no valor de R$%.2f, na conta numero %d foi efetuado com sucesso!", valor,numero);
			
			
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if (contaOrigem.get().sacar(valor)) {
				contaDestino.get().depositar(valor);
				System.out.printf("\nA transferencia no valor de R$%.2f, na conta numero %d "
				+ "para a conta %d foi efetuado com sucesso!"
				, valor,numeroOrigem, numeroDestino);
		}
			else System.out.printf("\nA transferencia no valor de R$%.2f"
									+ "para a conta %d não foi possível devido ao saldo!"
									, valor,numeroOrigem, numeroDestino);
			
		
		}else
			System.out.printf("\nA conta número %d  ou %d não foi encontrada!", numeroOrigem, numeroDestino);
		
	}
	
	
	@Override
	public void listarPorTitular(String titular) {
		// TODO Auto-generated method stub
		List<Conta> listaTitulares = listaContas.stream()
				.filter(conta -> conta.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		if(listaTitulares.isEmpty())
			System.out.printf("\n Nenhum titular com nome %s foi encotrando", titular);
		listaTitulares.forEach(conta -> conta.visualizar());
		
	}
		
	//METODO AUXILIAR
	
	public int gerarNumero() {
		return ++ numero;
		
	}
	
	public Optional<Conta> buscarNaCollection(int numero){
		for(var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}
		
		return Optional.empty();
	}

	

}
