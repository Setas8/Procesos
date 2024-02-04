package pck_pause;

public class Main {

	public static void main(String[] args) {
		
		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Iteracion " + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}								
			}						
		});
		hilo.start();
	}

}
