package pqt_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {

		DatagramSocket socketUDP = null;

		final int PUERTO_SERVIDOR = 5001;
		byte[] buffer = new byte[1024];

		InetAddress direccionServidor = null;

		try {
			direccionServidor = InetAddress.getByName("localhost");
			// direccion = InetAddress.getLocalHost();

			socketUDP = new DatagramSocket();

			String mensaje = "Hola desde el cliente";
			buffer = mensaje.getBytes();

			DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

			System.out.println("Envío el datagrama");
			socketUDP.send(pregunta);

			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

			socketUDP.receive(peticion);
			System.out.println("Recibo la información");
			mensaje = new String(peticion.getData());
			System.out.println(mensaje);

			socketUDP.close();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
