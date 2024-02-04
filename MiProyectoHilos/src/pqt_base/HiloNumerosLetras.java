package pqt_base;

public class HiloNumerosLetras implements Runnable {
	
	private int tipo;
	
	public HiloNumerosLetras(int numero) {
		this.tipo = numero;
	}
	
	@Override
	public void run() {
			
		switch (this.tipo) {
			case 1: 
				for (int i =1; i < 30; i++) {
					System.out.println(i);
				}
				break;
			case 2:					
				for (char c = 'a'; c < 'z'; c++) {
					System.out.println(c);
				}
			break;	
		}			
	}
}
