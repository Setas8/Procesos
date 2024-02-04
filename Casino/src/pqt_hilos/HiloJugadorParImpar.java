package pqt_hilos;

import pqt_datos.Cuenta;
import pqt_datos.Ruleta;

public class HiloJugadorParImpar extends Thread {

	private int nombre;
	private int saldoJugador;
	private Ruleta bola;
	private Cuenta banca;

	public HiloJugadorParImpar(int nombre, int saldoJugador, Ruleta bola, Cuenta banca) {
		
		this.nombre = nombre;
		this.saldoJugador = saldoJugador;
		this.bola = bola;
		this.banca = banca;
	}
	
	public int getSaldoJugador() {
		if (this.saldoJugador < 0) 
			this.saldoJugador = 0;
		
		return saldoJugador;
	}

	public void setSaldoJugador(int saldoJugador) {		
		this.saldoJugador = saldoJugador;
	}

	public synchronized void apostar(int cantidad) {
		saldoJugador -= cantidad;
	}
	public synchronized void ganar(int cantidad) {
		saldoJugador += cantidad;
	}

	@Override
	public void run() {

		int numApuesta = 0;
		boolean continuar = true;
		
		int cantidadApuesta = 10;
		String nomApuesta = "";
		
		while (continuar) {
										
			// Elegir número apuesta
			numApuesta = (int) (Math.random() * 36 + 1);	
			
			if (numApuesta%2 == 0) {
				
				nomApuesta = "par";
				//apuesta al par
				apostar(cantidadApuesta);
				
				// Ingresar dinero
				banca.ingresar(cantidadApuesta);
				
				// Esperar al sorteo
				synchronized (bola) { // syncronized sobre bloque con objeto
					try {
						bola.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("ParImpar " + nombre + " apuesta al " + nomApuesta + " y sale el " + bola.getNumero());
				
				///////Esperar al recuento/////////////////////
				if (bola.getNumero()%2 == 0) {   //Sale número par
					ganar(20);
					banca.retirar(20);
					System.out.println("-----------ParImpar " + nombre + " gana la apuesta con el número " + bola.getNumero());
				}			
				else {
					banca.ingresar(10);
					System.out.println("-----Casino gana al ParImpar " + nombre);
	
				}									
			}//Fin de la apuesta par			
			else {
				nomApuesta = "impar";
				//apuesta al impar
				apostar(cantidadApuesta);
				
				// Ingresar dinero
				banca.ingresar(cantidadApuesta);
				
				// Esperar al sorteo
				synchronized (bola) { // syncronized sobre bloque con objeto
					try {
						bola.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("ParImpar " + nombre + " apuesta al " + nomApuesta + " y sale el " + bola.getNumero());
				
				///////Esperar al recuento/////////////////////
				if (bola.getNumero()%2 != 0) {   //Sale número impar
					ganar(20);
					banca.retirar(20);
					System.out.println("-----------ParImpar " + nombre + " gana la apuesta con el número " + bola.getNumero());
				}			
				else {
					banca.ingresar(10);
					System.out.println("-----Casino gana al ParImpar " + nombre);
				}									
			}//Fin de la apuesta impar
			
			/////////Esperar al resumen//////////////////////////				
			if (banca.getSaldo() == 0) {
				System.out.println("------------------------------CASINO ARRUINADO--------------------------");
				continuar = false;			
			}						
			//Si un hilo se queda con menos de 10, no puede apostar más
			if (saldoJugador <= 0) {
				System.out.println("ParImpar " + nombre + " se quedó sin saldo");
				continuar = false;
			}
			System.out.println("Saldo del ParImpar " + nombre + ": " + saldoJugador);
		}//Final del while		
		System.out.println("-------------------ParImpar " + nombre + " NO PUEDE APOSTAR MÁS---------------------");
	}
}