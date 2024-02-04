package pck_graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class CreandoMarcoCentral {

	public static void main(String[] args) {

		MarcoCentrado marco1 = new MarcoCentrado();

	}

}

class MarcoCentrado extends JFrame {

	public MarcoCentrado() {

		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Toolkit miPantalla = Toolkit.getDefaultToolkit();

		// Coger la dimension de la pantalla 1900X1000
		Dimension pantallaSize = miPantalla.getScreenSize();

		// Extraer el alto y el ancho (ejes x, y)
		int anchoPantalla = pantallaSize.width;
		int alturaPantalla = pantallaSize.height;

		setSize(anchoPantalla / 2, alturaPantalla / 2);

		setLocation(anchoPantalla / 4, alturaPantalla / 4);

		// Imagen
		Image miIcono = miPantalla.getImage("seta.gif"); // gif pesa menos

		this.setIconImage(miIcono);

		// título
		setTitle("Mi marco centrado");

	}

}