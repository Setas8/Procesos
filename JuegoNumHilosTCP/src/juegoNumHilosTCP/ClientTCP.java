package juegoNumHilosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {

	public static void main(String[] args) {
		
		Scanner tcd = new Scanner(System.in);
		
		int numero = 0;
		int intentos = 0;
		
		
		try {
			Socket sCliente = new Socket("localhost", 5001);
			System.out.println("Conectado...");
			
			System.out.println("Introduce un número del 1 al 100: ");
			
			//Número del servidor
			InputStream inaux = sCliente.getInputStream();
			DataInputStream flujo_entrada = new	 DataInputStream(inaux);
			int codigo = -2;
			OutputStream outaux = sCliente.getOutputStream();
			DataOutputStream flujo_salida= new DataOutputStream(outaux);				
						
			while(codigo != 0) {
				intentos++;
				numero = tcd.nextInt();tcd.nextLine();
				flujo_salida.writeInt(numero);
				codigo = flujo_entrada.readInt();
				
				if (codigo == 1) {
					System.out.println("El número es mayor");
				}
				else if (codigo == -1) {
					System.out.println("El número es menor");
				}																	
			} 	
			System.out.println("Correcto!!!\nAcertaste en " + intentos + " intentos");
			flujo_entrada.close();
			flujo_salida.close();	
			sCliente.close();
			tcd.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
