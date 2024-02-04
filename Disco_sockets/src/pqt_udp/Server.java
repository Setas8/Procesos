package pqt_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {

		final int PUERTO = 5001;

		byte[] buffer = new byte[1024];

		DatagramSocket socketUDP = null;

		try {
			socketUDP = new DatagramSocket(PUERTO);

			System.out.println("Iniciado el servidor UDP");

			while (true) {
				
				DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

				socketUDP.receive(peticion); // recibo el paquete(datagrama)
				System.out.println("Recibo la información del cliente");

				String mensaje = new String(peticion.getData());

				System.out.println(mensaje);

				int puertoCliente = peticion.getPort();
				InetAddress direccion = peticion.getAddress();

				mensaje = "Hola desde el servidor";
				buffer = mensaje.getBytes();

				DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

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
