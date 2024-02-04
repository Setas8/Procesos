package pqt_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		ServerSocket servidor = null;
		Socket sc = null; //Cliente

		final int PUERTO = 6001;

		DataInputStream in;
		DataOutputStream out;
		
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor conectado...");

			while(true) {
				
				sc = servidor.accept(); //Se queda a la espera
				
				System.out.println("Cliente conectado");
				
				in  = new DataInputStream(sc.getInputStream()); //Recibir los mensajes del cliente
				out = new DataOutputStream(sc.getOutputStream()); //Mandar mensajes al cliente
				
				String mensaje = in.readUTF();
				
				System.out.println(mensaje);
				
				out.writeUTF("Hola desde el servidor");
				
							

				sc.close();	//Se cierra el cliente
				System.out.println("Cliente desconectado");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
