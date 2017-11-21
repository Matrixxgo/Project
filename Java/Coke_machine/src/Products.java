
public class Products {
	private int proTotal = 4;
	
	
	public Products(int total){
		this.proTotal = total;
	}


	public int getProTotal() {
		return proTotal;
	}


	public void setProTotal(int proTotal) {
		this.proTotal = proTotal;
	}
	
	public void removePro(int num){
		this.proTotal = proTotal - num;
	}

}
