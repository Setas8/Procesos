package serverUDP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class HiloServerUDP extends Thread {
	private DatagramPacket solicitud;
	private DatagramPacket respuesta;
	private DatagramSocket socketUDP;
	private byte[] buffer = new byte[256];

	public HiloServerUDP(DatagramPacket solicitud, DatagramSocket socketUDP) {
		this.solicitud = solicitud;
		this.socketUDP = socketUDP;
	}

	@Override
	public void run() {
		InetAddress direccionCliente = solicitud.getAddress();
		System.out.println("ip cliente:" + direccionCliente);
		int puertoCliente = solicitud.getPort();
		System.out.println("puerto cliente:" + puertoCliente);
		String nombre = new String(solicitud.getData()).trim();
		System.out.println("Archivo solicitado:" + nombre);

		// comprobar si existe
		// enviar respuesta o respuestas
		File archivo = new File(nombre);

		if (archivo.exists()) {
			try {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);

				String frase;
				while ((frase = br.readLine()) != null) {
					this.buffer = frase.getBytes();
					respuesta = new DatagramPacket(buffer, buffer.length, direccionCliente, puertoCliente);
					socketUDP.send(respuesta);
					try {
						this.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				br.close();
				fr.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} // Si existe el archivo
		else {
			this.buffer = "El archivo no existe".getBytes();
			respuesta = new DatagramPacket(buffer, buffer.length, direccionCliente, puertoCliente);
			try {
				socketUDP.send(respuesta);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
