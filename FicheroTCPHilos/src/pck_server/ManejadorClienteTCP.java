package pck_server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ManejadorClienteTCP extends Thread {

	private Socket cliente;
	DataInputStream flujo_entrada = null;
	DataOutputStream flujo_salida = null;

	public ManejadorClienteTCP(Socket cliente) {
		this.cliente = cliente;
		InputStream inaux = null;
		OutputStream outaux = null;
		try {
			inaux = cliente.getInputStream();
			outaux = cliente.getOutputStream();
			flujo_entrada = new DataInputStream(inaux);
			flujo_salida = new DataOutputStream(outaux);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// fin constructor

	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("atiendo petición cliente" + cliente.getInetAddress() + ":" + cliente.getPort());

		String nombreArchivo = null;
		try {
			nombreArchivo = flujo_entrada.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Archivo:" + nombreArchivo);
		// comprobar si existe
		try {
			File archivo = new File(nombreArchivo);
			if (archivo.exists()) {
				flujo_salida.writeInt(200);
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {
					// System.out.println(linea);
					flujo_salida.writeUTF(linea);
					Thread.sleep(1000);
					// flujo_salida.writeChars(linea+"\n");
				}
				br.close();
			} else {
				System.out.println("fichero no encontrado");
				flujo_salida.writeInt(404);
			}
			flujo_salida.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// fin run
}// fin class
