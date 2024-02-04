package pck_wait;

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
				
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("My name is " + Thread.currentThread().getName()
				+ " , state " + Thread.currentThread().getState());
	}

}
