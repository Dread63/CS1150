import java.util.Scanner;

public class Chapter5 {

	public static void main(String[] args) {

		/*
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
		*/
		
		/*
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < 10; ++i) {
			sum1 += i;
		}
		for (int i = 0; i <10; i++) {
			sum2 += i;
		}
		System.out.println(sum1);
		System.out.println(sum2);
		*/
		
		/*
		for (int num = 0; num < 100; ++num, System.out.println(num)); {
		}
		*/
		
		/*
		Scanner input = new Scanner(System.in);
		int number, sum = 0, count;
		
		for (count = 0; count < 5; count++) {
			number = input.nextInt();
			sum += number;
		}
		System.out.println(sum);
		System.out.println(count);
		*/
		
		/*
		long sum = 0;
		int i = 0;
		
		while (i <= 100) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		System.out.println(i);
		*/
		
		long sum = 0;
		int i = 0;
		
		do {
			sum += i;
			i++;
		} while (i <=100);
		System.out.println(sum);
		System.out.println(i);
		
	}
		
		
	

}
