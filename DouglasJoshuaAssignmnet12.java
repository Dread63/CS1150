/*
* Name: Joshua Douglas
* Class: CS1150 - 002
* Assignment #12
* Due Date: Nov 30, 2023
* Description: This program is designed to explore parent classes and sub-classes, utilize overridden methods,
* understand the use of the keyword "Super," and practice reading from a file. The parent class defines objects
* of the Animal type and includes four subclasses defining animals such as sloth, bear, monkey, and elephant.
* After running code in the background, the program will display each animal in the polymorphic array and it's
* attributes to the console.
*/
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class DouglasJoshuaAssignmnet12 {
    public static void main(String[] args) throws IOException {
        
        // Initializing scanner and file to read from
        File inputFileName = new File("Animals.txt");
        Scanner inputFile = new Scanner(inputFileName);

        Animal[] animals = new Animal[inputFile.nextInt()];

        // Inputting file contents into given animal array index
        for (int i = 0; i < animals.length; i++) {

            String type = inputFile.next();
            String name = inputFile.next();
            String food = inputFile.next();
            int weight = inputFile.nextInt();
            int sleep = inputFile.nextInt();
            String location = inputFile.nextLine();

            switch (type) {

                case "Bear":
                    animals[i] = new Bear(name, food, weight, sleep, location);
                    break;
                case "Sloth":
                    animals[i] = new Sloth(name, food, weight, sleep, location);
                    break;
                case "Monkey":
                    animals[i] = new Monkey(name, food, weight, sleep, location);
                    break;
                case "Elephant":
                    animals[i] = new Elephant(name, food, weight, sleep, location);
                    break;
            }
        }

        // Displaying each animal in polymorphic array and their attributes
        for (int i = 0; i < animals.length; i++) {

            String animalType = getAnimalType(animals[i]);

            System.out.println("Animal[" + i + "] is a " + animalType);
            System.out.println(animalType + "Name: " + animals[i].getName() + " - " + "Weighs: " 
            + animals[i].getWeight() + " lbs" + " - " + "Sleeps: " + animals[i].getSleep() + " hours" 
            + " - " + "Location: " + animals[i].getLocation());

            animals[i].eat();
            animals[i].sleep();
            animals[i].swim();
            System.out.println();
        }
    }

    // If an animal is an instance of any of the following types, return that type as a string
    private static String getAnimalType(Animal animal) {

        if (animal instanceof Bear) {
            return "Bear";
        } else if (animal instanceof Sloth) {
            return "Sloth";
        } else if (animal instanceof Monkey) {
            return "Monkey";
        } else if (animal instanceof Elephant) {
            return "Elephant";
        } else {
            return "Unknown Animal Type";
        }
    }
}

// Parent class defining attributes of an animal object
class Animal {

    private String name;
    private String food;
    private int weight;
    private int sleep;
    private String location;

    // Parent constructor to be used with "super" in subclasses
    public Animal(String name, String food, int weight, int sleep, String location) {

        this.name = name;
        this.food = food;
        this.weight = weight;
        this.sleep = sleep;
        this.location = location;
    }

    // Establishing getters and setters
    public String getName() {
        return name;
    }

    public String getFood() {
        return food;
    }

    public int getWeight() {
        return weight;
    }

    public int getSleep() {
        return sleep;
    }

    public String getLocation() {
        return location;
    }

    // Establishing methods to make the animals do 3 different actions
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void swim() {
        System.out.println("Animal is swimming");
    }
}

// Class Bear which defines an object that is subclass to Animal
class Bear extends Animal {

    // Constructor which calls on super to fill attributes of bear object
    public Bear(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    // Overridden methods to make specific type of animal do 3 unique actions
    @Override
    public void eat() {

        System.out.println("Bear is eating " + getFood());
    }

    @Override
    public void sleep() {

        System.out.println("Bear is sleeping for " + getSleep() + " Hours");
    }

    @Override
    public void swim() {

        System.out.println("Bear is swimming");
    }
}

// Class elephant which defines an object that is subclass to Animal
class Elephant extends Animal {

    // Constructor which calls on super to fill attributes of elephant object
    public Elephant(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    // Overriddent method to make an elephant do 1 unique
    @Override
    public void sleep() {

        System.out.println("Elephant is sleeping for " + getSleep() + " Hours");
    }
}

// Class monkey which defines an object that is subclass to Animal
class Monkey extends Animal {

    // Constructor which calls on super to fill attributes of monkey object
    public Monkey(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    @Override
    public void eat() {

        System.out.println("Money is eating " + getFood());
    }

    @Override
    public void swim() {

        System.out.println("Monkey is swimming");
    }
}

// Class sloth which defines an object that is subclass to Animal
class Sloth extends Animal {

    // Constructor which calls on super to fill attributes of sloth object
    public Sloth(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }
}

