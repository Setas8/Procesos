package pck_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket sCliente = new Socket("127.0.0.1", 6001);
			System.out.println("conectado");
			OutputStream outaux = sCliente.getOutputStream();
			DataOutputStream flujo_salida = new DataOutputStream(outaux);
			flujo_salida = new DataOutputStream(outaux);
			String nombre = "prueba.txt";
			// leer nombre del fichero por pantalla

			System.out.println("mando nombre archivo");
			flujo_salida.writeUTF(nombre);
			InputStream inaux = sCliente.getInputStream();
			DataInputStream flujo_entrada = new DataInputStream(inaux);
			int codigo = flujo_entrada.readInt();
			if (codigo == 200) {
				String linea;
				while ((linea = flujo_entrada.readUTF()) != null)
					System.out.println(linea);
			} else
				System.out.println("fichero no existe");
			sCliente.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("final del fichero");
		}

	}

}
