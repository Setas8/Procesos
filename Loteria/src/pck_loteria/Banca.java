package pck_loteria;


public class Banca {

	private int saldo;

	public Banca(int saldo) {
	
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	//Métodos movimientos synchronized
	public synchronized void movimientoSaldo(int cantidad) {
		this.saldo += cantidad;
	}
	
}
