package pqt_datos;

public class Cuenta {

	private int saldo=0;

	public Cuenta(int saldo) {
		this.saldo = saldo;
	}

	public int getSaldo() {
		if (this.saldo < 0) 
			this.saldo = 0;
		return saldo;
	}
	
	public synchronized void ingresar(int cantidad) {
		saldo += cantidad;
	}
	public synchronized void retirar(int cantidad) {
		saldo -= cantidad;
	}
}