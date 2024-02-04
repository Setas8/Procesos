package fichero_tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
	
	public static void main(String[] args) {
		
		ServerSocket servidor = null;
		Socket sc = null; // Cliente

		final int PUERTO = 5001;

		DataInputStream in;
		DataOutputStream out;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor conectado...");

			sc = servidor.accept(); // Se queda a la espera

			System.out.println("Cliente conectado");

			in = new DataInputStream(sc.getInputStream()); // Recibir mensajes del cliente
			out = new DataOutputStream(sc.getOutputStream()); // Mandar mensajes al cliente

			String mensaje = in.readUTF();

			System.out.println("Archivo solicitado: " + mensaje);

			String archivo = leerArchivo(mensaje);

			out.writeUTF(archivo);

			sc.close();// Cliente desconectado
			System.out.println("Cliente desconectado");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String leerArchivo(String nombreArchivo) {

		String cadena = "";
		try {
			File fichero = new File(nombreArchivo);
			if (fichero.exists()) {

				FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);

				String datos;

				while ((datos = br.readLine()) != null) {
					cadena += datos;
				}

				br.close();
				fr.close();

			} else {
				cadena = "El archivo no existe";
			}
			return cadena;
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al leer el archivo";
		}
	}
}
