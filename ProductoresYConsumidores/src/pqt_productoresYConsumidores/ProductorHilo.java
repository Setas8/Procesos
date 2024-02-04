package pqt_productoresYConsumidores;

public class ProductorHilo extends Thread {

	private int nombreHilo;
	private int num; //número a colocar en la cola
	private ColaNumeros colaNum;

	public ProductorHilo(int num, ColaNumeros cN) {
		nombreHilo = num;
		colaNum = cN;
	}
	
	public void run() {

		while (true) {

			try {
				int num = (int) (Math.random() * 10) + 1;
				colaNum.producir(num);
				System.out.println("Hilo " + nombreHilo + " ->> Producido el número " + num);
				
				// Duermo el hilo para ver mejor los resultados
				sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // While
	}
}