package ImperativaFuncional;

import java.util.List;

public class Funcional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		
		System.out.println("Funcional "+numbers.stream().filter(num -> num>10).count());
		
	}
}
