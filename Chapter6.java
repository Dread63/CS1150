import java.util.Scanner;
public class Chapter6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number");
		int number = input.nextInt();
		
		int total = sum(number);
		
		System.out.println("Sum of numbers from 1 to  " + number + "equals = " + total);
		}
	
	public static int sum(int n) {
		
		int result = 0;
		int counter =1;
		while (counter <= n) {
			result = result + counter;
			counter ++;
		}
		return result;
	}
	*/
		
		// Initializing variables to be used later
				int numberOfCreditsWon = 0;
				int numberOfCreditsLost = 0;
				final int NUMBER_OF_IMAGES = 3;
				
				// Initializing scanner to collect user input
				Scanner input = new Scanner(System.in);
				
				// Prompting and collection user input
				System.out.println("Starting slot machine simulation....");
				System.out.println("Enter initial deposit to start slot machine simulation");
				double initialDeposit = input.nextDouble();
				
				// Verifying that the inputed currency was in whole dollars only
				while (initialDeposit != (int)initialDeposit || initialDeposit <=0) {
					System.out.println("ERROR: Slot machine only accepts positive values and even dollar bill amounts,"
							+ " please enter a positive deposit at an even dollar amount");
					initialDeposit = input.nextDouble();
				}
				
				// This variable will be used to track credits without changing the initial deposit amount
				double remainingCredits = initialDeposit;
				
				// Displaying the slot machine to the user and collecting their desired bet
				System.out.println("-----------------------------------------");
				System.out.println("SEVEN            SEVEN              SEVEN");
				System.out.println("-----------------------------------------");
				System.out.println("         **** READY TO SPIN ****         ");
				System.out.println("-----------------------------------------");
				System.out.printf("|Credits %.0f |Credits Won %d |Lost Spins %d%n", initialDeposit, numberOfCreditsWon, numberOfCreditsLost);
				System.out.println("");
				System.out.println("How many credits would you like to bet?");
				
				int creditsGambled = input.nextInt();
				
				// Error handling in case the user bets a negative amount of credits or more than they have
				while (creditsGambled < 1 || creditsGambled > remainingCredits) {
					if (creditsGambled < 1) {
						System.out.println("ERROR: Cannot bet a negative amount of credits, please enter a valid "
								+ "amount of credits");
						creditsGambled = input.nextInt();	
					}
					else {
						System.out.println("ERROR: Cannot bet more credits than you have, please enter a valid "
								+ "amount of credits");
						creditsGambled = input.nextInt();
					}
				}
				
				// Confirming the user wants to gamble the inputed number of credits
				System.out.println("Ready to spin? Type Y for yes or N to cancel");
				String chosenMenuOption = input.next();
				
				// Main while loop that runs as long as the user inputs the proper amount of credits and desires to spin
				while ((creditsGambled >= 1 && creditsGambled <= remainingCredits && chosenMenuOption.equals("Y"))) {
					
					// Initializing variables that will temporarily hold the random slot machine "images" (words)
					String selectedWord1 = "";
					String selectedWord2 = "";
					String selectedWord3 = "";
					
					// For loop which will simulate a spin for each credit entered
					for (int numberOfSpins = 1; numberOfSpins <= creditsGambled; numberOfSpins++) {
						
						// Nested for loop which ensures that three unique words are generated
						selectedWord1 = slotImage();
						selectedWord2 = slotImage();
						selectedWord3 = slotImage();
						
						}
						
						// Statement to check if all three slot images (words) match and to update respective variables
						if (selectedWord1.equals(selectedWord2) && selectedWord2.equals(selectedWord3)) {
							numberOfCreditsWon += 3;
							remainingCredits += 3;
						}
						
						// Statement to check if only two slot images (words) match and to update respective variables
						else if (selectedWord1.equals(selectedWord2) || selectedWord1.equals(selectedWord3) ||
							selectedWord2.equals(selectedWord3)) {
							
							numberOfCreditsWon += 2;
							remainingCredits += 2;		
						}
						
						// Statement to check if no slot images (words) math and update respective varaibles
						else {
							
							numberOfCreditsWon += 0;
							remainingCredits -= 1;
							numberOfCreditsLost += 1;
						}
						
						// Displaying slot machine results for the user
						System.out.println("-----------------------------------------");
						System.out.println("      " + selectedWord1 + "        " + selectedWord2 +"        " + selectedWord3);
						System.out.println("-----------------------------------------");
						System.out.println("     **** YOU WON " + numberOfCreditsWon + " CREDITS! ****");
						System.out.println("-----------------------------------------");
						System.out.println("|Credits " + remainingCredits + " |Won Credits " + numberOfCreditsWon + " |Lost Spins " + numberOfCreditsLost);
						System.out.println("");
					}
				
					// As long as the user hasn't run out of credits, prompt for a re-spin
					if (remainingCredits > 0) {
						
						System.out.printf("You have %.0f credits left, would you like to spin again (Y/N)?%n", remainingCredits);
						chosenMenuOption = input.next();
					}
					
					// If the user chooses to spin again, prompt for the desired amount of credits
					if (chosenMenuOption.equals("Y")) {
						
						System.out.println("How many credits would you like to bet?");
						creditsGambled = input.nextInt();
					}
					
					// If statement to handle errors when user inputs an invalid amount of credits
					if (remainingCredits != 0) {
						
						while (creditsGambled > remainingCredits) {
							System.out.println("You don't have that many credits, try again");
							creditsGambled = input.nextInt();
						}
					
						while (creditsGambled < 0) {
							System.out.println("Cannot bet a negative number of credits, try again");
							creditsGambled = input.nextInt();
						}
						
					}
					
					// Displaying the final results of the users gambling experience
					System.out.println("Game Over!");
					System.out.printf("Started With $ %.0f%n", initialDeposit);
					System.out.println("Winnings     $ " + numberOfCreditsWon);
					System.out.println("Lost         $ " + numberOfCreditsLost);
					System.out.printf("Dispensing   $ %.0f%n", (initialDeposit + numberOfCreditsWon - numberOfCreditsLost));
					
				}
				
	
	public static String slotImage() {
		
		int randomNumber = 1 + (int)(Math.random() * 5);
		String chosenSlotImage = "";
		
		switch (randomNumber) {
			
		case 1:
			chosenSlotImage = "Seven";
			break;
		case 2:
			chosenSlotImage = "Cherry";
			break;
		case 3:
			chosenSlotImage = "Bell";
			break;
		case 4:
			chosenSlotImage = "Bar";
			break;
		case 5:
			chosenSlotImage = "Plum";
			break;
		}
		
		return chosenSlotImage;
	}
}

