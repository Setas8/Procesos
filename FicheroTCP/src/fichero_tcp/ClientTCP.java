package fichero_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {

	public static void main(String[] args) {
		Scanner tcd = new Scanner(System.in);

		final String HOST = "localhost";
		final int PUERTO_SERVIDOR = 5001;

		DataInputStream in;
		DataOutputStream out;

		System.out.println("Dime nombre de archivo solicitado: ");
		String nombreArchivo = tcd.nextLine().trim() + ".txt";

		try {
			Socket sc = new Socket(HOST, PUERTO_SERVIDOR);

			in = new DataInputStream(sc.getInputStream()); //Recibir mensajes del servidor
			out = new DataOutputStream(sc.getOutputStream()); //Mandar mensajes al servidor

			out.writeUTF(nombreArchivo);

			String mensaje = in.readUTF();
			System.out.println(mensaje);

			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}