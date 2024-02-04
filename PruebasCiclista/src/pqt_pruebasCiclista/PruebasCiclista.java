package pqt_pruebasCiclista;

import java.io.File;
import java.io.IOException;

public class PruebasCiclista {

	public static void main(String[] args) {
			
		ProcessBuilder pr1 = new ProcessBuilder("/home/diego/Desktop/PRUEBA4/mainCiclista");
		ProcessBuilder pr2 = new ProcessBuilder("/home/diego/Desktop/PRUEBA4/mainCiclista");
		ProcessBuilder pr3 = new ProcessBuilder("/home/diego/Desktop/PRUEBA4/mainCiclista");
		
				
		//Entrada con datos correctos
		File fout1 = new File("/home/diego/Desktop/PRUEBA4/salida1.txt");
		File fin1  = new File("/home/diego/Desktop/PRUEBA4/entrada1.txt");
		File ferr1 = new File("/home/diego/Desktop/PRUEBA4/error1.txt");
						
		
		//Entrada errónea con un char en lugar de int
		File fout2 = new File("/home/diego/Desktop/PRUEBA4/salida2.txt");
		File fin2  = new File("/home/diego/Desktop/PRUEBA4/entrada2.txt");
		File ferr2 = new File("/home/diego/Desktop/PRUEBA4/error2.txt");
		
		//Entrada errónea con un float con ',' en lugar de con '.'
		File fout3 = new File("/home/diego/Desktop/PRUEBA4/salida3.txt");
		File fin3  = new File("/home/diego/Desktop/PRUEBA4/entrada3.txt");
		File ferr3 = new File("/home/diego/Desktop/PRUEBA4/error3.txt");
	
		
		pr1.redirectInput(fin1);
		pr1.redirectOutput(fout1);
		pr1.redirectError(ferr1);
		
    	pr2.redirectInput(fin2);
		pr2.redirectOutput(fout2);
		pr2.redirectError(ferr2);
		
		pr3.redirectInput(fin3);
		pr3.redirectOutput(fout3);
		pr3.redirectError(ferr3);
		
		try {
			Process p1 = pr1.start();	
			Process p2 = pr2.start();
			Process p3 = pr3.start();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
