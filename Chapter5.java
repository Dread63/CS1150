import java.util.Scanner;

public class Chapter5 {

	public static void main(String[] args) {
//A GRADE COUNT / TOTAL GRADE COUNT
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter each grade follwed by the enter key");
		
		// Variables to store the sum and total number of grades entered
		int totalGradeSum = 0;
		int totalGradeCount = 0;
		
		// Variable to store the highest grade and lowest grade
		int highestGrade = 0;
		int lowestGrade = 100;
		
		// Variables to store count of letter grades
		int numberOfAGrades = 0;
		int numberOfBGrades = 0;
		int numberOfCGrades = 0;
		int numberOfDGrades = 0;
		int numberOfFGrades = 0;
		
		//Variables to store outstanding high and low grades
		int gradesBelow55Above95 = 0; 
		
		// Variable to collect each grade entered
		int aGrade = input.nextInt();
		
		if (aGrade ==) {
			System.out.println("No grades were entered, please restart and enter a least on grade followed by a negative number");
		}
		
		else {
			
			while (aGrade > 0) {
				
				if (aGrade <= 55 || aGrade >= 95) {
					gradesBelow55Above95 ++;
				}
				
				if (aGrade > highestGrade) {
					highestGrade = aGrade;
				}
				
				if (aGrade < lowestGrade && aGrade >= 0) {
					lowestGrade = aGrade;
				}
					
				if (aGrade >= 90) {
					numberOfAGrades ++;
				}
				else if (aGrade >= 80) {
					numberOfBGrades ++;
				}
				else if (aGrade >= 70) {
					numberOfCGrades ++;
				}
				else if (aGrade >= 60) {
					numberOfDGrades ++;
				}
				else {
					numberOfFGrades ++;
				}
				
				if (aGrade > 0) {
					totalGradeSum = totalGradeSum + aGrade;
					totalGradeCount ++;
					aGrade = input.nextInt();
				}

			}
			System.out.println(totalGradeSum + " " + totalGradeCount);
			double gradeAverage = ((double)totalGradeSum / totalGradeCount);
			
			System.out.println("Grade count = " + totalGradeCount + " totalGrade = " + totalGradeSum);
			System.out.println("Highest Grade = " + highestGrade + " Lowest Grade = " + lowestGrade);
			System.out.printf("%.2f\n", gradeAverage);
		}
			
	}
		
		
	

}
