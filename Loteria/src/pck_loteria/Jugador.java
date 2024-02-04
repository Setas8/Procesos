package pck_loteria;

import java.util.HashSet;
import java.util.Set;

public class Jugador extends Thread {

	private int saldo;
	private Banca banca;
	private int numSorteos;
	private Sorteo sorteo;

	// Constructor
	public Jugador(int saldo, Banca banca, Sorteo sorteo, int numSorteos) {
		this.saldo = saldo;
		this.banca = banca;
		this.numSorteos = numSorteos;
		this.sorteo = sorteo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public void run() {

		Set<Integer> apuestas = new HashSet<Integer>();

		for (int i = 0; i < this.numSorteos; i++) {
			
			//10 €por apuesta
			this.saldo -= 10;
			this.banca.movimientoSaldo(10);
			
			generarApuestas(apuestas);
			System.out.println("Apuestas hilo " + this.getName() + " " + apuestas);

			synchronized (this.sorteo) {

				System.out.println("Resultado ganador del sorteo " + (i+1) + " " + sorteo.getNumerosGanadores());

				int contador = 0;
				for (Integer s : apuestas) {
					if (sorteo.getNumerosGanadores().contains(s)) {
						contador++;
					}
				}
				
				switch (contador) {					
					case 1:
						this.saldo+=5;
						this.banca.movimientoSaldo(-5);
						break;
					case 2:
						this.saldo+=25;
						this.banca.movimientoSaldo(-25);
						break;
					case 3:
						this.saldo+=1000;
						this.banca.movimientoSaldo(-1000);
						break;

				}

			}//Syncronizado sorteo
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//For
		
	}

	private void generarApuestas(Set conj) {
		conj.clear();

		while (conj.size() < 3) {
			int num = (int) (Math.random() * 48) + 1;
			conj.add(num);
		}
	}

}
