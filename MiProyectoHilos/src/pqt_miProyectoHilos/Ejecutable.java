package pqt_miProyectoHilos;

import java.util.concurrent.ThreadLocalRandom;

public class Ejecutable implements Runnable {

	@Override
	public void run() {
		
		try {
			int randomNum = ThreadLocalRandom.current().nextInt(2000, 5000 + 1);
			System.out.println("Hola, soy un ejecutable");		
			Thread.sleep(randomNum); //4 segundos puede dar error (try/catch)
			System.out.println("Adios, soy un ejecutable");			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}	
}
