import java.util.Scanner;
public class Chapter7 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("How many verses would you like to test for?");
        int numOfVerses = input.nextInt();

        String[] verseReference = new String[numOfVerses];
        String[] verseBody = new String[numOfVerses];

        for (int i = 0; i < verseReference.length; i++) {

            System.out.println("What is the reference of your verse?");
            String refernce = getRefernce();
            verseReference[i] = refernce;
            System.out.println("What is the body of your verse?");
            String verse = getVerseBody();
            verseBody[i] = verse;
        }

        for (int i = 0; i < verseBody.length; i++) {
            System.out.println("Testing you for verse: " + verseReference[i]);
            System.out.println("Type your best guess ending each sentence with the enter key");
            
            String reciteAttempt = input.nextLine();

            for (i = 0;  )
            

            while ()
            int numOfVerseLines =
            String[] verseLines = new String[];

            if (reciteAttempt.equals(verseBody[i])) {
                System.out.println("Correct! Moving on to next verse...");
            }

            else {
                System.out.println("Inncorect! Check the following mistakes");

            }
        }
        for (int i = 0; i < verseReference.length; i++) {
            System.out.println(verseReference[i]);
            System.out.println(verseBody[i]);
        }
    }

    public static String getRefernce() {

        Scanner input = new Scanner(System.in);

        String refernce = input.nextLine();
        return refernce;
    }

    public static String getVerseBody() {

        Scanner input = new Scanner(System.in);

        String verse = input.nextLine();
        return verse;
    }
    
}
