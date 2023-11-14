import java.util.Scanner;
public class QuizReview2 {

    public static void main(String[] args) {

        int[] intArray = {1, 4, 7, 9, 2};
        int sum = 0;

        for(int i=0; i < intArray.length; i++) {

            sum += intArray[i];
        }
        System.out.println(sum);

        int[] largestArray = {1, 99, 66, 72, 105, 24};
        int largest = 0;

        for(int i=0; i < largestArray.length; i++) {

            if (largestArray[i] > largest) {
                largest = largestArray[i];
            }
        }
        System.out.println(largest);

        
        /*
        Missle[] arsenal = new Missle[5];

        for (int i = 0; i < arsenal.length; i++) {

            arsenal[i] = createMissle();
        }

        launchMissle(arsenal);
         */
    }
    /* 
    public static Missle createMissle() {

        int serial;

        Scanner input = new Scanner(System.in);

        System.out.println("What is the make of your missle?");
        
        String make = input.nextLine();

        System.out.println("What is the model of your missle?");

        String model = input.nextLine();

        System.out.println("Would you like to generate a random serial number (Y/N)?");

        String menuChoice = input.next();
        char menuChoiceChar = menuChoice.charAt(0);

        if (menuChoiceChar == 'Y') {

            serial = (int) (Math.random() * 999999999 + 1); 
        }

        else {
            System.out.println("Please enter your serial number");
        
            serial = input.nextInt();
        }

        double xCode = createLaunchCodes();
        double yCode = createLaunchCodes();

        LaunchCodes launchCode = new LaunchCodes(xCode, yCode);

        Missle missle = new Missle(make, model, serial, launchCode);

        return missle;
    }

    public static double createLaunchCodes() {

        double launchCode = (Math.random() * 99 + 1);

        return launchCode;
    }

    public static void launchMissle(Missle[] arsenal) {

        Scanner input = new Scanner(System.in);

        System.out.println("Which missle would you like to launch (1-5)?");
        
        for(int i=0; i < arsenal.length; i ++) {

            System.out.println("Make: " + arsenal[i].getMake());
            System.out.println("Model: " + arsenal[i].getModel());
            System.out.println("Serial: " + arsenal[i].getSerial());
            System.out.println();
        }

        int chosenMissle = input.nextInt();
        input.nextLine();

        System.out.println("Launching " + arsenal[chosenMissle - 1].getSerial() + " Missile in 3 seconds");

        System.out.println("MISSILE LAUNCHED");
    }
}

class LaunchCodes {

    private double Xlocation;
    private double Ylocation;

    public LaunchCodes(double Xlocation, double Ylocation) {

        this.Xlocation = Xlocation;
        this.Ylocation = Ylocation;
    }

    public double getLaunchCodeX() {
        return Xlocation;
    }

    public double getLaunchCodeY() {
        return Ylocation;
    }
}

class Missle {

    Scanner input = new Scanner(System.in);

    private String make;
    private String model;
    private int serial;
    private String missleController;
    private LaunchCodes launchCode;

    public Missle(String make, String model, int serial, LaunchCodes launchCode) {

        this.make = make;
        this.model = model;
        this.serial = serial;
        this.launchCode = launchCode;
    }

    public void setMissileController(Scanner input) {

        missleController = input.nextLine();
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getSerial() {
        return serial;
    }
    */
}
