package pqt_hilos;


public class HiloContador implements Runnable{
		
    private String frase;
    private char vocal;

    public HiloContador(String frase, char vocal){
        this.frase = frase;
        this.vocal = vocal;
    }
    
    public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public char getVocal() {
		return vocal;
	}

	public void setVocal(char vocal) {
		this.vocal = vocal;
	}

	@Override
    public void run() {
        int suma = 0;
        for(char letra : frase.toCharArray()){
            if((letra + "").equalsIgnoreCase(vocal + "")){
                suma++;
            }
        }
        System.out.println("Vocal " + vocal + " : " + suma);
    }    
}