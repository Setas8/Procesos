package pck_juegoNumUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP {

	public static void main(String[] args) {

		final int PUERTO = 5001;
		byte[] bufferRecibo = new byte[256];
		byte[] bufferEnvio = new byte[256];
		DatagramSocket socketUDP = null;

		int numGenerado = (int) (Math.random() * 100) + 1;
		int numRespuesta = 0;
		int codigo;
		boolean correcto = false;
		System.out.println(numGenerado);
		try {
			socketUDP = new DatagramSocket(PUERTO);
			System.out.println("Iniciado el servidor UDP");

			while (!correcto) {

				DatagramPacket peticion = new DatagramPacket(bufferRecibo, bufferRecibo.length);

				socketUDP.receive(peticion); // recibo el paquete(datagrama)
				System.out.println("Recibo la información del cliente");

				String mensaje = new String(peticion.getData(), 0, peticion.getLength());
				numRespuesta = Integer.parseInt(mensaje);
				System.out.println(numRespuesta);
				System.out.println(numGenerado);
				if (numRespuesta < numGenerado) 
					codigo = 1;
				else if (numRespuesta > numGenerado)
					codigo = -1;
				else {
					codigo = 0;
					correcto = true;
				}
					

				int puertoCliente = peticion.getPort();
				InetAddress direccion = peticion.getAddress();

				mensaje = String.valueOf(codigo);
				bufferEnvio = mensaje.getBytes();

				DatagramPacket respuesta = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccion, puertoCliente);

				System.out.println("Envío la información del cliente");
				socketUDP.send(respuesta);

			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
