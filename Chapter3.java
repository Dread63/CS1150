import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class Chapter3 {

	public static void main(String[] args) {
		/*
		// Addition Quiz Maker
		double number1 = (double)(System.currentTimeMillis() % 10);
		double number2 = (double)(System.currentTimeMillis() / 10 % 10);
		
		System.out.println("What is " + number1 + " + " + number2 + "? ");
		
		//Create a scanner
		Scanner input = new Scanner(System.in);
		
		
		double answer = input.nextDouble();
		
		System.out.println(number1 + " + " + number2 + " = " + answer + " is " + (number1 + number2 == answer));
		*/
		
		/*More advanced addition quiz maker
		
		//Random instance
		Random random = new Random();
		
		//Defining radom values and formatting them
		double randomNum1 = random.nextDouble(150) + 1;
		double randomNum2 = random.nextDouble(150) + 1;	
		
		
		//Making scanner and requesting user's answer
		Scanner input = new Scanner(System.in);
		double answer = input.nextDouble();
		
		// Define a tolerance value for comparison
		double tolerance = 0.01; // Adjust this value as needed

		// Calculate the absolute difference between the numbers
		double diff1 = Math.abs(randomNum1 - answer);
		double diff2 = Math.abs(randomNum2 - answer);

		// Check if both differences are within the tolerance
		boolean isCorrect = diff1 <= tolerance && diff2 <= tolerance;
		
		//Defining Decimal Format
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		//Formatting the numbers for display
		String formattedRandomNum1 = decimalFormat.format(randomNum1);
		String formattedRandomNum2 = decimalFormat.format(randomNum2);
		String formattedAnswer = decimalFormat.format(answer);
		
		//Displaying formatted problem to user
		System.out.println("What is " + formattedRandomNum1 + " + " + formattedRandomNum2 + "? ");
		
		//Calculating answer and informing user of correctness
		System.out.println(formattedRandomNum1 + " + " + formattedRandomNum2 + " = " + formattedAnswer + " is " + isCorrect);
		
		*/
		
		//Practicing If Statments (In Class)
		
		/* IF STATMENT FOR AREA OF CIRLCE

		final double PI = 3.14159;
		System.out.println("What is the radius of your circle?");
		Scanner input = new Scanner(System.in);
		int radius = input.nextInt();
		
		if (radius >= 0) {
			System.out.println("The area of your circle is " + radius * radius * PI);
		}
		else {
			System.out.println("A circle cannot have a negative area");
		}
		
		*/
		
		//PAY RATE CALCULATOR BASED ON PERFORMANCE
		
		//Requesting User Input
		System.out.println("What score did they get?");
		Scanner input = new Scanner(System.in);
		int score = input.nextInt();
		System.out.println("What is their current pay per hour?");
		double rate = input.nextDouble();
		
		//Calculating rate based off performance
		double thirtyPercentRaise = ((rate * 0.3) + rate);
		double tenPercentRaise = ((rate * 0.1) + rate);
		
		//Formating rate to be to two decimal places
		DecimalFormat decimalFormat = new DecimalFormat("##.#");
		String formattedRateThirty = decimalFormat.format(thirtyPercentRaise);
		String formattedRateTen = decimalFormat.format(tenPercentRaise);
		
		//Displaying new pay rate based on score
		if (score >=90)	{
			System.out.println("Their new pay rate is " + formattedRateThirty);
		}
		else {
			System.out.println("Their new pay rate is " + formattedRateTen);
		}
		
		
		
		
		
		
		
		

	}

}
