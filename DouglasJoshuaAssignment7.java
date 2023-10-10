// ASSIGNMENT DESCRIPTION
import java.util.Scanner;
public class DouglasJoshuaAssignment7 {
	public static void main(String[] args) {
		// Variable to exit the program if the user selects N when propmpted to run again
		boolean wantsToContinue = true;
		
		// Entering main loop with the condition we made above
		while (wantsToContinue) {
			
			// Initializing scanner
			Scanner input = new Scanner(System.in);
			
			// Collecting user input for gender, age, weight, and height
			System.out.println("Select gender, type M for male and F for female");
			char selectedGender = getGender(input);
			
			System.out.println("Please input your age in years (1-100)");
			int selectedAge = getAge(input);
			
			System.out.println("Please input your weight in pounds");
			double selectedWeight = getWeight(input);
			
			System.out.println("Please enter your total height in feet and inches");
			int selectedHeight = getHeight(input);
			
			// Calling on computeBMR to use our gathered input to compute the user specific BMR
			double calculatedBMR = computeBMR(selectedGender, selectedAge, selectedHeight, selectedWeight);

			// Calling on displayResults and handing it the calculatedBMR
			displayResults(calculatedBMR);
			
			// Checking if the user wants to execute another iteration or exit the program
			wantsToContinue = continueProcessing(input);
		}
		
	}
	
	public static char getGender(Scanner input) {
		
		// In order to return a char, we collect the input as a string, then call on charAt
		String selectedGender = input.next();

		// Converted to lowercase to ensure the user doesn't get an error if they type m instead of M
		char gender = Character.toLowerCase(selectedGender.charAt(0));
		
		// Simple error handling to ensure a valid gender is chosen
		while (gender != 'm' && gender != 'f') {
			System.out.println("Invalid gender choice please select M for male and F for female");
			selectedGender = input.next();
			gender = selectedGender.charAt(0);
		}
		
		return gender; // Returning gender to selectedGender in the form of a Char
		
	}
	
	public static int getAge(Scanner input) {
		
		int age = input.nextInt(); // Collecting age in form of an Int
		
		// Simple error handling to ensure a valid age between 1 and 100 is chosen
		while (age <= 0 || age > 100) {
			System.out.println("Invalid age, please choose a whole number between 1 and 100");
			age = input.nextInt();
		}
		
		return age; // Returning age to selectedAge as an Int
	}
	
	public static int getHeight(Scanner input) {
		
		// Declaring variables outside of do-while loop to ensure working scope
		int heightInFeet = 0;
		int heightInInches = 0;
		int totalHeightInInches = 0;
		
		// Prompts for feet and inches individuall as to not confuse the user
		do {
			System.out.print("Feet:");
			heightInFeet = input.nextInt();
			
			System.out.print("Inches:");
			heightInInches = input.nextInt();
			System.out.println(""); // This alongside line 81 is used to allow input on the same line as the prompt
									  // but still move to the next line (purely for visual cleanliness)

			// Simple error handling in case a user enters inches larger than 12 (which would be a foot)						  
			while (heightInInches > 12) {
				System.out.println(heightInInches + " Is not a valid input, please input a value between 0 and 12");
				heightInInches = input.nextInt();
			}
			
			// Calculating the total height in inches to be used later in calculating BMR
			totalHeightInInches = heightInInches + (heightInFeet * 12);
			
			// Simple error handling to ensure that height is between 1' and 8'11"
			if (totalHeightInInches < 12 || totalHeightInInches > 107) {
				System.out.println(heightInFeet + " feet " + heightInInches + " inches is not a valid height, please re-enter");
			}
			
		} 
		// Condition to exit the loop once done (this condition is repeated from line 96 to ensure the user is informed of the error)
		while (totalHeightInInches < 12 || totalHeightInInches > 107);
		
		return totalHeightInInches; // Returns totalHeightInInches to selectedHeight in form of an Int
	}
	
	public static double getWeight(Scanner input) {
		
		// Initializing variable for scope and collecting its value via scanner
		double totalWeight = 0;
		totalWeight = input.nextDouble();
		
		// Simple error handling to ensure a positive weight is entered
		while (totalWeight <= 0) {
			System.out.println(totalWeight + " is not a valid weight, please re-enter a positive value");
			totalWeight = input.nextDouble();	
		}
		
		return totalWeight; // Returns totalWeight to selectedWeight in form of a double
		
	}
	
