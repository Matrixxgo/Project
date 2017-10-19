package APTriangle;
import java.util.*;
import java.io.*;
import java.util.*;



public class triangle {

	public static void main(String[] args) {
		int first, second, third;
		Scanner my_in = new Scanner(System.in);
		System.out.println("Enter side a of the triangle");
		first = my_in.nextInt();
		System.out.println("Enter side b of the triangle");
		second = my_in.nextInt();
		System.out.println("Enter side c of the triangle");
		third = my_in.nextInt();
		
		
		APTriangle tri = new APTriangle(first,second,third);
		System.out.println("The perimeter is: "+tri.getPerimeter());
		System.out.println("Is it right triangle?: " + tri.isRight());
		
		
		
		
		
		
		
		
		
		
		
		String fileName = "/Users/saqlain/Movies/hello.txt";
		File txtFile = new File(fileName);
		
		Scanner scanner;
		try {
			scanner = new Scanner(txtFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}
			scanner.close();
		}catch (FileNotFoundException e) {
			System.out.println("Dude, your file is not there");
		}
		
	}
}
