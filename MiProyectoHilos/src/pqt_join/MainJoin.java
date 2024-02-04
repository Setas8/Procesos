package pqt_join;

public class MainJoin {

	public static void main(String[] args) {
		/*
		 * Crea una clase llamada Contador que contenga un atributo que sea un contador,
		 * otro que sea el nombre del hilo y otro que sea el límite del contador.
		 * 
		 * Crea varios contadores y ejecútalos.
		 */

		ContadorHilo cH1 = new ContadorHilo("Contador 1", 40);
		ContadorHilo cH2 = new ContadorHilo("Contador 2", 50);
		ContadorHilo cH3 = new ContadorHilo("Contador 3", 20);
		ContadorHilo cH4 = new ContadorHilo("Contador 4", 70);

		Thread t1 = new Thread(cH1);
		Thread t2 = new Thread(cH2);
		Thread t3 = new Thread(cH3);
		Thread t4 = new Thread(cH4);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		// Join se esperan a que acaben. Hasta que no acabe el hilo, el hilo principal
		// no sigue
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Fin del programa");
	}

}
