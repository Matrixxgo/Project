import java.util.*;
public class Project {

	public static void main(String[] args) {
		String[] choices = new String[] {"Products","Services","Tools","Support","Contacts","Inventory","Exit"};
		boolean loop = true;
		Scanner input = new Scanner(System.in);
				
		System.out.println("Welcome to our car dealership. We offer many things for our existing customer, as well as options for our new customers. We service other delarships, also."
				+ "\nPlease choose the option that fits you best."	);
		
		while (loop) {
			System.out.println("");
			for(int i = 0; i < choices.length; i++) {
				System.out.println((i+1)+")"+choices[i]);
			}
			System.out.print("Please choose a option: ");
			int userOption = input.nextInt();
			System.out.print("\n");
			if (userOption > choices.length || userOption < 0) {
				System.out.println("Please enter an appropriate option\n");
			}
			else if (userOption == 1) {
				loop = Products();
			}
			else if (userOption == 2) {
				loop = Services();
			}
			else if (userOption == 3) {
				loop = Tools();
			}
			else if (userOption == 4) {
				loop = Support();
			}
			else if (userOption == 5) {
				loop = Contacts();
			}
			else if (userOption == 6) {
				loop = Inventory();
			}
			else if (userOption == 7) {
				loop = false;
			}

		}
	}
	
	
	
	
	
