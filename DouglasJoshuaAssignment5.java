import java.util.Scanner;

public class DouglasJoshuaAssignment5 {

	public static void main(String[] args) {
		
		/*
		 * Name: Joshua Douglas
		 * Class: CS1150 - 002
		 * Assignment #5
		 * Due Date: Sep 27, 2023
		 * Description: This program is designed to receive user input in the form of a list of grades.
		 * After the user enters the grades they will put a negative number at the end of the list and press
		 * enter. My program will then process their data in a while loop and output the number of grades
		 * entered, the average of the exams, the highest and lowest exam, outstanding high or low exams,
		 * and the number and percentage of each letter grades in the list.
		 */

		
		//Initializing scanner
		Scanner input = new Scanner(System.in);
		 
		// Initializing variables to store the sum of and total number of grades entered
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
		System.out.println("Enter a list of grades, end the list with any negative value:");
		
		// Initializing variable to collect each grade entered
		int enteredGrade = input.nextInt();
		
		// Loop to process data until a negative number is reached
		while (enteredGrade >= 0) {
			
			// If statement to check for highest grade
			if (enteredGrade > highestGrade) {
				highestGrade = enteredGrade;
			}
			// If statement to check for lowest grade
			if (enteredGrade < lowestGrade && enteredGrade >= 0) {
				lowestGrade = enteredGrade;
			}	
			// If statement to check for outstanding high/low grades
			if (enteredGrade <= 55 || enteredGrade >= 95) {
				gradesBelow55Above95 ++;
			}
			// Multiway to count the number of each letter grades
			if (enteredGrade >= 90) {
				numberOfAGrades ++;
			}
			
			else if (enteredGrade >= 80) {
				numberOfBGrades ++;
			}
			
			else if (enteredGrade >= 70) {
				numberOfCGrades ++;
			}
			
			else if (enteredGrade >= 60) {
				numberOfDGrades ++;
			}
			
			else {
				numberOfFGrades ++;
			}
			
			// If statement to add totals and repeat loop ONLY if the negative number hasn't been reached
			if (enteredGrade >= 0) {
				totalGradeSum = totalGradeSum + enteredGrade;
				totalGradeCount ++;
				enteredGrade = input.nextInt(); //This allows the loop to repeat
			}
			
		}
		
		// If statement to check for errors
		if (totalGradeCount < 1) {
			System.out.println("No grades were entered");
			}
		
		// If no errors occurred, print the user's output
		else {
					
			// Calculating averages and percentages for output
			double gradeAverage = ((double)totalGradeSum / totalGradeCount);
			double percentageOfAGrades = ((double)numberOfAGrades / totalGradeCount * 100);
			double percentageOfBGrades = ((double)numberOfBGrades / totalGradeCount * 100);
			double percentageOfCGrades = ((double)numberOfCGrades / totalGradeCount * 100);
			double percentageOfDGrades = ((double)numberOfDGrades / totalGradeCount * 100);
			double percentageOfFGrades = ((double)numberOfFGrades / totalGradeCount * 100);
			
			// Displaying calculation in a list
			System.out.println("");
			System.out.println("Your Scores Broken Down");
			System.out.println("-----------------------");
			System.out.println("Number of Grades Entered = " + totalGradeCount);
			System.out.print("Grade average            = ");
			System.out.printf("%.2f\n", gradeAverage);
			System.out.println("Highest Score            = " + highestGrade);
			System.out.println("Lowest Score             = " + lowestGrade);
			System.out.println("Grades <= 55 or >= 95    = " + gradesBelow55Above95);
			System.out.println("");
			System.out.println("Number of A's = " + numberOfAGrades);
			System.out.println("Number of B's = " + numberOfBGrades);
			System.out.println("Number of C's = " + numberOfCGrades);
			System.out.println("Number of D's = " + numberOfDGrades);
			System.out.println("Number of F's = " + numberOfFGrades);
			System.out.println("");
			System.out.print("Percentage of A's = ");
			System.out.printf("%.2f%%\n", percentageOfAGrades);
			System.out.print("Percentage of B's = ");
			System.out.printf("%.2f%%\n", percentageOfBGrades);
			System.out.print("Percentage of C's = ");
			System.out.printf("%.2f%%\n", percentageOfCGrades);
			System.out.print("Percentage of D's = ");
			System.out.printf("%.2f%%\n", percentageOfDGrades);
			System.out.print("Percentage of F's = ");		
			System.out.printf("%.2f%%\n", percentageOfFGrades);
		}
		input.close(); // Closing scanner to avoid data leaks
				

	}

}

		
			