package Model;

public class Product {

	public String name;
	public Double price; 
	public Tax tax;
	
	
	public Product(String name, Double price, Tax normal) {
		this.name = name;
		this.price = price;
		this.tax = normal;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public Tax getTax() {
		return tax;
	}



	public void setTax(Tax tax) {
		this.tax = tax;
	}

	


	@Override
	public String toString() {
		return name;
	}




	public enum Tax{
		SUPERREDUCED(4),REDUCED(10),NORMAL(21);
		
		public int percent;
		
		private Tax(int percent) {
			this.percent=percent;
		}
		public int getParent() {
			return percent;
		}
		
		
	}
	
}