	public static boolean continueProcessing(Scanner input) {
		
		// Intializing variables to ensure scope within the whole method
		boolean wantsToContinue;
		String selectedMenuOption = "";
		
		// Propmts the user to change wantsToContinue to false
		System.out.println("Would you like to perform another calorie calculation (Y/N)?");
		
		selectedMenuOption = input.next();
		
		// Simple error handling to ensure their input is either yes or no
		while (!selectedMenuOption.equals("Y") && !selectedMenuOption.equals("N")) {
			System.out.println("Invalid menu selection, please choose Y or N");
			selectedMenuOption = input.next();
		}
		
		if (selectedMenuOption.equals("Y")) { // The user wants to continue
			wantsToContinue = true; // Condition for main method stays true
		}
		else { // The user wants to exit the program
			wantsToContinue = false; // Condition for main method is false which ends the program
		}
		
		return wantsToContinue; // Returns wantsToContinue to wantsToContinue(in main) as a boolean
	
	}
	
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
		
		return bmr; // Returns bmr to calculatedBMR in the form of a double
	}
	
	public static double computeCaloriesWithActivity(double bmr, int activityLevel) {
		
		// Initializing variable to ensure scope within entire method
		double selectedActivityLevel = 0;
		
		// Switch statement to calculate required calories based on different activity levels
		switch (activityLevel) {
		
		case 0: // In method displayResults, 0 is defined as SEDENTARY (ln.201)
			selectedActivityLevel = (1.2 * bmr);
			break;
		case 1: // In method displayResults, 1 is defined as LIGHTLY_ACTIVE (ln.202)
			selectedActivityLevel = (1.375 * bmr);
			break;
		case 2: // In method displayResults, 2 is defined as MODERATELY_ACTIVE (ln.203)
			selectedActivityLevel = (1.55 * bmr);
			break;
		case 3: // In method displayResults, 3 is defined as VERY_ACTIVE (ln.204)
			selectedActivityLevel = (1.725 * bmr);
			break;
		case 4: // In method displayResults, 4 is defined as EXTRA_ACTIVE (ln.205)
			selectedActivityLevel = (1.9 * bmr);
			break;
		}
		
		return selectedActivityLevel; // Returns selectedActivityLevel to calculatedActivity (ln.207-211) as a double
	}
	
	public static void displayResults(double bmr) {
		
		// Delcaring constants for activity levels to avoid "magic numbers"
		final int SEDENTARY = 0;
		final int LIGHTLY_ACTIVE = 1;
		final int MODERATELY_ACTIVE = 2;
		final int VERY_ACTIVE = 3;
		final int EXTRA_ACTIVE = 4;
		
		// Initializing variables to store our calculated activity level using user's BMR
		double calculatedSedentaryActivity = computeCaloriesWithActivity(bmr, SEDENTARY);
		double calculatedLightActivity = computeCaloriesWithActivity(bmr, LIGHTLY_ACTIVE);
		double calculatedModerateActivity = computeCaloriesWithActivity(bmr, MODERATELY_ACTIVE);
		double calculatedVeryActivity = computeCaloriesWithActivity(bmr, VERY_ACTIVE);
		double calculatedExtraActivity = computeCaloriesWithActivity(bmr, EXTRA_ACTIVE);
		
		// Displaying final calculated results for BMR and calories based on activity
		System.out.println("            *********************************");
		System.out.printf("                  Your BMR is %.2f%n", bmr);
		System.out.println("            *********************************");
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Activity Level                                 Calories  ");
		System.out.println("---------------------------------------------------------");
		System.out.printf("Sedentary - little or no exercise             | %.2f%n", calculatedSedentaryActivity);
		System.out.println("");
		System.out.printf("Lightly active - Exercise 1-3 times/week      | %.2f%n", calculatedLightActivity);
		System.out.println("");
		System.out.printf("Moderately active - Exercise 4-5 times/week   | %.2f%n", calculatedModerateActivity);
		System.out.println("");
		System.out.printf("Very active - Intense exercise 6-7 times/week | %.2f%n", calculatedVeryActivity);
		System.out.println("");
		System.out.printf("Extra active - Very intense work daily        | %.2f%n", calculatedExtraActivity);
		System.out.println("---------------------------------------------------------");

	}

}
