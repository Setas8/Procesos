package pqt_miProyectoHilos;

public class MainHilos {

	public static void main(String[] args) {

		System.out.println("Hola, soy el hilo principal");
		
		Hilo miHilo = new Hilo();
		miHilo.start();
		
		Ejecutable miEjecutable = new Ejecutable();
		Thread t = new Thread(miEjecutable);
		t.start();
		
		System.out.println("Adios, soy el hilo principal");
	}

}
