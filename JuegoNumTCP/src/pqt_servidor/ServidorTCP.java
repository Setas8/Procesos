package pqt_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) {
		
		int puerto = 6666;
		int numGenerado = (int)(Math.random()*100)+1;
		int numRespuesta = 0;
		boolean correcto = false;
		ServerSocket servidor=null;
		
		try {
			servidor=new ServerSocket(puerto);
			
			System.out.println("escucho en el puerto" + puerto);
			Socket cliente1=servidor.accept();			
					
			InputStream inaux = cliente1.getInputStream();
			DataInputStream flujo_entrada = new	 DataInputStream(inaux);
										
			OutputStream outaux = cliente1.getOutputStream();
			DataOutputStream flujo_salida= new DataOutputStream(outaux);		
						
			while(!correcto) {
											
				int numCliente = flujo_entrada.readInt();
				
				if (numCliente == numGenerado) {
					numRespuesta = 0;
					flujo_salida.writeInt(numRespuesta);
					correcto = true;
				}
				else if (numCliente < numGenerado) {
					numRespuesta = 1;
					flujo_salida.writeInt(numRespuesta);
				}else {
					numRespuesta = -1;
					flujo_salida.writeInt(numRespuesta);
				}
															
			}
					
			flujo_salida.close();				
			servidor.close();			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
