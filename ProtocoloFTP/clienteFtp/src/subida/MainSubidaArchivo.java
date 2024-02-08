package subida;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainSubidaArchivo {
    public static void main(String[] args) {

        FTPClient cliente = new FTPClient();

        String serverFTP="192.168.0.13";
        String usuario="administrador";
        String clave="1234";

        String archivo="mono.jpg";
        BufferedInputStream in= null;

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
            in = new BufferedInputStream(new FileInputStream(archivo));
            cliente.setFileType(FTP.BINARY_FILE_TYPE);
            cliente.storeFile("mono.jpg",in);
            in.close();
            System.out.println("Archivo subido con éxito.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
