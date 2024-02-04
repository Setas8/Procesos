package clases;

import javax.swing.*;
import java.awt.*;

public class MarcoChat extends JFrame {
    private String nombreUsuario;
    private JPanel mainPanel;
    private JTextArea txAPantalla;
    private JButton btnEnviar;
    private JTextField txFMensaje;
    private JTextArea txAUsuarios;

    public MarcoChat(String nombreUsuario) {

        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setTitle("Chat de " + nombreUsuario);

        Toolkit pantalla = Toolkit.getDefaultToolkit();

        // Coger la dimension de la pantalla 1900X1000
        Dimension pantallaSize = pantalla.getScreenSize();


        // Extraer el alto y el ancho (ejes x, y)
        int anchoPantalla = pantallaSize.width;
        int alturaPantalla = pantallaSize.height;

        this.setSize(anchoPantalla / 2, alturaPantalla / 2);
        this.setLocation(anchoPantalla / 4, alturaPantalla / 4);

        // Imagen
        Image icono = pantalla.getImage("seta.gif"); // gif pesa menos
        this.setIconImage(icono);

        //Impedir que se redimensione
        this.setResizable(false);



        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
