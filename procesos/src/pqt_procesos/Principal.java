package pqt_procesos;

import java.io.IOException;
import java.io.InputStream;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("día");
		ProcessBuilder pb = new ProcessBuilder("pluma", "hola.txt"); //linea de comandos para lanzar el comando
		
		try {
			Process p = pb.start();
			System.out.println("Proceso lanzado");
			p.waitFor();  //Proceso padre debe esperar al proceso hijo
			System.out.println("Proceso terminado");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//OJO con la ruta
		ProcessBuilder pb_comando = new ProcessBuilder("ls","-l","/home/alumnotd/");
		
		try {
			System.out.println("Lanzo comando");
			Process pComando = pb_comando.start(); //no se redirige la salida
			
			InputStream is = pComando.getInputStream(); //salida leer Streams a bajo nivel 			
			int c;
			while ((c=is.read())!=-1)
			{
				System.out.print((char)c);
				
			}	
			is.close();
			System.out.println("Comando terminado");			
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		//Ejecutar por comando un archivo class
		ProcessBuilder pb_javaClass= new ProcessBuilder("java","-cp","/home/administrador/eclipse-workspace/primerPrograma/bin", "HelloWorld");
    	//Ejecutar por comando un archivo class en un paquete
		//OJO con la ruta
		ProcessBuilder pb_javaClass2= new ProcessBuilder("java","-cp","/home/alumnotd/eclipse-workspace/primerPrograma/bin/", "pqt_principal.MainSaludo");
		
		//Lanzar un programa java en archivo class en un paquete
		System.out.println("lanzando un java class de un paquete");
		try {
			Process     p4 = pb_javaClass2.start();
			InputStream is = p4.getInputStream();
			int c;
			while ((c=is.read())!=-1)
			{
				System.out.print((char)c);				
			}	
			is.close();
		}
		catch (IOException e) 
		{
 			System.out.println("Problema al lanzar el proceso");
 		}
		ProcessBuilder pb_java_jar= new ProcessBuilder ("java","-jar","/home/alumnotd/saludar.jar");
		//lanzar un archivo jar
		System.out.println("lanzando un java jar");
		try {
			Process     p5 = pb_java_jar.start();
			InputStream is = p5.getInputStream();
			int c;
			while ((c=is.read())!=-1)
			{
				System.out.print((char)c);
				
			}	
			is.close();
		}
		catch (IOException e) 
		{
 			System.out.println("Problema al lanzar el proceso");
 		}
	
	}

}
