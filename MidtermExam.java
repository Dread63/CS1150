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

        /* 
        System.out.printf("%2f, %2.4f", 5.43, 676.44);

        int num1 = 7;
        int num2 = 82;
        int num3 = 56;

        double double1 = 56.69;
        double double2 = 66.79654;
        double double3 = 21.4564;

        int maxValueInt = max(num1, num2, num3);
        double maxValueDouble = max(double1, double2, double3);
        System.out.printf("%7s, %4.2f", "Max of your doubles are ", maxValueDouble);
        System.out.printf("%24s, %2d", "Max of your integers is ", maxValueInt);

       

         int i = 1;
    while (i < 10) {
        if ((i++) % 2 == 0) {
            System.out.println(i);
        }
       */
      
       String str = "Hello";
       for (int i = str.length()-1; i >= 0; i--) {
        System.out.println(str.charAt(i));
       }
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

    public static double max(double numDouble1, double numDouble2, double numDouble3) {

        double max1 = max(numDouble1, numDouble2);
        double max2 = max(max1, numDouble3);
        double max3 = max(max2, numDouble3);
        return max3;
    }

}


