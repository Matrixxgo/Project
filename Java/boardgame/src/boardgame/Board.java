package boardgame;
import java.util.*;


public class Board {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Player 1 will pick 10 cards. \n4 Treasure cards, 3 Game Over cards, and 3 Extra turn cards.\nYou will get 10 turns and 4 treasures wins the game! \nGood Luck.\n");
		System.out.println("Hello player 1. Let's play!");
		card[][] cards = new card[5][5];
		int front = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				card aCard = new card(front, "B");
				cards[i][j] = aCard;
				front = front + 1;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(String.format("%5d",cards[i][j].getFront()));
			}
			System.out.println();
		}
		

		ArrayList<Integer> allNums = new ArrayList<Integer>();
		setBack(4,"T","Treasure",cards,allNums);
		setBack(3,"GO","Game Over",cards, allNums);
		setBack(3,"ET","Extra Turn",cards, allNums);

		letsPlay(cards);
		

	}
	
	
public static void letsPlay(card[][] cards3) {
	Scanner key = new Scanner(System.in);
	int c = 0;
	ArrayList<Integer> chosen = new ArrayList<Integer>();
	int TreCount = 0;
	while (c < 10) {
		printCard(cards3);
		System.out.print("Player 2, pick a number between 1 & 25: ");
		int num = key.nextInt();
		if (num < 1 || num > 25) {
			System.out.println("You picked a number which is higher than 25 or lower than 1. Try again.");
		}else
		{
			if (chosen.contains(num)) {
				System.out.println("You have already picked that number. Try again");
			}else {
				chosen.add(num);
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if(cards3[i][j].getaltFront().equals(String.valueOf(num))){
							cards3[i][j].changeFront();
							if (cards3[i][j].getaltFront().equals("T")) {
								TreCount = TreCount + 1;
								c = c+1;
							}
							else if (cards3[i][j].getaltFront().equals("GO")) {
								printCard(cards3);
								System.out.println("Game over, You lose.");
								c=10;
							}
							else if (cards3[i][j].getaltFront().equals("ET")) {
								c = c-1;
							}
							else {
								c = c+1;
							}
						}
					}
				}
			}
		}
		if (TreCount == 4) {
			printCard(cards3);
			System.out.println("Congratulations Player 2, you win!");
			c=10;
		}
	}
	
}
	

public static void printCard(card[][] cards4) {
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			System.out.print(String.format("%5s",cards4[i][j].getaltFront()));
		}
		System.out.println();
	}
}
	

	public static void setBack(int i, String lc, String uc, card[][] cards2, ArrayList<Integer> allNums2) {
		int t = 0;
		Scanner keyboard = new Scanner(System.in);
		while (t< i) {
			System.out.print("Enter the card number where you want " +uc+ " to be in: ");
			int tre = keyboard.nextInt();
			if(tre > 25 || tre < 1) {
				System.out.println("You've picked the wrong number. Please try again.");
			}
			else {
				if (allNums2.contains(tre)) {
					System.out.println("You have already picked that number. Try again");
				}
				else {
					allNums2.add(tre);
					t = t+1;
					for (int f = 0; f < 5; f++) {
						for (int j = 0; j < 5; j++) {
							if (cards2[f][j].getFront() == tre) {
								cards2[f][j].setBack(lc);
								
							}
						}
					}
				}
			}
		}
	}
}