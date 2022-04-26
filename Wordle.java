/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;

public class Wordle {
	public static void main(String[] args) {
		//String[] wordlist = {"java", "python", "javascript", "computer", "science"}
		//take a list of terms from a file..ASK
		String word = "python"; 
		Scanner input = new Scanner(System.in);
		System.out.println("The word you need to guess is " + word.length() + " characters long."); 
		//tells user how long the word is
		int n = 5; 
		System.out.println("You have " + n + " guesses left.");
		//tells user how many guesses they have
		String guess = "";
		while (guess != word && n > 0) { //while guess isn't the word and the user still has guesses left
		    guess = input.nextLine();
		    if (guess.length() != word.length()) { //if the guess is not the same length as the word
		        System.out.println("Your guess must be " + word.length() + " characters."); //tells user how long the word is
		        continue;
		    }
		    for (int i = 0; i < word.length(); i++) {
		        for (int j = 0; j < word.length(); j++) {
		            
		        }
		    }
		        
		}
		
	}
}
