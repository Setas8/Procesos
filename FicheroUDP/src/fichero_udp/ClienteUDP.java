package fichero_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        Scanner tcd = new Scanner(System.in);

        DatagramSocket socketUDP = null;
        final int PUERTO_SERVER = 5001;
        byte[] buffer = new byte[256];

        InetAddress direccionServidor = null;

        System.out.println("Dime nombre de archivo solicitado: ");
        String nombreArchivo = tcd.nextLine().trim() + ".txt";

        try {
//			direccionServidor = InetAddress.getLocalHost();
            direccionServidor = InetAddress.getByName("localhost");

            socketUDP = new DatagramSocket();

            buffer = nombreArchivo.getBytes();

            DatagramPacket solicitud = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVER);


            System.out.println("Envío el datagrama");
            socketUDP.send(solicitud);

            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(respuesta);

            String archivo = new String(respuesta.getData(), 0, respuesta.getLength());

            System.out.println(archivo);

            socketUDP.close();


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
