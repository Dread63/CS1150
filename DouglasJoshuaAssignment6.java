import java.util.Scanner;

public class DouglasJoshuaAssignment6 {

	public static void main(String[] args) {
		// 
		
		int numberOfCreditsWon = 0;
		int numberOfCreditsLost = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter initial deposit");
		double initialDeposit = input.nextDouble();
		
		while (initialDeposit != (int)initialDeposit || initialDeposit <=0) {
			System.out.println("ERROR: Slot machine only accepts positive values and even dollar bill amounts, please enter a positive deposit at an even dollar amount");
			initialDeposit = input.nextDouble();
		}
		
		double remainingCredits = initialDeposit;
		
		System.out.println("--------------------------------------");
		System.out.println("SEVEN           SEVEN            SEVEN");
		System.out.println("--------------------------------------");
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("|Credits " + initialDeposit + "   Won " + numberOfCreditsWon + "   Lost " + numberOfCreditsLost);
		System.out.println("");
		System.out.println("How many credits would you like to bet?");
		
		
		int creditsGambled = input.nextInt();
			
		while (creditsGambled < 1 || creditsGambled > remainingCredits) {
			if (creditsGambled < 1) {
				System.out.println("ERROR: Cannot bet a negative amount of credits, please enter a valid amount of credits");
				creditsGambled = input.nextInt();	
			}
			else {
				System.out.println("ERROR: Cannot bet more credits than you have, please enter a valid amount of credits");
				creditsGambled = input.nextInt();
			}
		}
		
		System.out.println("Ready to spin? Type Y for yes or N to cancel");
		String chosenMenuOption = input.next();
		
		for (; (creditsGambled >= 1 && creditsGambled <= remainingCredits && chosenMenuOption.equals("Y")); chosenMenuOption = input.next()) {
			
			String selectedTempWord = "";
			String selectedWord1 = "";
			String selectedWord2 = "";
			String selectedWord3 = "";
			
			
			for (int numberOfSpins = 1; numberOfSpins <= creditsGambled; numberOfSpins++) {
				
				for (int i = 0; i < 3; i++) {
				
					int randomNumber = 1 + (int)(Math.random() * 5);
				
					switch (randomNumber) {
				
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
						default:
							System.out.println("ERROR: Unknown random data type, please restart!");
							
					}
				
				}
				
				if (selectedWord1.equals(selectedWord2) && selectedWord2.equals(selectedWord3)) {
					numberOfCreditsWon = 3;
					remainingCredits += 3;
				}
				
				if ((selectedWord1.equals(selectedWord2) && !selectedWord1.equals(selectedWord3)) || 
					(selectedWord1.equals(selectedWord3) && !selectedWord1.equals(selectedWord2)) ||
					(selectedWord2.equals(selectedWord3) && !selectedWord2.equals(selectedWord1))) {
					
					numberOfCreditsWon = 2;
					remainingCredits += 2;		
				}
				
				if (!selectedWord1.equals(selectedWord2) && !selectedWord2.equals(selectedWord3) &&
					!selectedWord1.equals(selectedWord3)) {
					
					numberOfCreditsWon = 0;
					remainingCredits -= 1;
					numberOfCreditsLost += 1;
					
				}
					
				System.out.println("--------------------------------------");
				System.out.println(selectedWord1 + "      " + selectedWord2 +"      " + selectedWord3);
				System.out.println("--------------------------------------");
				System.out.println("");
				System.out.println("--------------------------------------");
				System.out.println("|Credits " + remainingCredits + "   Won " + numberOfCreditsWon + "   Lost " + numberOfCreditsLost);
				System.out.println("");
			}
		
			while ((remainingCredits - creditsGambled) < 0) {
				System.out.println("Insufficient Credits, try again");
				creditsGambled = input.nextInt();
			}
		
			if (remainingCredits > 0) {
				
				System.out.println("You have " + remainingCredits + " credits left, how many do you want to bet?");
				creditsGambled = input.nextInt();
			}
		
			System.out.println("Spin (Y/N)?");
			
		}
		
		System.out.println("No credits left");

	}
}
