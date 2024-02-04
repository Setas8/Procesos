package pck_juegoNumUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientUDP {

	public static void main(String[] args) {

		Scanner tcd = new Scanner(System.in);

		DatagramSocket socketUDP = null;

		final int PUERTO_SERVIDOR = 5001;
		byte[] bufferEnvio = new byte[256];
		byte[] bufferRecibo = new byte[256];

		InetAddress direccionServidor = null;

		int numero = 0;
		int intentos = 0;
		boolean correcto = false;

		try {
			direccionServidor = InetAddress.getByName("localhost");
			// direccion = InetAddress.getLocalHost();

			socketUDP = new DatagramSocket();

			while (!correcto) {
				intentos++;
				/// Falta comprobar si introducen un entero
				System.out.println("Introduce un número del 1 al 100:");
				numero = tcd.nextInt();	
				String mensaje = String.valueOf(numero);
				bufferEnvio = mensaje.getBytes();

				DatagramPacket pregunta = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccionServidor, PUERTO_SERVIDOR);

				System.out.println("Envío el datagrama");
				socketUDP.send(pregunta);

				
				DatagramPacket peticion = new DatagramPacket(bufferRecibo, bufferRecibo.length);

				socketUDP.receive(peticion);
				System.out.println("Recibo la información");
				mensaje = new String(peticion.getData(), 0, peticion.getLength());
				int codigo = Integer.parseInt(mensaje);

				if (codigo == 0) {
					System.out.println("Correcto!!!\nAcertaste en " + intentos + " intentos");
					correcto = true;
				} else if (codigo == 1) {
					System.out.println("El número es mayor");
				} else if (codigo == -1) {
					System.out.println("El número es menor");
				}
			} // Fin while

			socketUDP.close();
			tcd.close();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
