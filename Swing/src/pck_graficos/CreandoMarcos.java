package pck_graficos;

import java.awt.Frame;
import java.awt.Image;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {

		MiMarco marco1 = new MiMarco();

		// por defecto es false
		marco1.setVisible(true);

		// hay que decirle qué hace el programa cuando se cierre el marco
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MiMarco extends JFrame {

	public MiMarco() {

		// setSize(500,300); // dimensión

		// setLocation(500,300); //X Y ubicación

		setBounds(500, 300, 550, 250); // ubicación + dimensión

		// setResizable(false); //Impedir que se redimensione

		// setExtendedState(Frame.MAXIMIZED_BOTH); //maximizar el marco

		setTitle("Mi marco"); // Título del marco

	}

}
