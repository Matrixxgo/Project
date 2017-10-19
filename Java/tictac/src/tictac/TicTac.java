package tictac;
import java.util.Scanner;


public class TicTac {

	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {


		
			

			boolean currentPlayer1 = true;
			

			int winStatus = -1;
			
			boolean validMove = false;
			

			String gameBoard = "012345678";
			
			String playerName = "";
			int playerMove = 9;
		

		ShowGreeting();
		

		while (winStatus < 0){

			validMove = false;
			

			playerName = GetPlayerName(currentPlayer1);
					
			ShowBoard(gameBoard);
			

			while (!validMove){
				playerMove = GetInt(playerName + ", please enter the number of the position you would like to take.");
				if (playerMove < gameBoard.length() && playerMove >= 0){
			
					if (gameBoard.charAt(playerMove)!='X' && gameBoard.charAt(playerMove)!='O'){
						
						validMove = true;
					}
					else{
						System.out.println("Sorry, that space is taken.");
					}
					
				}
				else{
					System.out.println("Sorry, that is not a valid space.");
				}
			}
			
		
			gameBoard = InsertMove(gameBoard, playerMove, currentPlayer1);
			
			
			winStatus = CheckWin(gameBoard);
			
			if (winStatus < 0){
				
				
				currentPlayer1 = !currentPlayer1;
			}
			
		}
		
		
		ShowBoard(gameBoard);
		
		
		switch (winStatus){
		case 1:
			System.out.println("Congratulations " + playerName + "!  You Win!");
			break;
		case 0:
			System.out.println("The game is a TIE!  What a match!");
			break;
		default:
			System.out.println("Something went wrong, contact the game developer support line.");
			break;
		}
		
		
		
		userInput.close();
	
	}


	public static String InsertMove(String myBoard, int theMove, boolean thePlayer){
		
		if (thePlayer){
			myBoard = myBoard.replace(myBoard.charAt(theMove), 'X');
		}
		else{
			myBoard = myBoard.replace(myBoard.charAt(theMove), 'O');
		} 
		
		return myBoard;
	}
	
	public static String GetPlayerName(boolean isPlayer1){
		if (isPlayer1){
			return "Player 1";
		}
		else{
			return "Player 2";
		}
	}

	public static int GetInt(String myPrompt){
		boolean validNum = false;
		int anyInt = 0;
		
		while(!validNum){
			
			System.out.println(myPrompt);
			
			try{
				anyInt = Integer.parseInt(userInput.nextLine());
				validNum = true;
			}
			catch(NumberFormatException exp1){
	
				System.out.println("You did not enter a valid integer.");
			}
		
		}
		
		return anyInt;
	}
	
	public static int CheckWin(String theBoard){
		boolean isTie = true;
		
		int gameStatus = -1;
		
		if (	theBoard.charAt(0) == theBoard.charAt(1) && theBoard.charAt(0) == theBoard.charAt(2) ||
				theBoard.charAt(0) == theBoard.charAt(3) && theBoard.charAt(0) == theBoard.charAt(6) ||
				theBoard.charAt(0) == theBoard.charAt(4) && theBoard.charAt(0) == theBoard.charAt(8) ||
				theBoard.charAt(1) == theBoard.charAt(4) && theBoard.charAt(1) == theBoard.charAt(7) ||
				theBoard.charAt(2) == theBoard.charAt(4) && theBoard.charAt(2) == theBoard.charAt(6) ||
				theBoard.charAt(2) == theBoard.charAt(5) && theBoard.charAt(2) == theBoard.charAt(8) ||
				theBoard.charAt(3) == theBoard.charAt(4) && theBoard.charAt(3) == theBoard.charAt(5) ||
				theBoard.charAt(6) == theBoard.charAt(7) && theBoard.charAt(6) == theBoard.charAt(8) 
			
			
			){
			gameStatus = 1;
		}
		

		for (int i = 0; i < theBoard.length(); i++){
			if (theBoard.charAt(i)!='X' && theBoard.charAt(i)!='O'){
				isTie = false;
			}
		}
		
		if (isTie){
			gameStatus = 0;
		}
		
		return gameStatus;
	}
	
	public static void ShowGreeting() {
		System.out.println("Let's play Tic Tac Toe. Player 1 = X and Player 2 = O.\nPlease enter the box number to place your mark. ");
	}
	
	public static void ShowBoard(String gameboard) {
		System.out.println(gameboard.charAt(0) + " | " + gameboard.charAt(1) + " | " + gameboard.charAt(2));
		System.out.println("---------");
		System.out.println(gameboard.charAt(3) + " | " + gameboard.charAt(4) + " | " + gameboard.charAt(5));
		System.out.println("---------");
		System.out.println(gameboard.charAt(6) + " | " + gameboard.charAt(7) + " | " + gameboard.charAt(8));

	}
}