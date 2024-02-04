package pqt_datos;

public class Cuenta {
	
	private int saldo = 0;
	
	public Cuenta(int c){
		this.saldo = saldo;	
	}
	
	
	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public synchronized void ingresar(int cantidad) {
		saldo += cantidad;
	}
	public synchronized void retirar(int cantidad) {
		saldo -= cantidad;
	}
	public synchronized void movimiento(int cantidad) {
		saldo += cantidad;
	}
	public int valor() {
		return saldo;
	}
}
