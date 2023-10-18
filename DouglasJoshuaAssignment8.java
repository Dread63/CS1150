public class DouglasJoshuaAssignment8 {
    public static void main(String[] args) {
        
        String[] courseNames = new String[5];
        String[] letterGrades = new String[5];
        int[] creditHours = new int[5];

        courseNames[0] = "CS 1150";
        courseNames[1] = "Math";
        courseNames[2] = "Physics";
        courseNames[3] = "Chemistry";
        courseNames[4] = "English";

        letterGrades[0] = "A";
        letterGrades[1] = "A-";
        letterGrades[2] = "B";
        letterGrades[3] = "C+";
        letterGrades[4] = "C-";

        creditHours[0] = 3;
        creditHours[1] = 3;
        creditHours[2] = 4;
        creditHours[3] = 3;
        creditHours[4] = 3;


        displayResults(courseNames, letterGrades, creditHours);
        int sumOfCredits = computeSumOfCredits(creditHours);
        double totalGradePoints = computerTotalGradePoints(letterGrades, creditHours);

        System.out.println("Your total grade points = " + totalGradePoints);

    }

    public static void displayResults(String[] courses, String[] grades, int[] credits) {

        System.out.println("--------------------------------");
        System.out.printf("%5s %10s %14s\n", "Course", "Grade", "Credit Hours");
        System.out.println("--------------------------------");
        System.out.printf("%5s %7s %11d\n", courses[0], grades[0], credits[0]);
        System.out.printf("%4s %11s %10d\n", courses[1], grades[1], credits[1]);
        System.out.printf("%5s %7s %11d\n", courses[2], grades[2], credits[2]);
        System.out.printf("%9s %6s %10d\n", courses[3], grades[3], credits[3]);
        System.out.printf("%7s %8s %10d\n", courses[4], grades[4], credits[4]);
    }

    public static int computeSumOfCredits(int[] credits) {

        int sumOfCredits = 0;

        for (int i = 0; i < credits.length; i++) {
            
            sumOfCredits += credits[i];
        }

        return sumOfCredits;

    }

    public static double computerTotalGradePoints(String[] grades, int[] credits) {

        double totalGradePoints = 0.0;

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

        for (int i = 0; i < credits.length; i++) {

            switch (grades[i]) {

                case "A":
                    totalGradePoints += (credits[i] * GRADE_A);
                    break;
                case "A-":
                    totalGradePoints += (credits[i] * GRADE_A_MINUS);
                    break;
                case "B+":
                    totalGradePoints += (credits[i] * GRADE_B_PLUS);
                    break;
                case "B":
                    totalGradePoints += (credits[i] * GRADE_B);
                    break;
                case "B-":
                    totalGradePoints += (credits[i] * GRADE_B_MINUS);
                    break;
                case "C+":
                    totalGradePoints += (credits[i] * GRADE_C_PLUS);
                    break;
                case "C":
                    totalGradePoints += (credits[i] * GRADE_C);
                    break;
                case "C-":
                    totalGradePoints += (credits[i] * GRADE_C_MINUS);
                    break;
                case "D+":
                    totalGradePoints += (credits[i] * GRADE_D_PLUS);
                    break;
                case "D":
                    totalGradePoints += (credits[i] * GRADE_D);
                    break;
                case "D-":
                    totalGradePoints += (credits[i] * GRADE_D_MINUS);
                    break;
                case "F":
                    totalGradePoints += (credits[i] * GRADE_F  );
                    break;
            }
        }
        return totalGradePoints;
    }


}
