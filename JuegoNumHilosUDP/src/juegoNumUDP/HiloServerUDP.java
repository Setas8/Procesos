package juegoNumUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HiloServerUDP extends Thread {

	private DatagramPacket solicitud;
	private DatagramPacket respuesta;
	private DatagramSocket socketUDP;
	private byte[] buffer = new byte[256];
	private int numOculto;

	public HiloServerUDP(DatagramPacket solicitud, DatagramSocket socketUDP, int numOculto) {
		this.solicitud = solicitud;
		this.socketUDP = socketUDP;
		this.numOculto = numOculto;
	}

	@Override
	public void run() {

		boolean continuar = true;		
		int codigo;
		String mensaje = "";

		// Averiguar qué cliente es
		int puertoCliente = this.solicitud.getPort();
		InetAddress direccionCliente = solicitud.getAddress();

		while(continuar) {
			
			// Leer número
			String numero = new String(solicitud.getData());
			int num = Integer.parseInt(numero.trim());

			System.out.println("numero Oculto: " + this.numOculto);
			System.out.println("numero Cliente: " + num);
			if (num == this.numOculto) {
				continuar = false;
				codigo = 0;
			} else if (num < this.numOculto)
				codigo = 1;
			else
				codigo = -1;
			mensaje = String.valueOf(codigo);
			System.out.println(mensaje);
			
	
			buffer = mensaje.getBytes();
			respuesta = new DatagramPacket(buffer, buffer.length, direccionCliente, puertoCliente);
			try {
				socketUDP.send(respuesta);
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Envío la información del cliente");
			
		}
		
		

	}
}
