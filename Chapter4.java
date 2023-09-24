import java.util.Scanner;

public class Chapter4 {

	public static void main(String[] args) {
		// Pracicing what I've learned in chapter 4
		
		
		//Using the Math class in java
		/*
		double randomnum = (0 + Math.random() * 999);
		System.out.printf("%.2f", randomnum);
		*/
		
		/*
		double testlog = Math.sin(Math.asin(Math.PI / 6));
		System.out.printf("%.2f", testlog);
		*/
		
		
		//Experimenting with escape sequences in java
		/*
		System.out.println("\t is a tab character");
		System.out.println("\n what is a linefeed");
		*/
		
		
		//Learning how to use the char variable
		/*
		char ch = (char)65.25; //65 is the character A in unicode
		System.out.println(ch);
		*/
		
		/*
		int asciCode = '5';
		int asciCode2 = 'A';
		System.out.println(asciCode + asciCode2);
		
		char asciAddedCode = (char)118;
		System.out.println(asciAddedCode);
		*/
		
		/*
		final int CEASAR = 1;
		final int XOR = 2;
		
		int ceasarShift = 0 + (int)(Math.random() * 26);
		int xorShift = 65 + (int)(Math.random() *  26); //65 is A and 90 is Z, 91 is placed at the end because
		char xorRandomShift = (char) xorShift;			//it is exclusive
		System.out.println(xorRandomShift);
		
		//Collect user string for encryption
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your 5 letter long code");
		String userString = input.nextLine();
		
		//Extract each individual character
		char char1 = userString.charAt(0);
		char char2 = userString.charAt(1);
		char char3 = userString.charAt(2);
		char char4 = userString.charAt(3);
		char char5 = userString.charAt(4);
		
		char encryptedCeasarChar1 = (char)((char1 - 97 + ceasarShift) % 26 + 97);
		char encryptedCeasarChar2 = (char)((char2 - 97 + ceasarShift) % 26 + 97);
		char encryptedCeasarChar3 = (char)((char3 - 97 + ceasarShift) % 26 + 97);
		char encryptedCeasarChar4 = (char)((char4 - 97 + ceasarShift) % 26 + 97);
		char encryptedCeasarChar5 = (char)((char5 - 97 + ceasarShift) % 26 + 97);
		
		System.out.println("Your cesar shift is " + ceasarShift);
		System.out.println("Your encrypted string is: " + encryptedCeasarChar1 + encryptedCeasarChar2 + encryptedCeasarChar3 + encryptedCeasarChar4 + encryptedCeasarChar5);
		*/
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter full name");
		String firstName = input.nextLine();
		String middleName = input.nextLine();
		String lastName = input.nextLine();
		input.close();
		
		System.out.println("1) " + firstName);
		System.out.println("2) " + middleName);
		System.out.println("3) " + lastName);
		
		
		String str1 = "some string";
		System.out.println(str1.charAt(str1.length()-1));
		System.out.print(str1.charAt(str1.length()-1) == str1.charAt(10));
		
		
		
		
	}

}
