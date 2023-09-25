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
		
		// Initializing variables to store total count of letter gradesy
		int numberOfAGrades = 0;
		int numberOfBGrades = 0;
		int numberOfCGrades = 0;
		int numberOfDGrades = 0;
		int numberOfFGrades = 0;
		
		// Initializing variable to store outstanding high and low grades
		int gradesBelow55Above95 = 0; 
		
		// Prompting the user for input
		System.out.println("Enter each grade follwed by the enter key");
		
		// Initializing variable to collect each grade entered
		int enteredGrade = input.nextInt();
		
		boolean hasNegative = false; //Flag to check if the line of grades ends with a negative number
		boolean hasData = false; //Flag to check if any grades were inputed
		
		while (enteredGrade >= 0) {
			
			// Creating if statement to check for highest grade
			if (enteredGrade > highestGrade) {
				highestGrade = enteredGrade;
			}
			// Creating if statement to check for lowest grade
			if (enteredGrade < lowestGrade && enteredGrade >= 0) {
				lowestGrade = enteredGrade;
			}	
			// Creating if statement to check for outstanding high/low grades
			if (enteredGrade <= 55 || enteredGrade >= 95) {
				gradesBelow55Above95 ++;
			}
			// Creating multiway to count number of each letter grade
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
			
			// Creating if statement to add totals only if the negative number hasn't been reached
			if (enteredGrade >= 0) {
				totalGradeSum = totalGradeSum + enteredGrade;
				totalGradeCount ++;
				enteredGrade = input.nextInt();
			}
			
		}
		
		// Creating if statement to check for errors
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
						
			System.out.println("Number of Exams Entered = " + totalGradeCount);
			System.out.print("Grade average           = ");
			System.out.printf("%.2f\n", gradeAverage);
			System.out.println("Highest Exam            = " + highestGrade);
			System.out.println("Lowest Exam             = " + lowestGrade);
			System.out.println("Grades <= 55 or >= 95   = " + gradesBelow55Above95);
			System.out.println("");
			System.out.println("Number of A's = " + numberOfAGrades);
			System.out.println("Number of B's = " + numberOfBGrades);
			System.out.println("Number of C's = " + numberOfCGrades);
			System.out.println("Number of D's = " + numberOfDGrades);
			System.out.println("Number of F's = " + numberOfFGrades);
			System.out.println("");
			System.out.print("Percentage of A's = ");
			System.out.printf("%.2f\n", percentageOfAGrades);
			System.out.print("Percentage of B's = ");
			System.out.printf("%.2f\n", percentageOfBGrades);
			System.out.print("Percentage of C's = ");
			System.out.printf("%.2f\n", percentageOfCGrades);
			System.out.print("Percentage of D's = ");
			System.out.printf("%.2f\n", percentageOfDGrades);
			System.out.print("Percentage of F's = ");		
			System.out.printf("%.2f\n", percentageOfFGrades);
		}
				

	}

}

		
			