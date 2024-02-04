package pqt_hilos;

import pqt_datos.Cuenta;
import pqt_datos.Ruleta;

public class HiloLanzador extends Thread {

	private Ruleta bola;
	private Cuenta banca;
	private HiloJugadorClasico[] hjC;
	private HiloJugadorParImpar[] hjPI;
	private HiloJugadorMartingala[] hjM;

	public HiloLanzador(Ruleta bola, Cuenta banca, HiloJugadorClasico[] hjC) {
		this.bola = bola;
		this.banca = banca;
		this.hjC = hjC;
	}
	public HiloLanzador(Ruleta bola, Cuenta banca, HiloJugadorParImpar[] hjPI) {
		this.bola = bola;
		this.banca = banca;
		this.hjPI = hjPI;
	}
	public HiloLanzador(Ruleta bola, Cuenta banca, HiloJugadorMartingala[] hjM) {
		this.bola = bola;
		this.banca = banca;
		this.hjM = hjM;
	}
	public HiloLanzador(Ruleta bola, Cuenta banca, HiloJugadorClasico[] hjC, HiloJugadorParImpar[] hjPI, HiloJugadorMartingala[] hjM) {
		this.bola = bola;
		this.banca = banca;
		this.hjC = hjC;
		this.hjPI = hjPI;
		this.hjM = hjM;
	}

	@Override
	public void run() {

		boolean continuar = true;

		while (continuar) {
			try {
				sleep(1000); // 3000 según el enunciado
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (bola) {
				bola.lanzar();
				System.out.println("Ha salido el número : " + bola.getNumero());
				bola.notifyAll();
			}
			// Lanza bolas mientras que el casino no esté arruinado
			if (banca.getSaldo() == 0) {
				continuar = false;		
			}

			// Lanza bolas mientras que todos los jugadores tengan para apostar
			if ((hjC[0].getSaldoJugador() == 0)  &&
				(hjC[1].getSaldoJugador() == 0)  &&
				(hjC[2].getSaldoJugador() == 0)  &&
				(hjC[3].getSaldoJugador() == 0)  &&
				(hjPI[0].getSaldoJugador() == 0) &&
				(hjPI[1].getSaldoJugador() == 0) &&
				(hjPI[2].getSaldoJugador() == 0) &&
				(hjPI[3].getSaldoJugador() == 0) &&
				(hjM[0].getSaldoJugador() == 0)  &&
				(hjM[1].getSaldoJugador() == 0)  &&
				(hjM[2].getSaldoJugador() == 0)  &&
				(hjM[3].getSaldoJugador() == 0)) {
				continuar = false;			
			}		
		}
	}
}