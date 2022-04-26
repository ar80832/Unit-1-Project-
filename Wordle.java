import java.util.Scanner;
import java.io.file; 

public class Wordle {
	public static void main(String[] args) {
		//String[] wordlist = {"java", "python", "javascript", "computer", "science"}
		//take a list of terms from a file..ASK
		Scanner wordFile = new Scanner(new File(filename.txt));
		ArrayList<String> words = new ArrayList<String>();
		while(wordFile.hasNext()){
		    words.add(wordFile.nextLine());
		}
		int choice = (int)(Math.random()*words.size());
		String word = words.get(choice);
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
		        if (word.substring(i, i+1).equals(guess.substring(i, i+1))) {
		            //right placeq
		            
		        }
	            else if (word.indexOf(guess.substring(i, i+1)) >= 0) {
	                //wrong place, but letter is there
	            else 
	                //wrong place wrong letter
	            }
		        }
		        //put in method
		        //keep calling check guess
		     guess 
		     //main method call play game, supporting methods get the word from the file, get 
		     //guess from player, supporting method for checking 
		     //display whether they lost or won
		    }
		        
		}
		
	}
}