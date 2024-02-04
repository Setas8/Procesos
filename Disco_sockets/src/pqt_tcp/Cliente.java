package pqt_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {

		final String HOST = "127.0.0.1"; // A quién me voy a conectar

		final int PUERTO = 6001; // Puerto del servidor

	

		DataInputStream in = null;
		DataOutputStream out = null;

		try {
			Socket sc = new Socket(HOST, PUERTO);

			in  = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());

			out.writeUTF("Hola desde el cliente");
			
			String mensaje = in.readUTF();
			
			System.out.println(mensaje);
						
			sc.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
