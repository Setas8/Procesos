package pqt_synchronized;

public class MainSinchronized {

	public static void main(String[] args) {
		
		boolean sincronizado = true;
		
		Contador c = new Contador(sincronizado);
		
		HiloContador h1 = new HiloContador(1, 5, c);
		HiloContador h2 = new HiloContador(2, 10, c);
		
		h1.start();	
		h2.start();
				
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Fin del programa");
	}
	
}
