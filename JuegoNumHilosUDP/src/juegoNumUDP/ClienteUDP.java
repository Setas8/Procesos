package juegoNumUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteUDP {

	static Scanner tcd = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		
		DatagramSocket socketUDP = null;
		DatagramPacket solicitud;
		DatagramPacket respuesta;

		final int PUERTO_SERVER = 5001;
		byte[] buffer = new byte[256];

		InetAddress direccionServer = null;

		try {
			direccionServer = InetAddress.getByName("localhost");

			

			boolean continuar = true;
			int numCliente;
			String mensaje = "";
			int codigo;
			while (continuar) {
				socketUDP = new DatagramSocket();
				//Pido el número
				//do {
					System.out.println("Introduce número del 1 al 100:");
					numCliente = tcd.nextInt();tcd.nextLine();
				//} while(esNumero(numCliente));
				
				//genero la solicitud y la envío
				mensaje = String.valueOf(numCliente);				
				buffer = mensaje.getBytes();
				solicitud = new DatagramPacket(buffer,buffer.length,direccionServer, PUERTO_SERVER);
				System.out.println("Envío num");
				socketUDP.send(solicitud);
				
				//Recibo respuesta
				respuesta = new DatagramPacket(buffer, buffer.length);				
				socketUDP.receive(respuesta);
				
				mensaje = new String(respuesta.getData());
				System.out.println("Mensaje codigo: " + mensaje);
				codigo = Integer.parseInt(mensaje);
									
				System.out.println("Codigo: " + codigo);
				if (codigo == 1) 
					System.out.println("El número es mayor");			
				else if (codigo == -1) 
					System.out.println("El número es menor");			
				else {
					System.out.println("¡¡¡ACERTASTE!!!");
					continuar = false;
				}
					
				
			}//fin del while
			socketUDP.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private static boolean esNumero(int num) {
		boolean ok = false;
		if (tcd.hasNextInt())
			ok = true;
		System.out.println(ok);
		
		return ok;
		
	}

}
