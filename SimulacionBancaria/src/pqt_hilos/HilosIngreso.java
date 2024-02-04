package pqt_hilos;

import pqt_datos.Cuenta;

public class HilosIngreso extends Thread {

	private Cuenta cuenta;
	private int cantidad;
	
	public HilosIngreso(String n, Cuenta c, int cantidad){
		setName(n);
		this.cuenta = c;
		this.cantidad = cantidad;
	}
	@Override
	public void run() {
										
		try {
			sleep((int)(Math.random()*100)+1);
			cuenta.movimiento(cantidad);
			
		} catch (InterruptedException e) {					
			e.printStackTrace();
		}
		
		
	}
	
}



	
	
	

