package pqt_productoresYConsumidores;

public class Principal {

	public static void main(String[] args) {

		final int TAMANIO_COLA = 10;

		ColaNumeros cN = new ColaNumeros(TAMANIO_COLA);
		//Versión 1
		//1 productor 1 consumidor------------------------------------------------------
//		ProductorHilo p = new ProductorHilo(1, cN);
//		ConsumidorHilo c = new ConsumidorHilo(2, cN);
//				
//		p.start();
//		c.start();
		//--------------------------------------------------------------------------------
		
		//Versión 2
		//n productores n consumidores------------------------------------------------------
		
		int numProductores  = 1;
		int numConsumidores = 2;
		
		//Crear array de Hilos productores
		ProductorHilo[]  hilosProductores  = new ProductorHilo[numProductores];		
		for (int i = 0; i < hilosProductores.length; i++) {
			hilosProductores[i] = new ProductorHilo((i+1), cN);
		}
		
		//Crear array de Hilos consumidores
		ConsumidorHilo[] hilosConsumidores = new ConsumidorHilo[numConsumidores];
		for (int i = 0; i < hilosConsumidores.length; i++) {
			hilosConsumidores[i] = new ConsumidorHilo((i+1),cN);
		}
		
		for (int i = 0; i < hilosProductores.length; i++) {
			hilosProductores[i].start();
		}
		
		for (int i = 0; i < hilosConsumidores.length; i++) {
			hilosConsumidores[i].start();
		}							
		//--------------------------------------------------------------------------------		
	}
}