package juegoNumHilosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HiloServer extends Thread {

	private Socket scCliente;
	private DataInputStream in;
	private DataOutputStream out;
	InputStream inAux = null;
	OutputStream outAux = null;
	public HiloServer(Socket scCliente) {
		this.scCliente = scCliente;


//		try {
//			inAux = scCliente.getInputStream();
//			outAux = scCliente.getOutputStream();
//			in = new DataInputStream(inAux);
//			out = new DataOutputStream(outAux);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}// Fin constructor

	@Override
	public void run() {

		System.out.println(
				"Atendiendo al cliente " + scCliente.getInetAddress() + " por el puerto " + scCliente.getPort());

		int numCliente;
		int numRespuesta;
		boolean correcto = false;
		int numGenerado = (int) (Math.random() * 100) + 1;

		while (!correcto) {

			try {
				inAux = scCliente.getInputStream();
				in = new DataInputStream(inAux);

				outAux = scCliente.getOutputStream();
				out = new DataOutputStream(outAux);

				numCliente = in.readInt();
				System.out.println("cliente: " + numCliente);
				System.out.println("secreto: " + numGenerado);

				if (numCliente > numGenerado) {
					numRespuesta = -1;
					out.writeInt(numRespuesta);
				} else if (numCliente < numGenerado) {
					numRespuesta = 1;
					out.writeInt(numRespuesta);
				} else {
					numRespuesta = 0;
					out.writeInt(numRespuesta);
					correcto = true;

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
