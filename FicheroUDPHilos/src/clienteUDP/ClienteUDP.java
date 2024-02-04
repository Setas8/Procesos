package clienteUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteUDP {

	public static void main(String[] args) {
		int puerto=6001;
		DatagramSocket cliente=null;
		try {
			cliente=new DatagramSocket();
		} catch (SocketException e) {
		
			e.printStackTrace();
		}
		Scanner teclado=new Scanner(System.in);
		String nombreArchivo="";
		System.out.println("archivo solicitado:");
		nombreArchivo=teclado.nextLine().trim();
		byte[] buffer=new byte[256];
		buffer=nombreArchivo.getBytes();
		InetAddress destino=null;
		try {
			destino = InetAddress.getByName("localhost");
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		DatagramPacket peticion = new DatagramPacket(buffer, buffer.length,
									destino,puerto);
		try {
			cliente.send(peticion);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//bucle respuesta
		byte[] bufferResp = new byte[256];
		DatagramPacket respuesta = new DatagramPacket(bufferResp,bufferResp.length);
		try {
			cliente.receive(respuesta);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		String archivo = new String(respuesta.getData()).trim();
		
		System.out.println(archivo);
		
		cliente.close();
	}

}
