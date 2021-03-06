import java.util.Scanner;
import java.util.regex.Pattern;


public class Anagrams {

	public static void main(String[] args) {
		String userString = readUserString();
		System.out.println(makeAnagrams(userString));
	}

	private static String readUserString() {
		System.out.println("Enter words divided by spaces and press enter to make anagrams");
		return new Scanner(System.in).nextLine();
	}

	private static String makeAnagrams(String userString) {
		
		StringBuilder result = new StringBuilder();
		
		for (String word: userString.split(" ")) {
			processOneWord(result, word);
		}
		return result.toString();
	}

	private static void processOneWord(StringBuilder result, String word) {
		Pattern nonAlphabet = Pattern.compile("[^a-zA-Z]");
		if(nonAlphabet.matcher(word).find()) {
			System.err.println("Entered words contains not alphabetic characters.");
			System.exit(0);
		}
		result.append(reverse(word));
	}

	private static String reverse(String word) {
		return new StringBuilder(word).reverse().toString() + " ";
	}

}