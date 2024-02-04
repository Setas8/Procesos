package pqt_redireccionar;

import java.io.File;
import java.io.IOException;

public class Redireccionar {

	public static void main(String[] args) {
		
		///Controlar la ruta
		
		ProcessBuilder pb_java_jar  = new ProcessBuilder ("java","-jar","/home/alumnotd/votar.jar");
		ProcessBuilder pb_javaClass = new ProcessBuilder("java","-cp","/home/alumnotd/eclipse-workspace/pyt_medias/bin/pqt_numerosHastaCero", "Medias");
    	
		ProcessBuilder pb_progC     = new ProcessBuilder("/home/alumnotd/Escritorio/DIEGO CUADRADO/SERVICIOS Y PROCESOS/PROGRAMAS EN C");
		
		File fout= new File("/home/alumnotd/salida.txt");
		File fin = new File("/home/alumnotd/entrada.txt");
		File ferr= new File("/home/alumnotd/error.txt");
		
		pb_java_jar.redirectInput(fin);
		pb_java_jar.redirectOutput(fout);
		pb_java_jar.redirectError(ferr);
		
		/*
		pb_javaClass.redirectInput(fin);
		pb_javaClass.redirectOutput(fout);
		pb_javaClass.redirectError(ferr);
		
		pb_progC.redirectInput(fin);
		pb_progC.redirectOutput(fout);
		pb_progC.redirectError(ferr);
		*/
		
		try {
			Process p_jar = pb_java_jar.start();			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}