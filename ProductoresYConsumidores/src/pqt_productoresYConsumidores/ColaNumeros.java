package pqt_productoresYConsumidores;

public class ColaNumeros {

	private int[] cola;
	private int posicionArray;
	private boolean colaVacia;
	private boolean colaLlena;

	public ColaNumeros(int tamanio) {

		cola = new int[tamanio];
		posicionArray = 0;
		colaVacia = true;
		colaLlena = false;
	}

	public synchronized void producir(int num) {

		while (colaLlena) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Al principio posicionArray vale 0
		cola[posicionArray] = num;
		posicionArray++;

		// Si llega al final del tamaño del array es que cola está llena
		if (posicionArray == cola.length) {
			colaLlena = true;
			System.out.println("------COLA LLENA-----");
		}
		colaVacia = false;

		// Se notifica a TODOS los hilos que NO pueden producir
		notifyAll();
	}

	public synchronized int consumir() {

		while (colaVacia) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		posicionArray--;

		// Si posición llega a 0, implica que cola está vacía
		if (posicionArray == 0) {
			colaVacia = true;
			System.out.println("------COLA VACÍA-----");
		}
		colaLlena = false;

		// Se notifica a TODOS los hilos que NO pueden consumir
		notifyAll();

		return cola[posicionArray];
	}
}