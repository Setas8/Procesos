package pck_server;


import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

	public static void main(String[] args) {
		
		int puerto = 6001;
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("escucho en el puerto " + puerto);
			while (true) {
				Socket cliente1 = servidor.accept();
				Thread hilo = new Thread(new ManejadorClienteTCP(cliente1));
				hilo.start();
			} // fin while
				// servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
