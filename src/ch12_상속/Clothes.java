package ch12_상속;

public class Clothes extends Product {
	
	public Clothes(String model, int price) {
		super(model, price);
		// TODO Auto-generated constructor stub
	}
	//generate constr using fields
	public Clothes(String model, int price, String size, String color) {
		super(model, price);
		this.size = size;
		this.color = color;
	}

	private String size;
	private String color;
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
