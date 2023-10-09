import java.util.Scanner;
public class DouglasJoshuaAssignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean wantsToContinue = true;
		
		while (wantsToContinue) {
			
			Scanner input = new Scanner(System.in);
			
			// Collecting user input
			System.out.println("Select gender, type M for male and F for female");
			char selectedGender = getGender(input);
			
			System.out.println("Please input your age in years (1-100)");
			int selectedAge = getAge(input);
			
			System.out.println("Please input your weight in pounds");
			double selectedWeight = getWeight(input);
			
			// Stmt on line 19 calls on getHeight to prompt the user and calculate their total height in inches
			System.out.println("Please enter your total height in feet and inches");
			int selectedHeight = getHeight(input);
			
			// This calls on computeBMR to calculate the users BMR based on input, then displays data with displayResults
			double calculatedBMR = computeBMR(selectedGender, selectedAge, selectedHeight, selectedWeight);
			displayResults(calculatedBMR);
			
			// Checking if the user wants to execute another iteration or exit the program
			wantsToContinue = continueProcessing(input);
		}
		
	}
	
	public static char getGender(Scanner input) {
		
		String selectedGender = input.next();
		char gender = selectedGender.charAt(0);
		
		while (gender != 'M' && gender != 'F') {
			System.out.println("Invalid gender choice please select M for male and F for female");
			selectedGender = input.next();
			gender = selectedGender.charAt(0);
		}
		
		return gender;
		
	}
	
	public static int getAge(Scanner input) {
		
		int age = input.nextInt();
		
		while (age <= 0 || age >= 100) {
			System.out.println("Invalid age, please choose a whole number between 1 and 100");
			age = input.nextInt();
		}
		
		return age;
	}
	
	public static int getHeight(Scanner input) {
		
		int heightInFeet = 0;
		int heightInInches = 0;
		int totalHeightInInches = 0;
		
		do {
			System.out.print("Feet:");
			heightInFeet = input.nextInt();
			
			System.out.print("Inches:");
			heightInInches = input.nextInt();
			System.out.println("");
			
			totalHeightInInches = heightInInches + (heightInFeet * 12);
			
			if (totalHeightInInches < 1 || totalHeightInInches > 107) {
				System.out.println(heightInFeet + " feet " + heightInInches + " inches is not a valid height, please re-enter");
			}
			
		} 
		while (totalHeightInInches <1 || totalHeightInInches > 107);
		
		return totalHeightInInches;
	}
	
	public static double getWeight(Scanner input) {
		
		double totalWeight = 0;
		totalWeight = input.nextDouble();
		
		while (totalWeight <= 0) {
			System.out.println(totalWeight + " is not a valid weight, please re-enter a positive value");
			totalWeight = input.nextDouble();	
		}
		
		return totalWeight;
		
	}
	
	public static boolean continueProcessing(Scanner input) {
		
		boolean wantsToContinue;
		String selectedMenuOption = "";
		
		System.out.println("Would you like to perform another calorie calculation (Y/N)?");
		
		selectedMenuOption = input.next();
		
		while (!selectedMenuOption.equals("Y") && !selectedMenuOption.equals("N")) {
			System.out.println("Invalid menu selection, please choose Y or N");
			selectedMenuOption = input.next();
		}
		
		if (selectedMenuOption.equals("Y")) {
			wantsToContinue = true;
		}
		else {
			wantsToContinue = false;
		}
		
		return wantsToContinue;
	
	}
	
	public static double computeBMR (char gender, double age, double height, double weight) {
		
		double bmr = 0;
		
		switch (gender) {
	
		case 'M':
			bmr = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
			break;
			
		case 'F':
			bmr = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
			break;
		}
		
		return bmr;
	}
	
	public static double computeCaloriesWithActivity(double bmr, int activityLevel) {
		
		double selectedActivityLevel = 0;
		
		switch (activityLevel) {
		
		case 0:
			selectedActivityLevel = (1.2 * bmr);
			break;
		case 1:
			selectedActivityLevel = (1.375 * bmr);
			break;
		case 2:
			selectedActivityLevel = (1.55 * bmr);
			break;
		case 3:
			selectedActivityLevel = (1.725 * bmr);
			break;
		case 4:
			selectedActivityLevel = (1.9 * bmr);
			break;
		}
		
		
		return selectedActivityLevel;
	}
	
	public static void displayResults(double bmr) {
		
		final int SEDENTARY = 0;
		final int LIGHTLY_ACTIVE = 1;
		final int MODERATELY_ACTIVE = 2;
		final int VERY_ACTIVE = 3;
		final int EXTRA_ACTIVE = 4;
		
		double calculatedSedentaryActivity = computeCaloriesWithActivity(bmr, SEDENTARY);
		double calculatedLightActivity = computeCaloriesWithActivity(bmr, LIGHTLY_ACTIVE);
		double calculatedModerateActivity = computeCaloriesWithActivity(bmr, MODERATELY_ACTIVE);
		double calculatedVeryActivity = computeCaloriesWithActivity(bmr, VERY_ACTIVE);
		double calculatedExtraActivity = computeCaloriesWithActivity(bmr, EXTRA_ACTIVE);
		
		// Displaying final calculated results for BMR and calories based on activity
		System.out.println("*********************************");
		System.out.println("Your BMR is " + bmr);
		System.out.println("*********************************");
		
		System.out.println("-------------------------------------------");
		System.out.println("Activity Level                     Calories");
		System.out.println("-------------------------------------------");
		System.out.println("Sedentary - little or no exercise: " + calculatedSedentaryActivity);
		System.out.println("Lightly active - Exercise 1-3 times/week: " + calculatedLightActivity);
		System.out.println("Moderately active - Exercise 4-5 times/week: " + calculatedModerateActivity);
		System.out.println("Very active - Intense exercise 6-7 times/week: " + calculatedVeryActivity);
		System.out.println("Extra active - Very intense work daily: " + calculatedExtraActivity);
		
		
	}

}
