package APTriangle;
import java.util.*;
public class APTriangle {
	public int a = 0;
	public int b = 0;
	public int c = 0;
	
	public APTriangle(int A, int B, int C) {
		a = A;
		b = B;
		c = C;
	}
	public int getPerimeter() {
		return a+b+c;
	}
	public String isRight() {
		int d = (int) Math.sqrt((a*a)+(b*b));
		if (d == c){
			return "yes";
		}
		else {
			return "no";
		}
		
	}
}