	public static boolean Products() {
		Scanner input = new Scanner(System.in);
		boolean loop_product = true;
		String[] products = new String[] {"Accesories","Cars","Go back","Exit"};
		while (loop_product) {
			for (int i=0; i < products.length;i++) {
				System.out.println((i+1)+")"+products[i]);
			}
		System.out.print("Please choose an option: ");
		int proChoice = input.nextInt();
		if (proChoice > products.length || proChoice < 0) {
			System.out.println("Please enter an appropriate option\n");
		}
		
		else if (proChoice == 1) {
			System.out.println("\nWe have plenty of accesories to choose from. We have listen them below, along with their prices");
			System.out.println("Remote Starter: $159.99");
			System.out.println("Floor Mats: $59.99");
			System.out.println("Cell Phone Wireless FM Transmitter: $49.99");
			System.out.println("Seat Covers: $79.99");
			System.out.println("Gap Trap: $20.99");
			System.out.println("Cell phone mount: $49.99");
			System.out.println("Clothes Hanger: $11.99");
			System.out.println("Seat Cushion: $29.99");
			System.out.println("Car Cover: $59.99");
			System.out.println("Please note that these prices do not include tax\n");
			
		}
		
		else if (proChoice == 2) {
			int commute, sS, eco, budget, sport,years;
			System.out.println("\nLet's get you a car! You will be asked questions to find the best car that fits your needs\n");
			System.out.print("Will you use it to communite everyday?\nEnter 1 for Yes and 2 for No: ");
			commute = input.nextInt();
			System.out.print("Do you want a sedan or SUV?\nEnter 1 for sedan, or 2 for SUV: ");
			sS = input.nextInt();
			System.out.print("Are you looking for a eco-friendly car?\nEnter 1 for eco-friendly or 2 for non-eco friendly: ");
			eco = input.nextInt();
			System.out.print("Is your budget more than 30,000 or is it less than 30,000?\nEnter 1 for more than or 2 for less than: " );
			budget = input.nextInt();




			//the recomendations!, commute = yes
			if(commute == 1 && sS == 1 && eco == 1 && budget == 1 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Chevy Bolt, which has an MSRP of 35,000");
			System.out.println("Your monthly payment will be: " + ((35000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Chevy Bolt Sports model, which has an MSRP of 37,000");
			System.out.println("Your monthly payment will be: " + ((37000)/(years*12))+ "\n");
			}
			}


			else if(commute == 1 && sS == 1 && eco == 1 && budget == 2 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Toyota Prius, which has an MSRP of 25,000");
			System.out.println("Your monthly payment will be: " + ((25000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Toyota Prius Sports model, which has an MSRP of 27,000");
			System.out.println("Your monthly payment will be: " + ((27000)/(years*12))+ "\n");
			}
			}


			else if(commute == 1 && sS == 1 && eco == 2 && budget == 1 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Mercedez Benz CLA, which has an MSRP of 39,000");
			System.out.println("Your monthly payment will be: " + ((39000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Mercedez Benz CLA Sports model, which has an MSRP of 44,000");
			System.out.println("Your monthly payment will be: " + ((44000)/(years*12))+ "\n");
			}
			}


			else if(commute == 1 && sS == 1 && eco == 2 && budget == 2 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Toyota Camry, which has an MSRP of 25,000");
			System.out.println("Your monthly payment will be: " + ((25000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Toyota Camry Sports model, which has an MSRP of 28,000");
			System.out.println("Your monthly payment will be: " + ((28000)/(years*12))+ "\n");
			}
			}


			else if(commute == 1 && sS == 2 && eco == 1 && budget == 1 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Toyota High-Lander, which has an MSRP of 39,000");
			System.out.println("Your monthly payment will be: " + ((39000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Toyota High-Lander Sports model, which has an MSRP of 44,000");
			System.out.println("Your monthly payment will be: " + ((44000)/(years*12))+ "\n");
			}
			}

			
			else if(commute == 1 && sS == 2 && eco == 1 && budget == 2 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Ford Eco-Sport SUV, which has an MSRP of 28,000");
			System.out.println("Your monthly payment will be: " + ((28000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Ford Eco-Sport Sports model, which has an MSRP of 32,000");
			System.out.println("Your monthly payment will be: " + ((32000)/(years*12))+ "\n");
			}
			}


			else if(commute == 1 && sS == 2 && eco == 2 && budget == 1 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Acura RDX, which has an MSRP of 33,000");
			System.out.println("Your monthly payment will be: " + ((33000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Acura RDX Sports model, which has an MSRP of 37,000");
			System.out.println("Your monthly payment will be: " + ((37000)/(years*12))+ "\n");
			}
			}


			else if(commute == 1 && sS == 2 && eco == 2 && budget == 2 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Honda-CRV, which has an MSRP of 23,000");
			System.out.println("Your monthly payment will be: " + ((23000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Honda-CRV Sports model, which has an MSRP of 25,000");
			System.out.println("Your monthly payment will be: " + ((25000)/(years*12))+ "\n");
			}
			}



			//the recomendations!, commute = no
			else if(commute == 2 && sS == 1 && eco == 1 && budget == 1 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No:");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Audi A4, which has an MSRP of 35,000");
			System.out.println("Your monthly payment will be: " + ((35000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Audi A4 Sports model, which has an MSRP of 37,000");
			System.out.println("Your monthly payment will be: " + ((37000)/(years*12))+ "\n");
			}
			}


			else if(commute == 2 && sS == 1 && eco == 1 && budget == 2 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Toyota Camry, which has an MSRP of 25,000");
			System.out.println("Your monthly payment will be: " + ((25000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Toyota Camry Sports model, which has an MSRP of 28,000");
			System.out.println("Your monthly payment will be: " + ((28000)/(years*12))+ "\n");
			}
			}


			else if(commute == 2 && sS == 1 && eco == 2 && budget == 1 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Acura TLX, which has an MSRP of 32,000");
			System.out.println("Your monthly payment will be: " + ((32000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Acura TLX Sports model, which has an MSRP of 34,000");
			System.out.println("Your monthly payment will be: " + ((34000)/(years*12))+ "\n");
			}
			}


			else if(commute == 2 && sS == 1 && eco == 2 && budget == 2 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Ford Fusion, which has an MSRP of 25,000");
			System.out.println("Your monthly payment will be: " + ((25000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Ford Fusion Sports model, which has an MSRP of 28,000");
			System.out.println("Your monthly payment will be: " + ((28000)/(years*12))+ "\n");
			}
			}


			else if(commute == 2 && sS == 2 && eco == 1 && budget == 1 ) {
			System.out.print("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Lexus NX, which has an MSRP of 35,000");
			System.out.println("Your monthly payment will be: " + ((35000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Lexus NX Sports model, which has an MSRP of 38,000");
			System.out.println("Your monthly payment will be: " + ((38000)/(years*12))+ "\n");
			}
			}

			
			else if(commute == 2 && sS == 2 && eco == 1 && budget == 2 ) {
			System.out.println("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Toyota RAV4, which has an MSRP of 25,000");
			System.out.println("Your monthly payment will be: " + ((25000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Toyota RAV4 Sports model, which has an MSRP of 28,000");
			System.out.println("Your monthly payment will be: " + ((28000)/(years*12))+ "\n");
			}
			}


			else if(commute == 2 && sS == 2 && eco == 2 && budget == 1 ) {
			System.out.println("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Toyota High-Lander, which has an MSRP of 31,000");
			System.out.println("Your monthly payment will be: " + ((31000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Toyota High-Lander Sports model, which has an MSRP of 35,000");
			System.out.println("Your monthly payment will be: " + ((35000)/(years*12))+ "\n");
			}
			}


			else if(commute == 2 && sS == 2 && eco == 2 && budget == 2 ) {
			System.out.println("Would you like to upgrade to sport model?\nEnter 1 for Yes or 2 for No: ");
			sport = input.nextInt();
			System.out.print("How many years of lease would you like: ");
			years = input.nextInt();
			if (sport == 2) {
			System.out.println("\nWe recommend that you get Kia Niro, which has an MSRP of 23,000");
			System.out.println("Your monthly payment will be: " + ((23000)/(years*12))+ "\n");
			}
			else if (sport == 1) {
			System.out.println("\nWe recommend that you get Kia Niro Sports model, which has an MSRP of 25,000");
			System.out.println("Your monthly payment will be: " + ((25000)/(years*12))+ "\n");
			}
			}
			else {
				System.out.println("You chose options that are not valid. Please try again.\n");
			}

			
		}
		else if (proChoice == 3) {
			loop_product = false;
			return true;
		}
		else if (proChoice == 4) {
			loop_product = false;
			return false;
		}
		else {
			System.out.println("Something has gone wrong, please try again.\n");
			return true;
		}
		}
		return true;
	}
	
	
	
	public static boolean Services() {
		System.out.println("\nHere at Loyola we know how to keep your car running like new. Please tell us what it is that your car requires.");
		Scanner input = new Scanner(System.in);
		boolean loop_services = true;
		String[] services = new String[] {"Car Wash","Tuning","Oil Change","Go back","Exit"};
		while (loop_services) {
			for (int i=0; i < services.length;i++) {
				System.out.println((i+1)+")"+services[i]);
			}
		System.out.print("Please choose an option: ");
		int proChoice = input.nextInt();
		if (proChoice > services.length || proChoice < 0) {
			System.out.println("Please enter an appropriate option\n");
		}
		
		else if (proChoice == 1) {
			System.out.println("\nWe offer a variety of car washes. The type of car wash and their prices are listed below" );
			System.out.println("Full Service(Exterior & Interior): $37");
			System.out.println("Exterior:                          $20");
			System.out.println("Interior:                          $20");
			System.out.println("");
		}
		
		else if (proChoice == 2) {
			String[] tuneUp = new String[] {"Replace Start Plugs","Check timing belt","Check fuel injectors","Check fluids","Check Battery","Check belts & hoses","Install new filter"};
			System.out.println("\nYour car, Our responsibility");
			System.out.println("Full cost tune-up costs: $100");
			System.out.println("The tune-up includes:");
			for (int i=0; i < tuneUp.length;i++) {
				System.out.println((i+1)+")"+tuneUp[i]);
			}
			System.out.println("");;

		}
		
		else if (proChoice == 3) {
			System.out.println("\nWe use the best oil & filter for your car. The type of oil and prices are listed below.");
			System.out.println("Regular oil with filter:      $40");
			System.out.println("Synthetic oil with filter:    $70\n");
		}
		
		
		else if (proChoice == 4) {
			loop_services = false;
			return true;
		}
		else if (proChoice == 5) {
			loop_services = false;
			return false;
		}
		else {
			System.out.println("Something has gone wrong, please try again.\n");
			return true;
		}
		}
		return true;
		
		
	}
	

	
	public static boolean Tools() {
		System.out.println("\nWe offer a couple of different varieties of tools to help you be a self helper. Please choose from a option below");
		Scanner input = new Scanner(System.in);
		boolean loop_tools = true;
		String[] tools = new String[] {"Workpro 29-piece Homeowners Tool Sets with Roll bag","Cartman 136-piece Tool Set","Professional 301 piece Mechanics Tool Kit","Go back","Exit"};
		while (loop_tools) {
			for (int i=0; i < tools.length;i++) {
				System.out.println((i+1)+")"+tools[i]);
			}
		System.out.print("Please choose a tool to get description and price: ");
		int proChoice = input.nextInt();
		if (proChoice > tools.length || proChoice < 0) {
			System.out.println("Please enter an appropriate option\n");
				}
		
		else if (proChoice == 1) {
			System.out.println("\nIdeal for people looking for a great start up kit for the home, office or car\n" + 
					"600D Polyester Faric rolling bag with 11 pockets for holding different tools\n" + 
					"Makes tasks around the house easy and simple.\n" + 
					"Include: Aluminum utility knife, 7\" long nose pliers, Magnetic screwdriver holder, Claw hammer, 9\" torpedo spirit level, 8\" adjustable wrench, Carrying bag\n" + 
					"20 screwdriver bits of 1-inch, 3 Combination wrenches: 9/16\", 5/8\", 11/16\"");
			System.out.println("The price for this is: $24.99\n");
		}
		
		
		else if (proChoice == 2) {
			System.out.println("\nUnisex 136-Piece Hand Tools Kit - Ideal for home and garage repairs\n" + 
					"Heat treated and chrome plated to resist corrosion\n" + 
					"Securely housed in a handy blow molded case\n" + 
					"All tools meet or exceed ANSI critical standards\n" + 
					"Contains the tools needed for most small repairs around the house");
			System.out.println("The price for this is: $19.99\n");
		}
		
		else if (proChoice == 3) {
			System.out.println("\nSAE, metric, square, star, and spark plug sockets\n" + 
					"Includes ratchets, breaker bars, extensions and universal joint adapters\n" + 
					"Combo, adjustable wrenches and pliers\n" + 
					"Rugged chrome vanadium construction\n" + 
					"16 pc. short arm hex key set SAE/Metric; 26 pc. long arm hex key SAE/Metric; 16 pc. screwdriver set");
			System.out.println("The price for this is: $219.44\n");
		}
		
		else if (proChoice == 4) {
			loop_tools = false;
			return true;
		}
		else if (proChoice == 5) {
			loop_tools = false;
			return false;
		}
		else {
			System.out.println("Something has gone wrong, please try again.\n");
			return true;
		}
	}
		return true;
	}
	
		
		
	public static boolean Support() {
		System.out.println("\nWe offer support for other dealerships & customers!");
		Scanner input = new Scanner(System.in);
		boolean loop_support = true;
		String[] support = new String[] {"Delarship","Customers","Go back","Exit"};
		while (loop_support) {
			for (int i=0; i < support.length;i++) {
				System.out.println((i+1)+")"+support[i]);
			}
		System.out.print("Please choose your appropriate title: ");
		int proChoice = input.nextInt();
		if (proChoice > support.length || proChoice < 0) {
			System.out.println("Please enter an appropriate option\n");
		}
		else if (proChoice == 1) {
			System.out.println("\nWe have a 24/7 customer support line just for our dealers.\n"
					+ "The number is: 1800-999-9922\n");
		}
		
		else if (proChoice == 2) {
			System.out.println("\nWe have a support line for our customers. It includes all emergency services\n"
					+ "The number is: 1800-999-0000\n");
		}
		else if (proChoice == 3) {
			loop_support = false;
			return true;
		}
		else if (proChoice == 4) {
			loop_support = false;
			return false;
		}
		else {
			System.out.println("Something has gone wrong, please try again.\n");
			return true;
		}
		
		}
		return true;
	}
	

	
	public static boolean Contacts() {
		System.out.println("\nYou have any questions or concerns? We are here to listen! Choose the list of people to contact.");
		Scanner input = new Scanner(System.in);
		boolean loop_contacts = true;
		String[] contacts = new String[] {"CEO","General Manager","Employees","Go back","Exit"};
		while (loop_contacts) {
			for (int i=0; i < contacts.length;i++) {
				System.out.println((i+1)+")"+contacts[i]);
			}
		System.out.print("Please choose the appropriate title: ");
		int proChoice = input.nextInt();
		if (proChoice > contacts.length || proChoice < 0) {
			System.out.println("Please enter an appropriate option\n");
		}
		
		else if (proChoice == 1) {
			System.out.println("\nAlthough our CEO is very busy, he would love to hear your thoughts.\n"
					+ "Please send him an email at: loyola_ceo@loyolacarshop.com\n");
		}
		
		else if (proChoice == 2) {
			System.out.println("\nIf you have any concerns involving your visit at Loyola Car Shop, please contact our GM directly");
			System.out.println("Please send him an email at: loyola_gm@loyolacarshop.com");
			System.out.println("You can also call him at: 410-334-3333\n");
		}
		
		else if (proChoice == 3) {
			System.out.println("\nDo you want to get in touch with our sales employees with any questions? Well, here they are.");
			System.out.println("Bob Dylan (Shift Manager)");
			System.out.println("Email: boby@loyolacarshop.com         Ph: 443-991-3432");
			System.out.println("Lisa Rock (Shift Manager)");
			System.out.println("Email: lisa@loyolacarshop.com         Ph: 443-991-3433");
			System.out.println("Bryan Coolio (Sales)");
			System.out.println("Email: bryany@loyolacarshop.com       Ph: 443-991-3434");
			System.out.println("Jim Halpert (Sales)");
			System.out.println("Email: jimmy@loyolacarshop.com        Ph: 443-991-3435");
			System.out.println("Bob Vance (Sales)");
			System.out.println("Email: bob@loyolacarshop.com          Ph: 443-991-3436");
			System.out.println("Dwight Schrute (Sales)");
			System.out.println("Email: dwight@loyolacarshop.com       Ph: 443-991-3437\n");
		}
		
		else if (proChoice == 4) {
			loop_contacts = false;
			return true;
		}
		else if (proChoice == 5) {
			loop_contacts = false;
			return false;
		}
		else {
			System.out.println("Something has gone wrong, please try again.\n");
			return true;
		}
		
	}
	
		return true;

	}
	
	
	public static boolean Inventory() {
		System.out.println("\nThis option is for employees only. If you are not an employee please exit.");
		boolean password = true;
		Scanner input = new Scanner(System.in);
		while (password) {
			System.out.print("\nPlease enter the password or type exit to go back: ");
			String rightPass = input.nextLine();
			if (rightPass.equals("kforkutti")) {
				password=false;
				boolean exitLoop = GetStuff();
				return exitLoop;
			}
			else if (rightPass.toLowerCase().equals("exit")) {
				password=false;
				return true;
			}
			else {
				System.out.println("The password was incorrect or you spelled exit incorrectly.");
				password = true;
			}
		}
		
		return true;
	}
	
	
	public static boolean GetStuff() {
		ArrayList<Items> inventory = new ArrayList<Items>();
		Items item1 = new Items("Mpow Car Phone Mount", 9.99,10,1,1,123456789);
		inventory.add(item1);
		Items item2 = new Items("Hands Free Car Bluetooth", 17.99,15,2,2,193847263);
		inventory.add(item2);
		Items item3 = new Items("4pc Floor Mats", 29.99,5,1,3,928361723);
		inventory.add(item3);
		Items item4 = new Items("Car Full Cover", 19.99,2,2,2,938273645);
		inventory.add(item4);
		Items item5 = new Items("FM transmitter", 39.99,8,1,2,848473629);
		inventory.add(item5);


		Scanner input = new Scanner(System.in);
		boolean loop_stuff = true;
		String[] stuff = new String[] {"List Inventory","Modify","Add","Remove","Go Back","Exit"};
		while (loop_stuff) {
			System.out.println("\nLet's manage the inventory!");
			for (int i=0; i < stuff.length;i++) {
				System.out.println((i+1)+")"+stuff[i]);
			}
			System.out.print("Please choose the appropriate option: ");
			int proChoice = input.nextInt();
			if (proChoice > stuff.length || proChoice < 0) {
				System.out.println("Please enter an appropriate option\n");
			}
			
			else if (proChoice == 1) {
				displayStuff(inventory);
			}
			
			else if (proChoice == 2) {
				changeStuff(inventory);
			}
			else if (proChoice == 3) {
				addStuff(inventory);
			}
			else if (proChoice == 4) {
				deleteStuff(inventory);
			}
			else if (proChoice == 5) {
				loop_stuff = false;
				return true;
			}
			else if (proChoice == 6) {
				loop_stuff = false;
				return false;
			}
	}
		return true;
	}
	
	
	
	
	public static void deleteStuff(ArrayList<Items> inventory) {

		Scanner input = new Scanner(System.in);
		boolean loop_del = true;
		while (loop_del) {
			System.out.println("\nHere is the list of available inventory to delete");
			for (int i=0; i < inventory.size();i++) {
				System.out.println((i+1)+")"+inventory.get(i).getName());
			}
			System.out.println((inventory.size()+1)+")"+"Go Back");
			System.out.print("Please choose the appropriate inventory: ");
			int proChoice = input.nextInt();
			if (proChoice > (inventory.size()+1) || proChoice < 0) {
				System.out.println("Please enter an appropriate option\n");
			}
			else if (proChoice == (inventory.size()+1)) {
				System.out.println();
				loop_del = false;
			}
			else {

				System.out.println("Item, "+inventory.get((proChoice-1)).getName()+ ", has been deleted!\n");
				inventory.remove((proChoice-1));
				loop_del = false;
			}
		}
	}
	
	
	
	public static void addStuff(ArrayList<Items> inventory) {
		System.out.println("\nLet's add more thing to your inventory!");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name of your item: ");
		String name = input.nextLine();
		System.out.print("Enter the price of your item: ");
		double price = input.nextDouble();
		System.out.print("How many do you have: ");
		int have = input.nextInt();
		int color = 0,aval=0;
		boolean colorLoop = true;
		while (colorLoop) {
			System.out.print("Enter the color of your item 1 for Black and 2 for White: ");
			color = input.nextInt();

			if (color == 1 ) {
				colorLoop = false;
			}
			else if (color == 2) {
				colorLoop = false;
			}
			else {
				colorLoop = true;
				System.out.println("You entered the wrong number. Please either enter 1 or 2.");
				
			}
		}
		
		boolean avalLoop = true;

		while (avalLoop) {
			System.out.print("Enter the availability of your item. Enter 1 for instore, 2 for online, or 3 for both: ");
			aval = input.nextInt();
			if (aval == 1) {
				avalLoop = false;
			}
			else if (aval == 2) {
				avalLoop = false;
			}
			else if (aval == 3) {
				avalLoop = false;
			}
			else {
				System.out.println("You entered the wrong choice. Please try again");
				avalLoop = true;
			}
		}

		System.out.print("Enter the UPC of your item: ");
		int upc = input.nextInt();
		
		Items plus = new Items(name,price,have,color,aval,upc );
		inventory.add(plus);
	}
	

	
	public static void changeStuff(ArrayList<Items> inventory) {
		Scanner input = new Scanner(System.in);
		boolean loop_display = true;
		while (loop_display) {
			System.out.println("\nSelect the item that you would like to change.");
			for (int i=0; i < inventory.size();i++) {
				System.out.println((i+1)+")"+inventory.get(i).getName());
			}
			System.out.println((inventory.size()+1)+")"+"Go Back");
			System.out.print("Please choose the appropriate item: ");
			int proChoice = input.nextInt();
			if (proChoice > (inventory.size()+1) || proChoice < 0) {
				System.out.println("Please enter an appropriate option\n");
			}
			else if (proChoice == (inventory.size()+1)) {
				System.out.println();
				loop_display = false;

			}
			else {
				boolean attri = true;
				String[] info = new String[] {"Name","Price","Amount","Color","Availability","UPC","Go back"};
				while (attri) {
					System.out.println("\nSelect the attribute that you would like to change for "+ inventory.get((proChoice-1)).getName() +".");
					for (int i=0; i < info.length;i++) {
						System.out.println((i+1)+")"+info[i]);
					}
				System.out.print("Please choose the appropriate label: ");
				int proChoice2 = input.nextInt();
				if (proChoice2 > info.length || proChoice2 < 0) {
					System.out.println("Please enter an appropriate option\n");
				}
				else if (proChoice2 == info.length){
					attri=false;
				}
				else {
					if (proChoice2 == 1) {
						System.out.print("Please enter the new name: ");
						input.nextLine();
						String name = input.nextLine();
						System.out.println("The name for item, "+inventory.get((proChoice-1)).getName()+", has been changed to "+name+".");
						inventory.get((proChoice-1)).setName(name);
					}
					if (proChoice2 == 2) {
						System.out.print("Please enter the new price: ");
						double price = input.nextDouble();
						System.out.println("The price for item, "+inventory.get((proChoice-1)).getName()+", has been changed to "+price+" from "+inventory.get((proChoice-1)).getPrice());
						inventory.get((proChoice-1)).setPrice(price);
					}
					if (proChoice2 == 3) {
						System.out.print("Please enter the new amount you have avaliable: ");
						int avail = input.nextInt();
						System.out.println("The new number you have available for item, "+inventory.get((proChoice-1)).getName()+", has been changed to "+avail+" from "+inventory.get((proChoice-1)).getAmount());
						inventory.get((proChoice-1)).setAmount(avail);
					}
					if (proChoice2 == 4) {
						boolean colorLoop = true;
						while (colorLoop) {
							System.out.print("Please enter the new Color. Please note we only carry Black & White to match our dealership colors. Enter 1 for black and 2 for white: ");
							int color = input.nextInt();
							if (color == 1 ) {
								System.out.println("The color for item, "+inventory.get((proChoice-1)).getName()+", has been changed to Black from "+inventory.get((proChoice-1)).getColor());
								inventory.get((proChoice-1)).setColor(color);
								colorLoop = false;
							}
							else if (color == 2) {
								System.out.println("The color for item, "+inventory.get((proChoice-1)).getName()+", has been changed to White from "+inventory.get((proChoice-1)).getColor());
								inventory.get((proChoice-1)).setColor(color);
								colorLoop = false;
							}
							else {
								colorLoop = true;
								System.out.println("Please enter either 1 for Black or 2 for White");
							}
						}

					}
					if (proChoice2 == 5) {
						boolean avalLoop = true;
						while (avalLoop) {
							System.out.println("Availability can either be instore or online or both. Please enter 1 for instore, 2 for online, or 3 for both");
							System.out.print("Please enter the Availability:");
							int avail = input.nextInt();
							if (avail == 1) {
								avalLoop=false;
								System.out.println("The availability for item, "+inventory.get((proChoice-1)).getName()+", has been changed to Instore from "+inventory.get((proChoice-1)).getAval());
								inventory.get((proChoice-1)).setAval(1);
							}
							else if (avail == 2) {
								avalLoop=false;
								System.out.println("The availability for item, "+inventory.get((proChoice-1)).getName()+", has been changed to Online from "+inventory.get((proChoice-1)).getAval());
								inventory.get((proChoice-1)).setAval(2);
							}
							else if (avail == 3) {
								avalLoop=false;
								System.out.println("The availability for item, "+inventory.get(proChoice-1).getName()+", has been changed to Instore & Online from "+inventory.get((proChoice-1)).getAval());
								inventory.get((proChoice-1)).setAval(3);
							}
							else {
								System.out.println("You have entered the wrong choice. Please either choose 1, 2, or 3");
								avalLoop=true;
								
							}
							
						}

					}
					if (proChoice2 == 6) {
						System.out.print("Please enter the new UPC: ");
						int upc = input.nextInt();
						System.out.println("The UPC for item, "+inventory.get((proChoice-1)).getName()+", has been changed to "+upc+" from "+inventory.get((proChoice-1)).getUpc());
						inventory.get((proChoice-1)).setUpc(upc);
					}
					if (proChoice2 == 7) {
						attri=false;
					}
				}
				}
				
			}
	}
	}
	

	
	public static void displayStuff(ArrayList<Items> inventory) {
		Scanner input = new Scanner(System.in);
		boolean loop_display = true;
		while (loop_display) {
			System.out.println("\nHere is the list of available inventory. Choose one to display more info.");
			for (int i=0; i < inventory.size();i++) {
				System.out.println((i+1)+")"+inventory.get(i).getName());
			}
			System.out.println((inventory.size()+1)+")"+"Go Back");
			System.out.print("Please choose the appropriate inventory: ");
			int proChoice = input.nextInt();
			if (proChoice > (inventory.size()+1) || proChoice < 0) {
				System.out.println("Please enter an appropriate option\n");
			}
			else if (proChoice == (inventory.size()+1)) {
				System.out.println();
				loop_display = false;

			}
			else {
				System.out.println("\nName: "+inventory.get(proChoice-1).getName());
				System.out.println("Price: "+inventory.get(proChoice-1).getPrice());
				System.out.println("Amount: "+inventory.get(proChoice-1).getAmount());
				System.out.println("Color: "+inventory.get(proChoice-1).getColor());
				System.out.println("Availability: "+inventory.get(proChoice-1).getAval());
				System.out.println("UPC: "+inventory.get(proChoice-1).getUpc() + "\n");
			}
	}

	}
}
