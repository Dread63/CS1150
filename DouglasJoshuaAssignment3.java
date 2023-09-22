import java.util.Scanner;

public class DouglasJoshuaAssignment3 {

	public static void main(String[] args) {
		/*
		 * Name: Joshua Douglas
		 * Class: CS1150 - 002
		 * Assignment #3
		 * Due Date: Sep 13, 2023
		 * Description: This program serves as a college semester cost calculator. It provides students with
		 * information on the base tuition per credit hour for different class levels and allows them to select
		 * their current class year. Afterward, it prompts users to input the number of credit hours they are 
		 * taking in the current semester. The program then computes and displays the total tuition and fees, 
		 * breaking down the costs in a user-friendly table format. This project demonstrates my understanding 
		 * in utilizing various types of if statements, including nested if statements and multiway if 
		 * statements.
		 */
		
		// Initializing scanner to collect user input
		Scanner input = new Scanner(System.in);
		
		// Declaring Constants
		final double FRESHMAN_TUITION = 449.00;
		final double SOPHOMORE_TUITION = 465.00;
		final double JUNIOR_TUITION = 478.00;
		final double SENIOR_TUITION = 528.00;
		final double STUDENT_BASE_FEE = 150.00;
		final double CREDIT_HOUR_SIGNUP_FEE = 15.00;
		
		// Displaying class levels and cost per credit hour
		System.out.println("Welcome to Tuition Calculator");
		System.out.println("");
		System.out.printf("%s%10s%25s%n", "Option", "Level", "Cost Per Credit Hour");
		System.out.println("-------------------------------------------");
		System.out.printf("%d%17s%9s%.2f%n", 1, "Freshman", "$", FRESHMAN_TUITION);
		System.out.printf("%d%17s%9s%.2f%n", 2, "Sophmore", "$", SOPHOMORE_TUITION);
		System.out.printf("%d%15s%11s%.2f%n", 3, "Junior", "$", JUNIOR_TUITION);
		System.out.printf("%d%15s%11s%.2f%n", 4, "Senior", "$", SENIOR_TUITION);
		System.out.println("-------------------------------------------");
		
		// Asking for user input
		System.out.println("\nSelect class level: 1, 2, 3, or 4:");
		int classLevel = input.nextInt();
		
		// Initializing variables to calculate tuition and display selected class level
		double studentTuition = 0.0;
		String selectedClassLevel = "";
		
		
		// Validating user input
		boolean validClassLevel = false; // Assume input is invalid until one of the following below is entered 
		
		if (classLevel == 1 || classLevel == 2 || classLevel == 3 
			|| classLevel == 4)	{
			validClassLevel = true;
		}
		
		// Translating the entered number into the corresponding class level and tuition
		if (validClassLevel)	{	
			if (classLevel == 1)	{
				studentTuition = FRESHMAN_TUITION;
				selectedClassLevel = "Freshman";
			}
			else if (classLevel == 2)	{
				studentTuition = SOPHOMORE_TUITION;
				selectedClassLevel = "Sophmore";
			}
			else if (classLevel == 3) {
				studentTuition = JUNIOR_TUITION;
				selectedClassLevel = "Junior";
			}
			else if (classLevel == 4)	{
				studentTuition = SENIOR_TUITION;
				selectedClassLevel = "Senior";
			}	
				
			// Prompting user for # credit hours and validating input
			System.out.println("How many credit hours are you taking (1-30)?");
			int creditHours = input.nextInt();
			
			if (creditHours >= 1 && creditHours <= 30)	{
				
				// Computing tuition, fees, and total cost
				
				double totalTuition = studentTuition * creditHours;
				
				double totalFees = CREDIT_HOUR_SIGNUP_FEE * creditHours + STUDENT_BASE_FEE;
				
				double creditHourSignupFee = creditHours * CREDIT_HOUR_SIGNUP_FEE;
				
				double totalCost = totalTuition + totalFees;
				
				
				// Displaying Computed Results
				System.out.println("\nYour tuition calculated!");
				System.out.println("");
				System.out.print("---------------TUITION--------------");
				System.out.printf("\n%s: %s", "Class Level", selectedClassLevel);
				System.out.printf("\n%s: %d", "Credit Hours", creditHours);
				System.out.printf("\n%s: $%.2f%n", "Total Tuition", totalTuition);
				System.out.print("----------------FEES----------------");
				System.out.printf("\n%s: $%.2f", "Base Student Fee", STUDENT_BASE_FEE);
				System.out.printf("\n%s: $%.2f", "Credit Hour Signup Fees", creditHourSignupFee);
				System.out.printf("\n%s: $%.2f%n", "Total Fees", totalFees);
				System.out.print("---------------TOTAL----------------");
				System.out.printf("\n%s: $%.2f", "Total Cost", totalCost);
			}
			
		else	{
			System.out.println("Invalid number of credit hours, credit hours must be between 1 and 30");
			}
		}
		
	else	{
		System.out.println("Invalid class level, please choose 1-4");
		}

	}

}
