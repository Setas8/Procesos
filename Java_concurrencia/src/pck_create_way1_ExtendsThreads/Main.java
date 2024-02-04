package pck_create_way1_ExtendsThreads;

public class Main {

	public static void main(String[] args) {


		CustomThread hilo1 = new CustomThread();
		
		hilo1.start();
		
		CustomThread hilo2 = new CustomThread();
		
		hilo2.start();
		
		
		
		System.out.println("My name is " + Thread.currentThread().getName()
				+ " , state " + Thread.currentThread().getState());

	}

}
