import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class DouglasJoshuaAssignment11 {
    public static void main(String[] args) throws IOException {

        
        Car cars[] = new Car[5];
        Car carsOutOfGas[] = new Car[5];

        createCars(cars);
        writeCarDetailsToFile(cars);
        printCars(cars);

        simulateDriving(cars, carsOutOfGas);
        displayCarsOutOfGas(carsOutOfGas);
    }
 
    public static void simulateDriving(Car[] cars, Car[] carsOutOfGas) {
        while (checkFuelLevels(cars)) {
            for (int i = 0; i < cars.length; i++) {
                if (cars[i].getFuelLevel().equals("Has Gas")) {
                    double gallonsNeeded = 25 / cars[i].getMpg();
                    if (cars[i].getFuelGauge().getGallons() >= gallonsNeeded) {
                        cars[i].getFuelGauge().decrementGallons(gallonsNeeded);
                        cars[i].getOdometer().incrementMiles(25);
                    } else {
                        cars[i].setFuelLevel("Empty");
                        carsOutOfGas[i] = cars[i];
                    }
                }
            }
        }
    }

    
    public static void displayCarsOutOfGas(Car[] carsOutOfGas) {
        System.out.println("Cars that ran out of gas");

        for (Car car : carsOutOfGas) {
            if (car != null) {
                System.out.println(car.getOwner());
            }
        }
    }


    public static void createCars(Car[] cars) {

        cars[0] = new Car("Donkey", "Toyota Tundra", 15, 34000, 8);
        cars[1] = new Car("Fiona", "Audio Q7", 21, 7110, 10);
        cars[2] = new Car("Shrek", "Jeep CJ5", 14, 11800, 5);
        cars[3] = new Car("Farquaad", "Smart Car", 42, 82700, 4);
        cars[4] = new Car("Dragon", "Chevy Suburban", 12, 150245, 30);
    }

    public static void printCars(Car[] cars) {

        System.out.println("Cars at start of simulation");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-5s%15s%10s%20s%25s\n", "Owner", "Vehicle", "MPG", "Gallons", "Mileage");
        System.out.println("-------------------------------------------------------");
        
        for(int i = 0; i < cars.length; i++) {
            
            System.out.println(cars[i].getOwner() + " " + cars[i].getModel() + " " + cars[i].getMpg() + " " + cars[i].getFuelGauge().getGallons() + " " + cars[i].getOdometer().getMileage());
        }
    }

    public static boolean checkFuelLevels(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getFuelGauge().getGallons() > 0) {
                return true;  // At least one car still has gas
            }
        }
        return false;  // All cars are out of gas
    }
    

    public static void writeCarDetailsToFile(Car[] cars) throws IOException {

        File fileName = new File("Assignment11.txt");

        PrintWriter resultsFile = new PrintWriter(fileName);

        resultsFile.println("Car Details");
        for (int i = 0; i < cars.length; i++) {

            resultsFile.println(cars[i].getOwner());
            resultsFile.println(cars[i].getModel());
            resultsFile.println(cars[i].getMpg());
            resultsFile.println(cars[i].getFuelGauge().getGallons());
        }

        resultsFile.close();

        System.out.println("Find the file here " + fileName.getAbsolutePath());
        System.out.println();
    }
}

class Car {

    private String owner;
    private String model;
    private double mpg;
    private String fuelLevel;
    private Odometer odometer;
    private FuelGauge fuelGauge;
   
    public Car(String owner, String model, double mpg, double mileage, double gallons) {

        this.owner = owner;
        this.model = model;
        this.mpg = mpg;
        fuelLevel = "Has Gas";

        odometer = new Odometer(mileage);
        fuelGauge = new FuelGauge(gallons);
    }
    
    public String getOwner() {
        return owner;
    }

    public String getModel() {
        return model;
    }

    public double getMpg() {
        return mpg;
    }

    public String getFuelLevel() {
        return fuelLevel;
    }

    public Odometer getOdometer() {
        return odometer;
    }

    public FuelGauge getFuelGauge() {
        return fuelGauge;
    }

    public void setFuelLevel(String fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}

class Odometer {

    private double mileage;

    public Odometer(double mileage) {

        this.mileage = mileage;
    }

    public double getMileage() {
        return mileage;
    }

    public void incrementMiles(double milesTraveled) {
        mileage += milesTraveled;
    }
}

class FuelGauge {

    private double gallons;

    public FuelGauge(double gallons) {
        this.gallons = gallons;
    }

    public double getGallons() {
        return gallons;
    }

    public void decrementGallons(double gallonsUsed) {
        if (gallons >= gallonsUsed) {
            
            gallons -= gallonsUsed;
        }

        else {
            gallons = 0.0;
        }
    }
}