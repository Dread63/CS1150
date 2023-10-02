/*
* Name: Joshua Douglas
* Class: CS1150 - 002
* Assignment #6
* Due Date: Oct 4, 2023
* Description: This program simulates a slot machine. It begins by prompting the user for their desired amount
* of dollars to deposit. Then it utilizes a while loop and nested for loops to simulate the spins of a slot
* machine. Three matching words rewards 3 credits, two matching words rewards 2 credits, and no matching words
* results in the loss of a credit. One credit is equivalent to one dollar, and the user has the option to end 
* the simulation and collect their earnings after every spin. Finally, it will display their winnings, losses,
* and the amount they have left to withdraw.
*/

import java.util.Scanner;

public class DouglasJoshuaAssignment6 {

	public static void main(String[] args) { 
		
		// Initializing variables to be used later
		int numberOfCreditsWon = 0;
		int numberOfCreditsLost = 0;
		
		// Initializing scanner to collect user input
		Scanner input = new Scanner(System.in);
		
		// Prompting and collection user input
		System.out.println("Enter initial deposit");
		double initialDeposit = input.nextDouble();
		
		// Verifying that the inputed currency was in whole dollars only
		while (initialDeposit != (int)initialDeposit || initialDeposit <=0) {
			System.out.println("ERROR: Slot machine only accepts positive values and even dollar bill amounts,"
					+ " please enter a positive deposit at an even dollar amount");
			initialDeposit = input.nextDouble();
		}
		
		// This variable will be used to track credits without changing the initial deposit amount
		double remainingCredits = initialDeposit;
		
		// Displaying the slot machine to the user and collectin their desired bet
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
			String selectedTempWord = "";
			String selectedWord1 = "";
			String selectedWord2 = "";
			String selectedWord3 = "";
			
			// For loop which will simulate a spin for each credit entered
			for (int numberOfSpins = 1; numberOfSpins <= creditsGambled; numberOfSpins++) {
				
				// Nested for loop which ensures that three unique words are generated
				for (int i = 0; i < 3; i++) {
				
					int randomNumber = 1 + (int)(Math.random() * 5); // Generates random number 1-5 which will
																	// be tied to a slot image (word)
					switch (randomNumber) {
				
						// The following if statements ensure that the final selected words won't be
						// overwritten on following iterations of the for statement on line 84
						case 1:
							selectedTempWord = "Seven";
							if (i == 0) {
								selectedWord1 = selectedTempWord;
							}
							if (i == 1) {
								selectedWord2 = selectedTempWord;
							}
							if (i == 2) {
								selectedWord3 = selectedTempWord;
							}
							break;
						case 2:
							selectedTempWord = "Cherry";
							if (i == 0) {
								selectedWord1 = selectedTempWord;
							}
							if (i == 1) {
								selectedWord2 = selectedTempWord;
							}
							if (i == 2) {
								selectedWord3 = selectedTempWord;
							}
							break;
						case 3:
							selectedTempWord = "Bell";
							if (i == 0) {
								selectedWord1 = selectedTempWord;
							}
							if (i == 1) {
								selectedWord2 = selectedTempWord;
							}
							if (i == 2) {
								selectedWord3 = selectedTempWord;
							}
							break;
						case 4:
							selectedTempWord = "Bar";
							if (i == 0) {
								selectedWord1 = selectedTempWord;
							}
							if (i == 1) {
								selectedWord2 = selectedTempWord;
							}
							if (i == 2) {
								selectedWord3 = selectedTempWord;
							}
							break;
						case 5:
							selectedTempWord = "Plum";
							if (i == 0) {
								selectedWord1 = selectedTempWord;
							}
							if (i == 1) {
								selectedWord2 = selectedTempWord;
							}
							if (i == 2) {
								selectedWord3 = selectedTempWord;
							}
							break;
							
						// Error handling for the low possibility of unexpected data types	
						default:
							System.out.println("ERROR: Unknown random data type, please restart!");
					}
				
				}
				
				// Statement to check if all three slot images (words) match and to update respective variables
				if (selectedWord1.equals(selectedWord2) && selectedWord2.equals(selectedWord3)) {
					numberOfCreditsWon += 3;
					remainingCredits += 3;
				}
				
				// Statement to check if only two slot images (words) match and to update respective variables
				if ((selectedWord1.equals(selectedWord2) && !selectedWord1.equals(selectedWord3)) || 
					(selectedWord1.equals(selectedWord3) && !selectedWord1.equals(selectedWord2)) ||
					(selectedWord2.equals(selectedWord3) && !selectedWord2.equals(selectedWord1))) {
					
					numberOfCreditsWon += 2;
					remainingCredits += 2;		
				}
				
				// Statement to check if no slot images (words) math and update respective varaibles
				if (!selectedWord1.equals(selectedWord2) && !selectedWord2.equals(selectedWord3) &&
					!selectedWord1.equals(selectedWord3)) {
					
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
				
		}
		
		// Displaying the final results of the users gambling experience
		System.out.println("Game Over!");
		System.out.printf("Started With $ %.0f%n", initialDeposit);
		System.out.println("Winnings     $ " + numberOfCreditsWon);
		System.out.println("Lost         $ " + numberOfCreditsLost);
		System.out.printf("Dispensing   $ %.0f%n", (initialDeposit + numberOfCreditsWon - numberOfCreditsLost));
		
	}
}
