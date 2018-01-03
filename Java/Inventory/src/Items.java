
public class Items {
	private double price;
	private int amount;
	private String name;
	private String avalVal;
	private static String[] avalList = new String[] {"Instore","Online","Instore & Online"};
	private String colorVal;
	private static String[] colorList = new String[] {"Black","White"};
	private int upc;
	
	
	public Items(String name, double price, int amount, int color, int aval, int upc) {
		this.price = price;
		this.amount = amount;
		this.name = name;
		this.avalVal = avalList[aval-1];
		this.colorVal = colorList[color-1];
		this.upc = upc;
	}
	
	

	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAval() {
		return avalVal;
	}
	public void setAval(int aval) {
		this.avalVal = avalList[aval-1];
	}
	public String getColor() {
		return colorVal;
	}
	public void setColor(int color) {
		this.colorVal = colorList[color-1];
	}
	public int getUpc() {
		return upc;
	}
	public void setUpc(int upc) {
		this.upc = upc;
	}
	

}
