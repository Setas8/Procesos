package pqt_hilos;

import pqt_datos.Cuenta;
import pqt_datos.Ruleta;

public class HiloJugadorMartingala extends Thread{
	
	private int nombre;
	private int saldoJugador;
	private Ruleta bola;
	private Cuenta banca;

	public HiloJugadorMartingala(int nombre, int saldoJugador, Ruleta bola, Cuenta banca) {
		
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
		while (continuar) {
			
			//Jugador apuesta
			apostar(cantidadApuesta);
			System.out.println("-----Martingala " + nombre + " apuesta " + cantidadApuesta + "€");
		
			// Ingresar dinero
			banca.ingresar(cantidadApuesta);			
			
			// Elegir número apuesta
			numApuesta = (int) (Math.random() * 36 + 1);	
			
			// Esperar al sorteo
			synchronized (bola) { // syncronized sobre bloque con objeto
				try {
					bola.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Martingala " + nombre + " apuesta al " + numApuesta + " y sale el " + bola.getNumero());						
			///////Esperar al recuento/////////////////////						
			if ((numApuesta != bola.getNumero()) || (bola.getNumero() == 0)){
				banca.ingresar(cantidadApuesta);	
				System.out.println("-----Casino gana al Martingala " + nombre);
				cantidadApuesta *= 2;
			}			
			else {
				ganar(360);
				banca.retirar(360);
				System.out.println("------------Martingala " + nombre + " gana la apuesta con el número " + bola.getNumero());					
			}								
			/////////Esperar al resumen//////////////////////////				
			if (banca.getSaldo() == 0) {
				System.out.println("------------------------------CASINO ARRUINADO--------------------------");
				continuar = false;			
			}						
			//Si un hilo se queda con menos de 10, no puede apostar más
			if (saldoJugador <= 0) {
				System.out.println("Martingala " + nombre + " se quedó sin saldo");
				continuar = false;
			}
			System.out.println("Saldo del Martingala " + nombre + ": " + saldoJugador);
		}//Final del while		
		System.out.println("-------------------Martingala " + nombre + " NO PUEDE APOSTAR MÁS---------------------");
	}
}


