package conta.model;

import conta.util.Cores;

public class ContaCorrente extends Conta {
	
	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println(Cores.ANSI_RED_BACKGROUND +                           "                             ");
			System.out.println(Cores.ANSI_RESET_BACKGROUND + Cores.TEXT_WHITE_BOLD + "     SALDO INSUFICIENTE!     ");
			System.out.println(Cores.ANSI_RED_BACKGROUND +                           "                             ");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;		
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println(Cores.TEXT_GREEN_BOLD + "Limite de crédito: " + Cores.TEXT_WHITE_BOLD_BRIGHT + this.limite);
	}
	
	
	
}
