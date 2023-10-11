/*
* Name: Joshua Douglas
* Class: CS1150 - 002
* Assignment #7
* Due Date: Oct 11, 2023
* Description: This program calculates a user's BMR by utilizing their specified gender, weight, height, and age. Then, it will use
* the collected data to calculate the total number of calories the user needs based off of five different levels of activity. After
* using methods to store and calculate data, it will print the result in an easy to understand and nicely formatted table.
*/
import java.util.Scanner;
public class DouglasJoshuaAssignment7 {
	public static void main(String[] args) {

		// Variable to exit the program if the user selects N when propmpted to run again
		boolean wantsToContinue = true;

		// Main loops of the program
		while (wantsToContinue) {
			
			Scanner input = new Scanner(System.in);
			
			// Collecting user input for gender, age, weight, and height
			char selectedGender = getGender(input);
			int selectedAge = getAge(input);
			int selectedHeight = getHeight(input);
			double selectedWeight = getWeight(input);
			
			// Calling on computeBMR to use our gathered input to compute the user specific BMR
			double calculatedBMR = computeBMR(selectedGender, selectedAge, selectedHeight, selectedWeight);

			// Calling on displayResults and handing it calculatedBMR
			displayResults(calculatedBMR);
			
			// Checking if the user wants to execute another iteration or exit the program
			wantsToContinue = continueProcessing(input);
		}
		
	}
	
	// Obtain gender from user and ensure input is valid
	public static char getGender(Scanner input) { 
		
		System.out.print("Select gender, type M for male and F for female: ");

		// In order to return a char, we collect the input as a string, then call on charAt
		// Converted to lowercase to ensure the user doesn't get an error if they type m instead of M
		String selectedGender = input.next();
		char gender = Character.toLowerCase(selectedGender.charAt(0));
		System.out.println("");
		
		// Simple error handling to ensure a valid gender is chosen
		while (gender != 'm' && gender != 'f') {
			System.out.print("Invalid gender choice please select M for male and F for female: ");
			selectedGender = input.next();
			gender = selectedGender.charAt(0);
			System.out.println("");
		}
		
		return gender;
	}
	
	// Obtain age from user and ensure input is valid
	public static int getAge(Scanner input) { 

		System.out.print("Please input your age in years (1-100): ");
		
		int age = input.nextInt();
		System.out.println("");
		
		// Simple error handling to ensure a valid age between 1 and 100 is chosen
		while (age <= 0 || age > 100) {
			System.out.print("Invalid age, please choose a whole number between 1 and 100: ");
			age = input.nextInt();
			System.out.println("");
		}

		return age;
	}
	
	// Obtain height from user and ensure input is valid
	public static int getHeight(Scanner input) {  
		
		System.out.println("Please enter your total height in feet and inches");

		// Declaring variables outside of do-while loop to ensure working scope
		int heightInFeet = 0;
		int heightInInches = 0;
		int totalHeightInInches = 0;
		
		// Prompts for feet and inches individually as to not confuse the user
		do {
			System.out.print("Feet:");
			heightInFeet = input.nextInt();
			
			System.out.print("Inches:");
			heightInInches = input.nextInt();
			System.out.println("");

			// Simple error handling in case a user enters inches larger than 12 (which would be a foot)						  
			while (heightInInches > 12 || heightInInches < 0) {
				System.out.println("Cannot input " + heightInInches +" inches, please input a value between 0 and 12");
				System.out.print("Inches:");
				heightInInches = input.nextInt();
				System.out.println("");
			}
			
			// Calculating the total height in inches to be used later in calculating BMR
			totalHeightInInches = heightInInches + (heightInFeet * 12);
			
			// Simple error handling to ensure that height is between 1' and 8'11"
			if (totalHeightInInches < 12 || totalHeightInInches > 107) {
				System.out.println(heightInFeet + " feet " + heightInInches + " inches is not a valid height, please re-enter");
			}
			
		} 
		// Condition to exit the loop once done (this condition is repeated from line 101 to ensure the user is informed of the error)
		while (totalHeightInInches < 12 || totalHeightInInches > 107);
		
		return totalHeightInInches;
	}

	// Obtain weight from user and ensure input is valid
	public static double getWeight(Scanner input) { 

		System.out.print("Please input your weight in pounds: ");
		
		// Initializing variable for scope
		double totalWeight = input.nextDouble();
		System.out.println("");
		
		// Simple error handling to ensure a positive weight is entered
		while (totalWeight <= 0) {
			System.out.println(totalWeight + " is not a valid weight, please re-enter a positive value");
			totalWeight = input.nextDouble();	
		}
		
		return totalWeight; 
	}

