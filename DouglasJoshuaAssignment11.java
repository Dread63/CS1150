/*
* Name: Joshua Douglas
* Class: CS1150 - 002
* Assignment #11
* Due Date: Nov 15, 2023
* Description: This program involves working with an array of car objects that encapsulates two other objects (FuelGauge, and Odometer). 
* The program is designed to practice working with objects and writing out to a file, but it mainly simulates the operation of cars.
* The primary tasks completed in the code include creating an arry of objects, simulating their operation in a lopp until all of
* the car objects run out of gas, and displaying the cars in the order they run out of fuel.
*/
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class DouglasJoshuaAssignment11 {
    public static void main(String[] args) throws IOException {

        // Initializing arrays to store cars before and after they run out of gas
        Car cars[] = new Car[5];
        Car carsOutOfGas[] = new Car[5];

        // Creating cars to fill arrays and writing car details to file
        createCars(cars);
        writeCarDetailsToFile(cars);

        // Display the state of the cars before any driving occurs
        System.out.println("Cars at start of simulation");
        printCars(cars);
        System.out.println();

        int outOfGasIndex = 0; // Used to track the order cars run out of gas

        // Running simulation until cars run out of gas
        while (checkFuelLevels(cars)) {

            for (int i = 0; i < cars.length; i++) {

                if (cars[i].getFuelLevel() == "Has Gas") {

                    double gallonsNeeded = 25 / cars[i].getMpg();

                    if (gallonsNeeded <= cars[i].getFuelGauge().getGallons()) {

                        cars[i].getFuelGauge().decrementGallons(gallonsNeeded);
                        cars[i].getOdometer().incrementMiles(25);
                    }

                    else {
                    
                        cars[i].setFuelLevel("Empty");
                        carsOutOfGas[outOfGasIndex] = cars[i];
                        outOfGasIndex++;
                    }
                }
            }
        }

        // Displaying order of cars running out of gas to user
        System.out.println("Cars ran out of gas in this order:");
        System.out.println("----------------------------------");
        
        for (int i=0; i < carsOutOfGas.length; i++) {

            System.out.println("Ran out of gas: " + carsOutOfGas[i].getOwner());
        }

        // Displaying updated state of cars in array
        System.out.println();
        System.out.println("Cars at end of simulation");
        printCars(cars);
    }
 
    // Create five different car objects
    public static void createCars(Car[] cars) {

        cars[0] = new Car("Donkey", "Toyota Tundra", 15, 34000, 8);
        cars[1] = new Car("Fiona", "Audio Q7", 21, 7110, 10);
        cars[2] = new Car("Shrek", "Jeep CJ5", 14, 11800, 5);
        cars[3] = new Car("Farquaad", "Smart Car", 42, 82700, 4);
        cars[4] = new Car("Dragon", "Chevy Suburban", 12, 150245, 30);
    }

    // Print the Owner, Vehicle, MPG, Gallons, and Mileage of each vehicle in an array
    public static void printCars(Car[] cars) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("%-5s%17s%16s%19s%14s\n", "Owner", "Vehicle", "MPG", "Gallons", "Mileage");
        System.out.println("------------------------------------------------------------------------------");
        
        for(int i = 0; i < cars.length; i++) {
            
            System.out.printf("%-15s%-20s%-15.2f%-14.2f%-20.2f\n", cars[i].getOwner(), cars[i].getModel(), cars[i].getMpg(), cars[i].getFuelGauge().getGallons(), 
            cars[i].getOdometer().getMileage());
        }
    }

    // Checking whether a car has gas or is empty and returning a bollean value based off this
    public static boolean checkFuelLevels(Car[] cars) {

        for (int i = 0; i < cars.length; i++) {

            if (cars[i].getFuelLevel().equals("Has Gas")) {

                return true; // At least one car still has gas
            }
        }

        return false; // All cars are out of gas
    }
    
    // Writing details of cars in an array to a txt file
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

// Class defining object car with constructor and getters/setters
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

// Calls defining object Odometer which contains mileage of each car object
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

// Calls defining object FuelGauge which contains gallons of gasoline in each car object
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