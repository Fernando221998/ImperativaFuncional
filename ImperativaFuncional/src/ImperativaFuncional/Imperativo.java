package ImperativaFuncional;

import java.util.List;


public class Imperativo {
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		int contador=0;
		for(int num : numbers) {
			if(num>10) {
				contador++;
			}
		}
		
		System.out.println("Imperativa "+contador);
		
	}

}
