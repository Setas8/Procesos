package fichero_udp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP {
    public static void main(String[] args) {

        final int PUERTO = 5001;
        byte[] buffer = new byte[256];
        DatagramSocket socketUDP = null;

        try {
            socketUDP = new DatagramSocket(PUERTO);
            System.out.println("Iniciado el servidor");


            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(peticion);

            System.out.println("Recibo la información del cliente");

            String mensaje = new String(peticion.getData(), 0, peticion.getLength());
            System.out.println("Archivo solicitado: " + mensaje);

            int puertoCliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();

            String archivo = leerArchivo(mensaje);
            buffer = archivo.getBytes();

            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

            System.out.println("Envío la información del cliente");
            socketUDP.send(respuesta);


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String leerArchivo(String nombreArchivo) {

        String cadena = "";
        try {
            File fichero = new File(nombreArchivo);
            if (fichero.exists()) {

                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);

                String datos;

                while ((datos = br.readLine()) != null) {
                    cadena += datos;
                }

                br.close();
                fr.close();

            } else {
                cadena = "El archivo no existe";
            }
            return cadena;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al leer el archivo";
        }
    }
}
