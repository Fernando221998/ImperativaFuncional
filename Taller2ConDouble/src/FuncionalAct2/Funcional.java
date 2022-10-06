package FuncionalAct2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Model.Product;
import Model.Product.Tax;

public class Funcional {

	public static void main(String[] args) {
		List<Product> listaProduct = List.of(
				new Product("Clothes", 15.90, Tax.NORMAL),
				new Product("Bread", 5.20, Tax.SUPERREDUCED),
				new Product("Meat", 1.30, Tax.REDUCED),
				new Product("Cheese", 6.50, Tax.SUPERREDUCED),
				new Product("Coke", 8.60, Tax.REDUCED),
				new Product("Whiskey", 19.80, Tax.NORMAL));
	
		Optional<Double> cuenta =listaProduct.stream().map(producto -> producto.getPrice()).reduce((x, y) -> x + y);
		
		System.out.println("Suma de todos los productos sin impuestos "+cuenta.get());
		
		Optional<Double> cuentaImpuesto =listaProduct.stream()
				.map(producto -> producto.getPrice() + ((producto.getPrice() + producto.tax.percent)/100))
				.reduce((x, y) -> x + y);
		
		System.out.println("Suma de todos los productos con impuestos "+cuentaImpuesto.get());
		
		System.out.println("Productos que empezan por C "+listaProduct.stream()
        .filter(porC -> porC.getName().startsWith("C"))
        .collect(Collectors.toList()).toString());
		
	}
}
