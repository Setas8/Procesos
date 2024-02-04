package serverUDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {

	public static void main(String[] args) {
		
		int puerto=6001;
		DatagramSocket servidor=null;
		try {
			servidor=new DatagramSocket(puerto);
			System.out.println("Iniciado el servidor");
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
		while (true) {
			byte[] buffer = new byte[256];

			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
			try {
				servidor.receive(peticion);
				System.out.println("Recibo la información del cliente");
				String archivo = new String(peticion.getData()).trim();
				System.out.println("Archivo solicitado: " + archivo);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			HiloServerUDP manejador=new HiloServerUDP(peticion, servidor);
			manejador.start();
			
		}
		
		
		
	}

}
