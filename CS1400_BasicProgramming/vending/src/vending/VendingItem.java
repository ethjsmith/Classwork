package vending;

public class VendingItem {
	
	// member variables first
	private double price;
	private String kind;
	private int quantity;
	private double money;
	
	// constructors second
	public VendingItem() {
		super();
	}
	public VendingItem(double price, String kind, int quantity) {
		super();
		this.price = price;
		this.kind = kind;
		this.quantity = quantity;
	}
	public VendingItem(String s) {
		String[] data=s.split(",");
		this.kind=data[0];
		this.price=Double.parseDouble(data[1]);
		this.quantity=Integer.parseInt(data[2]);
		
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public void setMoney(Double money) {
		this.money = money;
	}
	public Double getMoney() {
		return money;
	}
	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "VendingItem [price=" + price + ", kind=" + kind + ", quantity=" + quantity + "]";
	}
	
	
	
}
