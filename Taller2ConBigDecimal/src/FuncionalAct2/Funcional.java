package FuncionalAct2;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import Model.Product;
import Model.Product.Tax;

public class Funcional {
	
	public static void main(String[] args) {
		List<Product> listaProduct = List.of(
				new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
				new Product("Bread", new BigDecimal("5.20"), Tax.SUPERREDUCED),
				new Product("Meat", new BigDecimal("1.30"), Tax.REDUCED),
				new Product("Cheese", new BigDecimal("6.50"), Tax.SUPERREDUCED),
				new Product("Coke", new BigDecimal("8.60"), Tax.REDUCED),
				new Product("Whiskey", new BigDecimal("19.80"), Tax.NORMAL));
		
		
		BigDecimal cuenta = new BigDecimal(listaProduct.stream().mapToDouble(product -> product.price.doubleValue()).sum());
		System.out.println("Suma de todos los productos sin impuestos "+cuenta);
		
		BigDecimal cuentaImpuesto = new BigDecimal(listaProduct.stream().mapToDouble(product -> 
			product.price.doubleValue()+(((double)product.tax.getPercent()/100))).sum());
		System.out.println("Suma de todos los productos con impuestos "+cuentaImpuesto);
		
		System.out.println("Productos que empezan por C "+listaProduct.stream()
        	.filter(porC -> porC.name.startsWith("C"))
        	.collect(Collectors.toList()).toString());
		
		BigDecimal cuentaConImpuestoMayoresDeDiez = new BigDecimal(listaProduct.stream()
				.filter(producto -> producto.price.doubleValue() > 10)
				.mapToDouble(product -> 
		product.price.doubleValue()*(1.00+((double)product.tax.getPercent()/100))).sum());
		System.out.println("Precio total CON IMPUESTOS DE PRODUCTOS DE MAS DE 10: "+cuentaConImpuestoMayoresDeDiez);
	}
}
