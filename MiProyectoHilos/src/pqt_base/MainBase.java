package pqt_base;

public class MainBase {

	public static void main(String[] args) {
		
		/*
		 Crea una clase llamada HiloNumerosLetras que implemente runnable y
		  tenga de atributo un numero llamado tipo.
		  
		  Si el tipo es 1, mostrará los números del 1 al 30;
		  
		  Si el tipo es 2, mostrará las letras de la 'a' a la 'z'
		 */
		
		HiloNumerosLetras h1 = new HiloNumerosLetras(1);
		Thread t1 = new Thread(h1);
		
		HiloNumerosLetras h2 = new HiloNumerosLetras(2);
		Thread t2 = new Thread(h2);
		
		t1.start();
		t2.start();
	}

}
