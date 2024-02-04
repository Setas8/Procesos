package pck_create_way2_ImplementsRunnable;

public class Main {

	public static void main(String[] args) {

		CustomRunnable ejecutable = new CustomRunnable();
		
		Thread hilo = new Thread(ejecutable);
		
		hilo.start();
		
		System.out.println("My name is " + Thread.currentThread().getName()
				+ " , state " + Thread.currentThread().getState());

	}

}
