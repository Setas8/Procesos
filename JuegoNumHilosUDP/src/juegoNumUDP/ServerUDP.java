package juegoNumUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {

	public static void main(String[] args) {

		final int PUERTO = 5001;

		byte[] buffer = new byte[256];

		DatagramSocket socketUDP = null;

		try {
			socketUDP = new DatagramSocket(PUERTO);

			System.out.println("Servidor iniciado...");
			int numAleatorio = (int) (Math.random() * 100) + 1;
			System.out.println("Num secreto: " + numAleatorio);
			
//			while (true) {
				
				
				DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

				socketUDP.receive(peticion); // recibo el paquete(datagrama)
				System.out.println("Recibo la información del cliente");

				HiloServerUDP hilo = new HiloServerUDP(peticion, socketUDP, numAleatorio);

				hilo.start();

//			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
