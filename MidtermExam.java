import java.util.Scanner;
public class MidtermExam {
    public static void main(String[] args) {
        
       // int i = 15;
       // System.out.printf("%3d", i);
        
        // double j = 17.8963;
       // System.out.printf("%6.2f", j);

       /* 
        Scanner input = new Scanner(System.in);
        System.out.println("Try to find the secret number");

        int oddCheck = input.nextInt();
        while (oddCheck < 6 || oddCheck > 6) {
            System.out.println("Not it! Try again!");
            oddCheck = input.nextInt();
        }
        */
        int num1 = 7;
        int num2 = 82;
        int num3 = 56;

        int maxValue = max(num1, num2, num3);

        System.out.println(maxValue);
    }

    // the folowing three methods are OVERLOADED
    public static int max(int num1, int num2) {

        if(num1 > num2) {
            return num1;
        }
        else {
            return num2;
        }
    }

    public static double max(double num1, double num2) {
        if(num1 > num2) {
            return num1;
        }
        else {
            return num2;
        }
    }

    public static int max(int num1, int num2, int num3) {

        int max1 = max(num1, num2);
        int max2 = max(max1, num3); // OR return max(max(num1, num2))
        return max2;
    } // END OF OVERLOAD METHODS
}

