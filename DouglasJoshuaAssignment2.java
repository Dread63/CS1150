import java.util.Scanner;
/*
 * Name: Joshua Douglas
 * Class: CS1150 - 002
 * Assignment #2
 * Due Date: Sep 6, 2023
 * Description: This program is a water drip calculator. The calculator is designed to collect information about
 * two cities from the user (including #Homes, #Dripping Faucets, and #Drips Per Min). It will then use this information
 * to calculate the amount of water wasted per year and per day in gallons. Finally, it will create an example by
 * expressing these values in terms of Olympic pools.
 */
public class DouglasJoshuaAssignment2 {

	public static void main(String[] args) {
		
		// Collecting user input
		Scanner input = new Scanner(System.in);
		
		// Declaring permanent values (constants)
		final int MIN_PER_DAY = 1440;
		final int DAYS_PER_YEAR = 365;
		final int DRIPS_PER_GAL = 15140;
		final int GALLONS_IN_OLYMPIC_POOL = 600000;
				
		
		// Prompt for information about city 1
		System.out.println("How many homes are in city 1?");
		int city1Homes = input.nextInt();
		
		System.out.println("On average, how many dripping faucets are in each home in city 1?");
		int city1Faucets = input.nextInt();
		
		System.out.println("What is the average DPM (drips per minute) of the faucets in city 1?");	
		int city1DPM = input.nextInt();
		
		// Calculating water wasted per day and year for city 1
		
		double city1DripsPerDay = city1DPM * MIN_PER_DAY;
		
		double city1DPDAllHomes = city1DripsPerDay * city1Faucets * city1Homes;
		
		double city1GalPerDay = city1DPDAllHomes / DRIPS_PER_GAL;
		
		double city1GalPerYr = city1GalPerDay * DAYS_PER_YEAR;
		
		
		// Prompt for information about city 2
		System.out.println("How many homes are in city 2");
		int city2Homes = input.nextInt();
		
		System.out.println("On average, how many dripping faucets are in each home in city 2?");
		int city2Faucets = input.nextInt();
		
		System.out.println("What is the average DPM (drips per minute) of the faucets in city 2?");
		int city2DPM = input.nextInt();
		
		// Calculating water wasted per day and year for city 2
		
		double city2DripsPerDay = city2DPM * MIN_PER_DAY;
		
		double city2DPDAllHomes = city2DripsPerDay * city2Faucets * city2Homes;
		
		double city2GalPerDay = city2DPDAllHomes / DRIPS_PER_GAL;
		
		double city2GalPerYr = city2GalPerDay * DAYS_PER_YEAR;
		
		
		// Displaying calculations in table
		System.out.println("***********************************************************************************************************");
		System.out.println("                                      Water Drip Calculator");
		System.out.println("***********************************************************************************************************");
		System.out.println("");
		
		System.out.print("         ");
		System.out.printf("%18s%20s%20s%20s%20s\n", "Homes", "Faucets", "DPM", "Gal/Day", "Gal/Year");
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.print("   City 1");
		System.out.printf("%18d%20d%20d%20.3f%20.3f\n", city1Homes, city1Faucets, city1DPM, city1GalPerDay, city1GalPerYr);
		System.out.println("");
		System.out.print("   City 2");
		System.out.printf("%18d%20d%20d%20.3f%20.3f\n", city2Homes, city2Faucets, city2DPM, city2GalPerDay, city2GalPerYr);
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		// Calculating the total gallons of both cities
		double totalGalPerDay = city1GalPerDay + city2GalPerDay;
		
		double totalGalPerYr = city1GalPerYr + city2GalPerYr;
		
		// Displaying totals
		System.out.println("");
		System.out.print("         ");
		System.out.printf("%18s%20s%20s%20.3f%20.3f\n", "Totals", "", "", totalGalPerDay, totalGalPerYr);
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		// Express totals as Olympic pools
		double totalOlympicPools = totalGalPerYr / GALLONS_IN_OLYMPIC_POOL;
		
		System.out.println("");
		System.out.println("With all " + String.format("%.2f", totalGalPerYr) + " gallons of wasted water per year, you could fill " + String.format("%.2f", totalOlympicPools) + " Olympic pools!");
		
		
		
		
		
		
		
		
		
		
				
		
		
		
		
		

	}

}
