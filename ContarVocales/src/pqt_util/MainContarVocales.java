package pqt_util;


import java.util.Scanner;
import pqt_hilos.HiloContador;

public class MainContarVocales {

	
	public static void main(String[] args) {
					
		Scanner tcd = new Scanner(System.in);
		
	    System.out.println("Introduce la frase: ");        
	    String frase = tcd.nextLine();        

	    HiloContador contadorA = new HiloContador(frase, 'a');
	    HiloContador contadorE = new HiloContador(frase, 'e');
	    HiloContador contadorI = new HiloContador(frase, 'i');
	    HiloContador contadorO = new HiloContador(frase, 'o');
	    HiloContador contadorU = new HiloContador(frase, 'u');

	    Thread[] arrayHilos = new Thread[5];
	    arrayHilos[0]= new Thread(contadorA);
	    arrayHilos[1]= new Thread(contadorE);
	    arrayHilos[2]= new Thread(contadorI);
	    arrayHilos[3]= new Thread(contadorO);
	    arrayHilos[4]= new Thread(contadorU);
	    
	    for (int i = 0; i < arrayHilos.length; i++) {
	    	arrayHilos[i].start();	    	
		}
	}
}