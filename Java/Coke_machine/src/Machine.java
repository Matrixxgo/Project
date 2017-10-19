import java.util.*;
public class Machine {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		double total = 0.0;
		boolean loop = true;
		Products coke = new Products(4);
		Products sprite = new Products(4);
		Products fanta = new Products(4);
		while (loop){
			Scanner inLoop = new Scanner(System.in);
			System.out.println("Please insert quarters");
			double quarters = input.nextDouble();
			System.out.println("Please insert dimes");
			double dimes = input.nextDouble();
			System.out.println("Please insert nickels");
			double nickel = input.nextDouble();
			total = total +  (quarters*.25)+(dimes*.10)+(nickel*.05);
			if(total >= .75){
				System.out.println("We have these products: ");
				System.out.println("Coke: " + coke.getProTotal());
				System.out.println("Sprite: " + sprite.getProTotal());
				System.out.println("Fanta: " + fanta.getProTotal());
				
				System.out.println("Please enter what product you would like: ");
				String choice = inLoop.nextLine();
				choice.toLowerCase();
				if (choice.equals("coke")){
					System.out.println("Your coke is being dispensed. Enjoy!");
					coke.removePro(1);
					total = total - .75;
				}
				else if (choice.equals("sprite")){
					System.out.println("Your sprite is being dispensed. Enjoy!");
					sprite.removePro(1);
					total = total - .75;
				}
				else if (choice.equals("fanta")){
					System.out.println("Your sprite is being dispensed. Enjoy!");
					fanta.removePro(1);
					total = total - .75;
				}
				System.out.println("Would you like to get another product?");
				String goAgain = inLoop.nextLine();
				goAgain.toLowerCase();
				if (goAgain.equals("yes")){
					loop = true;
				}
				else {
					System.out.println("Thank you for your purchase. Your change of " +total+" can be found in the change slot.");
					loop = false;
					input.close();
					inLoop.close();
				}
			}	
			else{
				System.out.println("You have "+total+". Please enter at least .75 to purchase something.");
				System.out.println("Hit the cancel button to cancel the sale or just hit enter to insert more coins");
				String cancel = inLoop.nextLine();
				cancel.toLowerCase();
				if (cancel.equals("cancel")){
					loop = false;
				}
			}

		}
	}
}