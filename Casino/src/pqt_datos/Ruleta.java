package pqt_datos;

public class Ruleta {

private int numero=0;
	
	public Ruleta() {
		
	}
	public int getNumero() {
		return numero;
	}
	public void lanzar() {
		numero= (int)(Math.random()*37); 
	}
}