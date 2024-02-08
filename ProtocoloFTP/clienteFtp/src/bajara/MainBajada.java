package bajara;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class MainBajada {
    public static void main(String[] args) {
        FTPClient cliente=new FTPClient();

        String serverFTP="192.168.0.13";
        String usuario="administrador";
        String clave="1234";

        String archivo="descargado.jpg";
        BufferedOutputStream out= null;
        System.out.println("Nos vamos a conectar a "+serverFTP);
        try {
            cliente.connect(serverFTP);
            System.out.println(cliente.getReplyString());
            int codigo=cliente.getReplyCode();
            System.out.println("Código:"+codigo);
            if (!FTPReply.isPositiveCompletion(codigo)) {
                cliente.disconnect();
                System.out.println("Conexión rechazada");
                System.exit(0);
            }
            if (!cliente.login(usuario,clave)) {
                cliente.disconnect();
                System.out.println("Conexión rechazada");
                System.exit(0);
            }
            out = new BufferedOutputStream(new FileOutputStream(archivo));
            cliente.setFileType(FTP.BINARY_FILE_TYPE);

            if(cliente.retrieveFile("mono.jpg",out))
                System.out.println("Archivo descargado con éxito.");
            else
                System.out.println("No se pudo descargar el archivo.");
            out.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
