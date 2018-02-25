package boardgame;

public class card {
	private int front;
	private String back;
	String altFront;
	public card(int f, String b) {
		this.front = f;
		this.back = b;
	}

	public int getFront() {
		altFront = String.valueOf(front);
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}
	
	public void changeFront() {
		altFront = back;
	}
	
	public String getaltFront() {
		return altFront;
	}
	
}
