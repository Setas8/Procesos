package pqt_sets;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Set<Integer> conjunto = new HashSet<Integer>();

//		if (conjunto.add(7))
//			System.out.println("añado");
//		else
//			System.out.println("No añado");
//		System.out.println("Conjunto: " + conjunto);
//		// Si existe en el conjunto, no lo añade
//		if (conjunto.add(7))
//			System.out.println("añado");
//		else
//			System.out.println("No añado");
//
//		System.out.println("Conjunto: " + conjunto);
//		if (conjunto.add(14))
//			System.out.println("añado");
//		else
//			System.out.println("No añado");

		int num;
		while (conjunto.size() < 3) {
			num = (int) (Math.random() * 6) + 1;
			System.out.println(num);
			conjunto.add(num);
		}
		System.out.println("Conjunto: " + conjunto);
		System.out.println("Tamaño conjunto: " + conjunto.size());
		
		System.out.println("- - - - - - - - - -");
		int num2 = (int) (Math.random() * 6) + 1;
		System.out.println(num2);
		if (conjunto.contains(num2)) 
			System.out.println("El número está en el conjunto");
		else
			System.out.println("El número NO está en el conjunto");

	}
}
