package pqt_synchronized;

public class HiloContador extends Thread {

	private int id;
	private Contador contador;
	private int n;

	public HiloContador(int id, int n, Contador contador) {

		this.id = id;
		this.contador = contador;
		this.n = n;
	}
	public void run() {
		
		if (this.contador.isSincronizado()) 		
			this.contador.mostrarNumerosSincronizados(id, n);
		else 
			this.contador.mostrarNumerosNoSincronizados(id, n);
	}

}
