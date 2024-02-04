package pqt_miProyectoHilos;

import java.util.concurrent.ThreadLocalRandom;

public class Hilo extends Thread {
	
	public void run() {
		try {
			int randomNum = ThreadLocalRandom.current().nextInt(2000, 5000 + 1);
			System.out.println("Hola, soy un hilo");		
			Thread.sleep(randomNum); //4 segundos puede dar error (try/catch)
			System.out.println("Adios, soy un hilo");			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		} 
		
	}
}
