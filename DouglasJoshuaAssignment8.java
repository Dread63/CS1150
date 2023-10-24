/*
* Name: Joshua Douglas
* Class: CS1150 - 002
* Assignment #8
* Due Date: Oct 25, 2023
* Description: This program is a GPA calculators that is designed to explore arrays and their various uses in java. 
* Using three arrays (courseNames, letterGrades, and creditHours) to display the course, corresponding credit hours,
* and grades. This program includes methods that manipulate the data in the arrays to calculate and display the total
* amount of credits taken, the total grade points, the GPA of the given student, and the grade worth the most
* amount of points. Lastly, this program uses the "dog" class and manipulates the methods inside it to explore
* objects and their various uses.
*/
public class DouglasJoshuaAssignment8 {
    public static void main(String[] args) {
        
        // Initializing arrays and storing data in them to be used throughout program
        String[] courseNames = new String[5];
        String[] letterGrades = new String[5];
        int[] creditHours = new int[5];

        courseNames[0] = "CS 1150";
        courseNames[1] = "Math";
        courseNames[2] = "Physics";
        courseNames[3] = "Chemistry";
        courseNames[4] = "English";

        letterGrades[0] = "A";
        letterGrades[1] = "C+";
        letterGrades[2] = "A-";
        letterGrades[3] = "B";
        letterGrades[4] = "C-";

        creditHours[0] = 3;
        creditHours[1] = 3;
        creditHours[2] = 4;
        creditHours[3] = 3;
        creditHours[4] = 3;

        // Calling on display which will print the coursenames, grades, and credit hours in order
        display(courseNames, letterGrades, creditHours);

        // Calling on methods to calculate data and store the returned value in variables
        int sumOfCredits = computeSumOfCredits(creditHours);

        double totalGradePoints = computeTotalGradePoints(letterGrades, creditHours);

        double totalGPA = totalGradePoints / sumOfCredits;

        String gradeWorthMostPoints = "" + courseNames[findGradeWorthMostPoints(letterGrades, creditHours)] 
        + " " + letterGrades[findGradeWorthMostPoints(letterGrades, creditHours)];
        
        // Displaying the output of the calculated data
        System.out.println("Total Credits: " + sumOfCredits);
        System.out.println();
        System.out.printf("Total Grade Points: %4.2f\n", totalGradePoints);
        System.out.println();
        System.out.printf("Overall GPA: %4.2f\n", totalGPA);
        System.out.println();
        System.out.println("Grade worth most points: " + gradeWorthMostPoints);
        System.out.println();
        System.out.println();

        // Array and data to be used in second half of assignment 8
        Dog[] dogArray = new Dog[5];

        Dog dog1 = new Dog("Rover", "woof woof");
        Dog dog2 = new Dog("Max", "arf arf arf");
        Dog dog3 = new Dog("Tiny", "yap yap yap");
        Dog dog4 = new Dog("Trooper", "ruff ruff ruff");
        Dog dog5 = new Dog("Magoo", "bow wow bow wow");

        dogArray[0] = dog1;
        dogArray[1] = dog2;
        dogArray[2] = dog3;
        dogArray[3] = dog4;
        dogArray[4] = dog5;

        // Calls on makeDogsBark to display the output of our previously initialized array
        makeDogsBark(dogArray);
    }

    // For each course, display the course name, grade, and credits
    public static void display(String[] courses, String[] grades, int[] credits) {

        System.out.println("--------------------------------");
        System.out.printf("%5s %10s %14s\n", "Course", "Grade", "Credit Hours");
        System.out.println("--------------------------------");

        for (int i = 0; i < courses.length; i++) {
            System.out.printf("%-13s %-7s %5d\n", courses[i], grades[i], credits[i]);
        }

        System.out.println();
    }

    // Method to calculate total amount of credits the student is taking
    public static int computeSumOfCredits(int[] credits) {

        int sumOfCredits = 0;

        for (int i = 0; i < credits.length; i++) {
            
            sumOfCredits += credits[i];
        }

        return sumOfCredits;
    }

    // Method that utilizes a switch statement to convert the letter grade (A) to its number value (4.0)
    public static double convertLetterGradeToPoints(String grade) {
        
        final double GRADE_A = 4.0;
        final double GRADE_A_MINUS = 3.7;
        final double GRADE_B_PLUS = 3.3;
        final double GRADE_B = 3.0;
        final double GRADE_B_MINUS = 2.7;
        final double GRADE_C_PLUS = 2.3;
        final double GRADE_C = 2.0;
        final double GRADE_C_MINUS = 1.7;
        final double GRADE_D_PLUS = 1.3;
        final double GRADE_D = 1.0;
        final double GRADE_D_MINUS = 0.7;
        final double GRADE_F = 0.0;

        double gradeInPoints = 0.0;

        switch (grade) {

             case "A":
                    gradeInPoints = GRADE_A;
                    break;
                case "A-":
                    gradeInPoints = GRADE_A_MINUS;
                    break;
                case "B+":
                    gradeInPoints = GRADE_B_PLUS;
                    break;
                case "B":
                    gradeInPoints = GRADE_B;
                    break;
                case "B-":
                    gradeInPoints = GRADE_B_MINUS;
                    break;
                case "C+":
                    gradeInPoints = GRADE_C_PLUS;
                    break;
                case "C":
                    gradeInPoints = GRADE_C;
                    break;
                case "C-":
                    gradeInPoints = GRADE_C_MINUS;
                    break;
                case "D+":
                    gradeInPoints = GRADE_D_PLUS;
                    break;
                case "D":
                    gradeInPoints = GRADE_D;
                    break;
                case "D-":
                    gradeInPoints = GRADE_D_MINUS;
                    break;
                case "F":
                    gradeInPoints = GRADE_F;
                    break;
        }
        return gradeInPoints;
    }

    // Calculating and returning the total points for each grade in array letterGrades
    public static double computeTotalGradePoints(String[] grades, int[] credits) {

        double totalGradePoints = 0.0;

        for (int i = 0; i < credits.length; i++) {

            totalGradePoints += (convertLetterGradeToPoints(grades[i]) * credits[i]);
            }

        return totalGradePoints;
        }

    // Finding the highest letter grade and returning the array index of the highest grade   
    public static int findGradeWorthMostPoints(String[] grades, int[] credits) {

        int gradeWorthMostPoints = 0;

        double highestGrade = 0.0;

        for (int i = 0; i < grades.length; i++) {

             double tempGrade = convertLetterGradeToPoints(grades[i]) * credits[i];
             
             if (tempGrade > highestGrade) {

                highestGrade = tempGrade;
                gradeWorthMostPoints = i;
             }
        }
        return gradeWorthMostPoints;
    } 

    // Method to manipulate the dog objects and display it to the user
    public static void makeDogsBark(Dog[] dogArray) {

        System.out.println("Making the dogs bark!");
        System.out.println("-----------------------");

        for(int i = 0; i <= 4; i++) {

            String dogsName = dogArray[i].getName();
            String dogsBark = dogArray[i].getBark();

            System.out.println(dogsName + " barks like this: " + dogsBark);
            System.out.println();
        }
    }

}

// Dog class provided by proffessor Mickey
class Dog {
    private String name;
    private String bark;

    public Dog(String name, String bark) {
        this.name = name;
        this.bark = bark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }
}
