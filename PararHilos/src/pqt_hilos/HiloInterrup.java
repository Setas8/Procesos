package pqt_hilos;


public class HiloInterrup extends Thread{
	
	boolean continuar = true;
	
	public void pararHilo() {		
		continuar = false;
	}

	@Override
	public void run() {
		try {
			while (continuar) {
				
				Thread.sleep(10000);//10 sg
				System.out.println("Te quedan 20 segundos");
				Thread.sleep(10000);
				System.out.println("Te quedan 10 segundos");
				Thread.sleep(10000);
				System.out.println("Tu tiempo se agotó");
				System.out.println("Fin del programa");
				System.exit(0);
			}
		}
	
		catch (InterruptedException e) {
			System.out.println("Hilo interrumpido.");
		}
		
	}
	
}