	// Prompts user to repeat the program or terminate
	public static boolean continueProcessing(Scanner input) { 
		
		// Intializing variables to ensure scope within the whole method
		boolean wantsToContinue;
		String selectedMenuOption = "";
		
		// Propmts the user to change wantsToContinue to false
		System.out.print("Would you like to perform another calorie calculation (Y/N): ");
		
		selectedMenuOption = input.next();
		char selectedMenuOptionIgnoreCase = Character.toLowerCase(selectedMenuOption.charAt(0)); // Change to lowercase to avoid errors
		System.out.println("");
		
		// Simple error handling to ensure their input is either yes or no
		while (selectedMenuOptionIgnoreCase != 'y' && selectedMenuOptionIgnoreCase != 'n') {
			System.out.println("Invalid menu selection, please choose Y or N");
			selectedMenuOption = input.next();
		}
		
		if (selectedMenuOptionIgnoreCase == 'y') { // The user wants to re-run the program
			wantsToContinue = true; 
		}
		else { // The user wants to exit the program
			wantsToContinue = false;
		}
		
		return wantsToContinue;
	}
	
	// Calculate's user's BMR using data collected in previous methods
	public static double computeBMR (char gender, double age, double height, double weight) {
		   																					 	
		// Initialize variable to ensure scope within entire method
		double bmr = 0;
		
		// Switch statment will chose which BMR formula to use based on selectedGender
		switch (gender) {
	
		case 'm': // Formula to calculate BMR for males
			bmr = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
			break;
			
		case 'f': // Formula to calculate BMR for females
			bmr = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
			break;
		}
		
		return bmr;
	}
	
	// Calculating the required amount of calories based on the user's BMR and possible activity level
	public static double computeCaloriesWithActivity(double bmr, int activityLevel) {
		
		// Initializing variable to ensure scope within entire method
		double requiredCalorieCount = 0;

		// Delcaring constants for activity levels to avoid "magic numbers"
		final double SEDENTARY = 1.2;
		final double LIGHTLY_ACTIVE = 1.375;
		final double MODERATELY_ACTIVE = 1.55;
		final double VERY_ACTIVE = 1.725;
		final double EXTRA_ACTIVE = 1.9;
		
		// Switch statement to calculate required calories based on different levels of activity
		switch (activityLevel) {
		
		case 1:
			requiredCalorieCount = (SEDENTARY * bmr);
			break;
		case 2:
			requiredCalorieCount = (LIGHTLY_ACTIVE * bmr);
			break;
		case 3: 
			requiredCalorieCount = (MODERATELY_ACTIVE * bmr);
			break;
		case 4:
			requiredCalorieCount = (VERY_ACTIVE * bmr);
			break;
		case 5:
			requiredCalorieCount = (EXTRA_ACTIVE * bmr);
			break;
		}
		
		return requiredCalorieCount;
	}
	
	// Display results of all calculations in a nicely formatted table for the user
	public static void displayResults(double bmr) {

		// Displaying final calculated results for BMR and calories based on activity
		System.out.println("            *********************************");
		System.out.printf("                  Your BMR is %.2f%n", bmr);
		System.out.println("            *********************************");

		System.out.println("---------------------------------------------------------");
		System.out.println("Activity Level                                 Calories  ");
		System.out.println("---------------------------------------------------------");
		
		// Prints the required amount of calories per activity level (1-5)
		for (int activityLevel = 1; activityLevel <= 5; activityLevel++) {

			double calories = computeCaloriesWithActivity(bmr, activityLevel);

			switch (activityLevel) {

				case 1:
					System.out.printf("Sedentary - little or no exercise             | %.2f%n", calories);
					break;
				case 2:
					System.out.printf("Lightly active - Exercise 1-3 times/week      | %.2f%n", calories);
					break;
				case 3:
					System.out.printf("Moderately active - Exercise 4-5 times/week   | %.2f%n", calories);
					break;
				case 4:
					System.out.printf("Very active - Intense exercise 6-7 times/week | %.2f%n", calories);
					break;
				case 5:
					System.out.printf("Extra active - Very intense work daily        | %.2f%n", calories);
					break;
			}
		} 

		System.out.println("---------------------------------------------------------");
		System.out.println("");
	}

}
