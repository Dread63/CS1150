import java.util.Scanner;

public class DouglasJoshuaAssignment5 {

	public static void main(String[] args) {
		//Creating the skeleton of the project
		
		//Initializing scanner
		Scanner input = new Scanner(System.in);
		
		// Initalizing variables to store the sum of and total number of grades entered
		int totalGradeSum = 0;
		int totalGradeCount = 0;
		
		// Initializing variables to store the highest grade and lowest grade
		int highestGrade = 0;
		int lowestGrade = 100;
		
		// Initializing variables to store total count of letter grades
		int numberOfAGrades = 0;
		int numberOfBGrades = 0;
		int numberOfCGrades = 0;
		int numberOfDGrades = 0;
		int numberOfFGrades = 0;
		
		// Initializing variable to store outstanding high and low grades
		int gradesBelow55Above95 = 0; 
		
		// Prompting the user for input
		System.out.println("Enter each grade follwed by the enter key");
		
		// Initialzing variable to collect each grade entered
		int enteredGrade = input.nextInt();
		
		while (enteredGrade > 0) {
			
			// Creating if statement to check for highest grade
			if (enteredGrade <= 55 || enteredGrade >= 95) {
				gradesBelow55Above95 ++;
			}
			// Creating if statement to check for lowest grade
			if () {
				
			}
			// Creating if statement to check for outstanding high/low grades
			if () {
				
			}
			// Creating multiway to count number of each letter grade
			if () {
				
			}
			
			else if () {
				
			}
			
			else if () {
				
			}
			
			else if () {
				
			}
			
			else {
				
			}
			
			// Creating if statement to add totals only if the negative number hasn't been reached
			if () {
				
			}
			// Creating if statement to check for errors
			if () {
				
			}
			// If no errors occured, print the user's output
			else {
				
			}
		}

	}

}
