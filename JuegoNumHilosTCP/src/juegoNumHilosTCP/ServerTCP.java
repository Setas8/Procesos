package juegoNumHilosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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

			while (true) {
				sc = servidor.accept();

				HiloServer hilo = new HiloServer(sc);
				hilo.start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
