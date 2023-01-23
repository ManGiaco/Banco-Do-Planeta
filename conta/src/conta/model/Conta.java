package conta.model;

import conta.util.Cores;

public abstract class Conta {
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	
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
	
	
	
	
	public boolean sacar(float valor) { 
		if(this.getSaldo() < valor) {
			System.out.println(Cores.ANSI_RED_BACKGROUND + "                                           ");
			System.out.println(Cores.TEXT_WHITE_BOLD + "      SALDO INSUFICIENTE!                  ");
			System.out.println("                                           ");
			return false;
		}		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
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
		
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + "                       ");
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "     Dados da Conta:   ");
		System.out.println("    -----------------  ");
		System.out.println("                       ");
		System.out.println(Cores.TEXT_BLUE_BOLD + "    Numero da Conta: " + Cores.TEXT_WHITE_BOLD_BRIGHT + this.numero);
		System.out.println(Cores.TEXT_BLUE_BOLD + "    Agência: " + Cores.TEXT_WHITE_BOLD_BRIGHT + this.agencia);
		System.out.println(Cores.TEXT_BLUE_BOLD + "    Tipo da Conta: " + Cores.TEXT_WHITE_BOLD_BRIGHT + tipo);
		System.out.println(Cores.TEXT_BLUE_BOLD + "    Titular: " + Cores.TEXT_WHITE_BOLD_BRIGHT + this.titular);
		System.out.println(Cores.TEXT_BLUE_BOLD + "    Saldo: " + Cores.TEXT_WHITE_BOLD_BRIGHT + this.saldo);

	}
	
	
	
	
	
	
	
}
