package pqt_util;

import java.util.Scanner;

import pqt_hilos.HiloInterrup;

public class mainPararHilos {

	public static void main(String[] args) {
		
		Scanner tcd = new Scanner(System.in);
		
		int respuesta;
		int respuestaCorrecta = 1985;
		boolean correcto = false;
		HiloInterrup h = new HiloInterrup();
				
		System.out.println("¿En qué año ganó la vuelta ciclista Pedro Delgado?");
		
		h.start();
				
		while (!correcto) {
			
			respuesta = tcd.nextInt();tcd.nextLine();
			if (respuesta == respuestaCorrecta) {
				h.interrupt();
				System.out.println("Has acertado");			
				correcto = true;				
			}
			else {
				System.out.println("¿En qué año ganó la vuelta ciclista Pedro Delgado?");	
			}							
		}					
		System.out.println("Fin del programa");			
	}
}
