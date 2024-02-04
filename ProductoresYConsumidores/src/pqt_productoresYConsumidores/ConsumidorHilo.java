package pqt_productoresYConsumidores;

public class ConsumidorHilo extends Thread {

	private int nombreHilo;
	private ColaNumeros colaNum;

	public ConsumidorHilo(int num, ColaNumeros cN) {
		nombreHilo = num;
		colaNum = cN;
	}

	public void run() {
		
		while (true) {
			try {
				
				int num = colaNum.consumir();
				System.out.println("Hilo " + nombreHilo +" ->> Consumido el número: " + num);
				
				// Duermo el hilo para ver mejor los resultados
				sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//While
	}
}