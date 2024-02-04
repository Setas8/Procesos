package pqt_join;

public class ContadorHilo implements Runnable{

	private int contador;
	private int limite;
	private String nombre;
	
	
	
	public ContadorHilo(String nombre, int limite) {
		super();
		this.contador = 0;
		this.limite   = 30;
		this.nombre   = nombre;
	}
	@Override
	public void run() {
		
		while (contador <= limite) {
			
			System.out.println("Hilo " + nombre + ": " + contador);						
			contador++;
		}		
		System.out.println("Hilo " + nombre + " terminó");
	}
}
