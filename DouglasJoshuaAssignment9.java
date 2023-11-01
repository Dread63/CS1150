/*
* Name: Joshua Douglas
* Class: CS1150 - 002
* Assignment #9
* Due Date: Nov 1, 2023
* Description: This program is designed to test my understanding of methods and how to manipulate them. The code will
* perform multiple manipulations on 5 different sets of arrays. It will fill each array with values, combine a set
* of arrays, sort the combined array, determine if there is a missing number in the set of values in the array, and
* it will display the array and the missing number. (If no number is missing in the set of numbers in the array, a
* -1 will be displayed as the "missing number.")
*/
import java.util.Arrays;

public class DouglasJoshuaAssignment9 {
    public static void main(String[] args) {
        
        // Initializing arrays for tests #1-5
        int[] array1 = {11, 30, 19, 4, 15, 1, 20, 10, 12, 28, 14, 5, 3, 21, 22, 13};
        int[] array2 = {16, 2, 7, 18, 24, 6, 17, 8, 23, 9, 25, 26, 29};

        int[] array3 = {15, 21, 22};
        int[] array4 = {16, 18, 24, 17, 23, 20, 19};

        int[] array5 = {26, 31, 28, 25, 29, 30, 35};
        int[] array6 = {32, 33, 27};

        int[] array7 = {6, 10, 8, 4, 9, 3};
        int[] array8 = {5, 7, 2};

        int[] array9 = {16, 20, 10, 18, 14, 19, 13};
        int[] array10 = {11, 15, 17, 12};

        // Running the tests for each defined array and given upper and lower bounds
        runTest(1, 1, 30, array1, array2);

        runTest(2, 15, 25, array3, array4);

        runTest(3, 25, 35, array5, array6);

        runTest(4, 1, 10, array7, array8);

        runTest(5, 10, 20, array9, array10); // No missing number, should return -1
        }

    // Display each value of the array for every index
    public static void displayArray(int[] array) {

        for(int i = 0; i < array.length; i++) {

            System.out.println("Array [" + i + "] = " + array[i]);
        }
    }

    // Taking two given arrays and combining them into one
    public static int[] combineTwoArrays(int[] array1, int[] array2) {

        int[] combinedArray = new int[array1.length + array2.length];

        for(int i = 0; i < array1.length; i++) {

            combinedArray[i] = array1[i];
        }

        for(int i = 0; i < array2.length; i++) {

            combinedArray[array1.length + i] = array2[i];
        }

        return combinedArray;
    }

    // Calculate the sum of the given array and the theoretical complete array and subtract to finding missing number
    public static int findMissingNumber(int[] array, int lower, int upper) {

        int missingNumber = 0;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < array.length; i++) { // Sum of the numbers in the actual array
            sum1 += array[i];
        }

        for (int i = lower; i <= upper; i++) { // Sum of the numbers in the theoretical full array (1-30, 15-25 etc)
            sum2 += i;
        }

        missingNumber = sum2 - sum1;

        if (missingNumber == 0) { // Checking to see if there are no missing numbers
            missingNumber = -1;
        }

        return missingNumber;
    }

    // Calling on previous methods to manipulate data and display the given array and it's missing number
    public static void runTest(int testNum, int lower, int upper, int[] firstArray, int[] secondArray) {

        System.out.println("-------------------------");
        System.out.println("Combined Test Array #" + testNum);
        System.out.println("-------------------------");

        int[] combinedArray = combineTwoArrays(firstArray, secondArray);

        Arrays.sort(combinedArray);

        displayArray(combinedArray);

        int missingNumber = findMissingNumber(combinedArray, lower, upper);

        System.out.println();
        System.out.println("The missing number is: " + missingNumber);
    }

}
