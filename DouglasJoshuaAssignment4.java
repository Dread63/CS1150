import java.util.Scanner;

public class DouglasJoshuaAssignment4 {

	public static void main(String[] args) {
		
		/*
		 * Name: Joshua Douglas
		 * Class: CS1150 - 002
		 * Assignment #4
		 * Due Date: Sep 20, 2023
		 * Description: This program implements a very simple scheme for encrypting and decrypting a 5 
		 * character long string. This program offers the options of encrypting via Caesar Cipher or XOR
		 * encryption. The code also has the functionality to decrypt the the string by reversing the 
		 * formula (not just printing the un-encrypted user input). The purpose of this project is to learn
		 * and apply the math class in my code.
		 */

		
		// Declaring Constants
		final int CAESAR_ENCRYPT = 0 + (int)(Math.random() * 26); // Generates a random number in the range of the lowercase alphabet (26 letters)
		final int CAESAR_DECRYPT = 26 - CAESAR_ENCRYPT; // Evaluates the decrypt shift by subtracting 26 (z) from the number generated in line 20
		
		final int XOR_RANDOM_NUMBER = 65 + (int)(Math.random() *  26); // This creates a random number between 65 and 90 (A-Z)
		final char XOR_KEY = (char) XOR_RANDOM_NUMBER; // This casts the value from line 12 into a character that can be used as our XOR key
		
		
		// Prompting user for encryption method
		System.out.println("CS1150 Encoding and Decoding Program");
		System.out.println("");
		System.out.println("Choose an Encryption Method (Select option 1 or 2)");
		System.out.println("---------------------------");
		System.out.println("1) Caesar Cipher");
		System.out.println("2) XOR Encryption");
		
		// Initializing scanner and collecting user input
		Scanner input = new Scanner(System.in);
		int selectedEncryptionMethod = input.nextInt();
		
		// Evaluating what path to take (Caesar)
		if (selectedEncryptionMethod == 1) {
			
			
			// Prompting user for their custom string 
			System.out.println("Enter your 5 character long string");
			String userCustomString = input.next();
			
			// Validating user input
			if (userCustomString.length() == 5) {
				
				// Convert string to lowercase to avoid errors
				String userCustomLowercaseString = userCustomString.toLowerCase();
				
				// Extracting characters from user inputed string
				char char1 = userCustomLowercaseString.charAt(0);
				char char2 = userCustomLowercaseString.charAt(1);
				char char3 = userCustomLowercaseString.charAt(2);
				char char4 = userCustomLowercaseString.charAt(3);
				char char5 = userCustomLowercaseString.charAt(4);
				
				// Encrypting and decrypting characters from user inputed string
				char encryptedChar1 = (char)((char1 - 97 + CAESAR_ENCRYPT) % 26 + 97); // "a" is 97 in ASCII, so by subtracting char1 from 97 we ensure it stays within the alphabet range (97-122)
				char encryptedChar2 = (char)((char2 - 97 + CAESAR_ENCRYPT) % 26 + 97); // after subtracting, we add the shift (CAESAR_ENCRYPT) to encrypt. Then, we use the modulo operator to effectively
				char encryptedChar3 = (char)((char3 - 97 + CAESAR_ENCRYPT) % 26 + 97); // "wrap around" the alphabet (0-26). Finally, we add 97 "a" to our value between 0 and 26 to turn in back into ASCII.
				char encryptedChar4 = (char)((char4 - 97 + CAESAR_ENCRYPT) % 26 + 97);
				char encryptedChar5 = (char)((char5 - 97 + CAESAR_ENCRYPT) % 26 + 97);
				
				
				char decryptedChar1 = (char)((encryptedChar1 - 97 + CAESAR_DECRYPT) % 26 + 97); // This completes the same steps as lines 60-65, but it uses our decrypt (reverse) shift 
				char decryptedChar2 = (char)((encryptedChar2 - 97 + CAESAR_DECRYPT) % 26 + 97); // to get the original character
				char decryptedChar3 = (char)((encryptedChar3 - 97 + CAESAR_DECRYPT) % 26 + 97);
				char decryptedChar4 = (char)((encryptedChar4 - 97 + CAESAR_DECRYPT) % 26 + 97);
				char decryptedChar5 = (char)((encryptedChar5 - 97 + CAESAR_DECRYPT) % 26 + 97);
				
				// Assembling encrypted and decrypted string from encrypted characters
				String encryptedString = "" + encryptedChar1 + encryptedChar2 + encryptedChar3 
						+ encryptedChar4 + encryptedChar5;
				
				String decryptedString = "" + decryptedChar1 + decryptedChar2 + decryptedChar3 
						+ decryptedChar4 + decryptedChar5;
				
				// Displaying output to user
				System.out.println("Caesar Cipher");
				System.out.println("-------------------------------------");
				System.out.println("Caesar Shift Value (encrypt) = " + CAESAR_ENCRYPT);
				System.out.println("Caesar Shift Value (decrypt) = " + CAESAR_DECRYPT);
				System.out.println("Origional string             = " + userCustomString);
				System.out.println("Caesar Encrypted String      = " + encryptedString);
				System.out.println("Caesar Decrypted String      = " + decryptedString);
					
			}
			else {
				System.out.println(userCustomString + " is not a valid string - program can only encrypt "
						+ "strings with exactly 5 characters");	
			}
		}
	
		
		// Evaluating what path to take (XOR)
		else if	(selectedEncryptionMethod == 2) {
			
			
			// Prompting user for their custom string
			System.out.println("Enter your custom string to be encrypted or decrypted (5 characters long)");
			String userCustomString = input.next();
			
			// Validating user input
			if (userCustomString.length() == 5) {
				
				// Converting string to lowercase to avoid errors
				String userCustomLowercaseString = userCustomString.toLowerCase();
				
				// Extracting characters from user inputed string
				char char1 = userCustomLowercaseString.charAt(0);
				char char2 = userCustomLowercaseString.charAt(1);
				char char3 = userCustomLowercaseString.charAt(2);
				char char4 = userCustomLowercaseString.charAt(3);
				char char5 = userCustomLowercaseString.charAt(4);
				
				// Encrypting and decrypting characters from user inputed string
				char encryptedChar1 = (char)(char1 ^ XOR_KEY);
				char encryptedChar2 = (char)(char2 ^ XOR_KEY);
				char encryptedChar3 = (char)(char3 ^ XOR_KEY);
				char encryptedChar4 = (char)(char4 ^ XOR_KEY);
				char encryptedChar5 = (char)(char5 ^ XOR_KEY);
				
				
				char decryptedChar1 = (char)(encryptedChar1 ^ XOR_KEY);
				char decryptedChar2 = (char)(encryptedChar2 ^ XOR_KEY);
				char decryptedChar3 = (char)(encryptedChar3 ^ XOR_KEY);
				char decryptedChar4 = (char)(encryptedChar4 ^ XOR_KEY);
				char decryptedChar5 = (char)(encryptedChar5 ^ XOR_KEY);
				
				// Assembling encrypted and decrypted string from characters
				String encryptedString = "" + encryptedChar1 + encryptedChar2 + encryptedChar3 
						+ encryptedChar4 + encryptedChar5;
				
				String decryptedString = "" + decryptedChar1 + decryptedChar2 + decryptedChar3 
						+ decryptedChar4 + decryptedChar5;
				
				// Displaying output to user
				System.out.println("XOR Encryption");
				System.out.println("-------------------------------------");
				System.out.println("XOR Key          = " + XOR_KEY);
				System.out.println("Original String  = " + userCustomString);
				System.out.println("Encrypted String = " + encryptedString);
				System.out.println("Decrypted String  = " + decryptedString);
			}	
	
			else { 
				System.out.println(userCustomString + " is not a valid string - program can only encrypt "
						+ "strings with exactly 5 characters");
			}

		}

		else	{ 
			System.out.println(selectedEncryptionMethod + " is not a valid menu option. Please enter 1 or 2");
		}
			
	}

}
