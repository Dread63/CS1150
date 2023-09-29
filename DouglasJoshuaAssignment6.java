import java.util.Scanner;

public class DouglasJoshuaAssignment6 {

	public static void main(String[] args) {
		// 
		
		int numberOfWins = 0;
		int numberOfLosses = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter initial deposit");
		double initialDeposit = input.nextDouble();
		
		while (initialDeposit != (int)initialDeposit || initialDeposit <=0) {
			System.out.println("ERROR: Slot machine only accepts positive values and even dollar bill amounts, please enter a positive deposit at an even dollar amount");
			initialDeposit = input.nextDouble();
		}
		
		System.out.println("--------------------------------------");
		System.out.println("SEVEN           SEVEN            SEVEN");
		System.out.println("--------------------------------------");
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("|Credits " + initialDeposit + "   Won " + numberOfWins + "   Lost " + numberOfLosses);
		System.out.println("");
		System.out.println("How many credits would you like to bet?");
		
		
		int creditsGambled = input.nextInt();
			
		while (creditsGambled < 1 || creditsGambled > initialDeposit) {
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
			
		while (creditsGambled >=1 && creditsGambled <= initialDeposit && chosenMenuOption.equals("Y")) {
			
			while ((initialDeposit - creditsGambled) < 0  && chosenMenuOption.equals("Y")) {
				System.out.println("Insufficient Credits, try again");
				creditsGambled = input.nextInt();
			}
			
			for (creditsGambled; (creditsGambled <= initialDeposit && creditsGambled >=1 && chosenMenuOption.equals("Y"); initialDeposit = initialDeposit - creditsGambled; {
				System.out.println("Slot Machine runs");
				System.out.println("You have " + initialDeposit + " credits left, how many do you want to bet?");
				creditsGambled = input.nextInt();
				System.out.println("Spin (Y/N)?");
				chosenMenuOption = input.next();
			}
			
			
		/*
			initialDeposit = initialDeposit - creditsGambled;
			if (initialDeposit > 0) {
					
			System.out.println("You have " + initialDeposit + " credits left, how many do you want to bet?");
			creditsGambled = input.nextInt();
			System.out.println("Spin (Y/N)?");
			chosenMenuOption = input.next();
			}
			*/
		}
		
		System.out.println("No credits left");
		

	}

}
