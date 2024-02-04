package pqt_util;

import pqt_datos.Cuenta;
import pqt_hilos.*;


public class MainSimulacionBancaria {

	public static void main(String[] args) {
		
		Cuenta c = new Cuenta(100);
		
		//HilosIngreso[] arrayIngresos = new HilosIngreso[120];
		//HilosRetirada[] arrayRetirada = new HilosRetirada[120];
		HiloMovimiento[] arrayMovimientos = new HiloMovimiento[240];
		
		for (int i = 0; i < arrayMovimientos.length; i++) {
			
			if (i < 40 ) {
				arrayMovimientos[i] = new HiloMovimiento("Hilo " + (i+1), c, 100);				
			}
			if ((i >= 40) && (i < 60)) {
				arrayMovimientos[i] = new HiloMovimiento("Hilo " + (i+1), c, 50); 
			}
			if ((i >= 60) && (i < 120)) {
				arrayMovimientos[i] = new HiloMovimiento("Hilo " + (i+1), c, 20); 
			}
			if ((i >= 120) && (i < 160)) {
				arrayMovimientos[i] = new HiloMovimiento("Hilo " + (i+1), c, -100); 
			}
			if ((i >= 160) && (i < 180)) {
				arrayMovimientos[i] = new HiloMovimiento("Hilo " + (i+1), c, -50); 
			}
			if (i >= 180) {
				arrayMovimientos[i] = new HiloMovimiento("Hilo " + (i+1), c, -20); 
			}					
			
			arrayMovimientos[i].start();
			
		}
		System.out.println("Saldo " + c.valor());
		
		
		for (int i = 0; i < arrayMovimientos.length; i++) {
			try {
				arrayMovimientos[i].join();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}			
		}
		System.out.println("Saldo " + c.valor());
	}

}
