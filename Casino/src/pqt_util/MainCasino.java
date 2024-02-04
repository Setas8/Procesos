package pqt_util;

import pqt_datos.Cuenta;
import pqt_datos.Ruleta;
import pqt_hilos.HiloJugadorClasico;
import pqt_hilos.HiloJugadorMartingala;
import pqt_hilos.HiloJugadorParImpar;
import pqt_hilos.HiloLanzador;

public class MainCasino {
		
	/*
	 * ¡¡¡¡¡ -> Jugador gana la apuesta
	 * !!!!! -> Jugador pierde la apuesta
	 * 
	 * Versión Main1:
	 *    	tipo de jugador 1-> Apuesta a diferentes números cada vez, 10€ cada vez
	 *   	Banca tiene 50000€
	 *   	Jugador tiene 1000€ 	  	  	
	 * Versión Main2:   	
	 *      tipo de jugador 2-> Apuesta a par/impar números cada vez, 10€ cada vez
	 *   	Banca tiene 50000€
	 * 	  	Jugador tiene 1000€
	 * Versión Main3:
	 *    	tipo de jugador 3-> Apuesta a diferentes números cada vez, si pierde dobla apuesta
	 *   	Banca tiene 50000€
	 * 	  	Jugador tiene 1000€
	 * Versión Main4:	
	 *    	tipo de jugador 1-> Apuesta a diferentes números cada vez, 10€ cada vez
	 *      tipo de jugador 2-> Apuesta a par/impar números cada vez, 10€ cada vez
	 *      tipo de jugador 3-> Apuesta a diferentes números cada vez, si pierde dobla apuesta
	 *   	Banca tiene 50000€€
	 * 	  	Jugador tiene 1000€	  	  	
	 */
	
	public static void main(String[] args) {
		
		int numHilos = 4;
		
		HiloJugadorClasico[] jugadoresClasicos = new HiloJugadorClasico[numHilos];
		HiloJugadorParImpar[] jugadoresParImpar = new HiloJugadorParImpar[numHilos];
		HiloJugadorMartingala[] jugadoresMartingala = new HiloJugadorMartingala[numHilos];
		
		Cuenta bancaCasino = new Cuenta(10000); //50.000€ según enunciado
		Ruleta ruleta  = new Ruleta();
		//Versión 1
		HiloLanzador lV1 = new HiloLanzador(ruleta, bancaCasino, jugadoresClasicos); 
		//Versión 2
		HiloLanzador lV2 = new HiloLanzador(ruleta, bancaCasino, jugadoresParImpar); 
		//Versión 3
		HiloLanzador lV3 = new HiloLanzador(ruleta, bancaCasino, jugadoresMartingala); 
		//Versión 4
		HiloLanzador lV4 = new HiloLanzador(ruleta, bancaCasino, jugadoresClasicos, jugadoresParImpar, jugadoresMartingala); 
		
		
		for (int i = 0; i < jugadoresClasicos.length; i++) {
			jugadoresClasicos[i] = new HiloJugadorClasico((i+1), 100, ruleta, bancaCasino); //1000€ según enunciado
		}
		for (int i = 0; i < jugadoresParImpar.length; i++) {
			jugadoresParImpar[i] = new HiloJugadorParImpar((i+1), 100, ruleta, bancaCasino); //1000€ según enunciado
		}
		for (int i = 0; i < jugadoresMartingala.length; i++) {
			jugadoresMartingala[i] = new HiloJugadorMartingala((i+1), 100, ruleta, bancaCasino); //1000€ según enunciado
		}
			

		//-----------------------------------------------VERSIÓN 1----------------------------------------
//		for (int i = 0; i < jugadoresClasicos.length; i++) {
//			jugadoresClasicos[i].start();
//		}
//		lV1.start();
//		
//				
//		////jugadores esperan se esperan y el lanzador también espera a todos
//		for (int i = 0; i < jugadoresClasicos.length; i++) {
//			try {
//				jugadoresClasicos[i].join();
//				lV1.join();			
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		//-----------------------------------------------VERSIÓN 2----------------------------------------
//		for (int i = 0; i < jugadoresParImpar.length; i++) {
//			jugadoresParImpar[i].start();
//		}
//		lV2.start();
//		
//				
//		////jugadores esperan se esperan y el lanzador también espera a todos
//		for (int i = 0; i < jugadoresParImpar.length; i++) {
//			try {
//				jugadoresParImpar[i].join();
//				lV2.join();			
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		//-----------------------------------------------VERSIÓN 3----------------------------------------
//		for (int i = 0; i < jugadoresMartingala.length; i++) {
//			jugadoresMartingala[i].start();
//		}
//		lV3.start();
//		
//				
//		////jugadores esperan se esperan y el lanzador también espera a todos
//		for (int i = 0; i < jugadoresMartingala.length; i++) {
//			try {
//				jugadoresMartingala[i].join();
//				lV3.join();			
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		//-----------------------------------------------VERSIÓN 4----------------------------------------
		for (int i = 0; i < jugadoresClasicos.length; i++) {
			jugadoresClasicos[i].start();
			jugadoresParImpar[i].start();
			jugadoresMartingala[i].start();
		}
		lV4.start();
						
		////jugadores esperan se esperan y el lanzador también espera a todos
		for (int i = 0; i < jugadoresClasicos.length; i++) {
			try {
				jugadoresClasicos[i].join();
				jugadoresParImpar[i].join();
				jugadoresMartingala[i].join();
				lV4.join();			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
		System.out.println("La banca tiene un saldo de:  " + bancaCasino.getSaldo());
		System.out.println("Fin del casino");
	}
}
