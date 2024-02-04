package pck_loteria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner tcd = new Scanner(System.in);

		System.out.println("Cantidad de sorteos: ");
		int numSorteos = tcd.nextInt();
		tcd.nextLine();

		System.out.println("Cantidad de apostantes: ");
		int numApostantes = tcd.nextInt();
		tcd.nextLine();

		// Se crea instancia de Banca
		Banca banca = new Banca(1000 + (10 * numApostantes));
		
		//Se crea instancia de sorteo
		Sorteo sorteo = new Sorteo();

		// Se crean los hilos
		Jugador[] hilos = new Jugador[numApostantes];

		for (int i = 0; i < numApostantes; i++) {
			hilos[i] = new Jugador(100, banca, sorteo, numSorteos);
		}

		for (int i = 0; i < numApostantes; i++) {
			hilos[i].start();
		}

		for (int i = 0; i < numApostantes; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Saldo de la banca  " + banca.getSaldo());
		System.out.println("Fin del programa");
	}

}
