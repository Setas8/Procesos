package pck_stop;

public class Main {

	public static void main(String[] args) {
		
		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Iteracion " + i);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("Hilo interrumpido");
						return;
					}
				}								
			}						
		});
		
		hilo.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {	
			e.printStackTrace();
		}
//		if (hilo.isAlive()) 
			hilo.interrupt();
		
		
		

	}

}
