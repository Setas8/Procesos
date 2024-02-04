package pck_loteria;

import java.util.HashSet;
import java.util.Set;

public class Sorteo {
	
	private Set<Integer> numerosGanadores = new HashSet<Integer>();

	public Sorteo() {
		generarApuestas(this.numerosGanadores);
	}

	public Set<Integer> getNumerosGanadores() {
		return numerosGanadores;
	}

	public void setNumerosGanadores(Set<Integer> numerosGanadores) {
		this.numerosGanadores = numerosGanadores;
	}
	
	private void generarApuestas(Set conj) {		
		conj.clear();
		while (conj.size() < 3) {
			int num = (int) (Math.random() * 48) + 1;
			conj.add(num);				
		}		
	}
}
