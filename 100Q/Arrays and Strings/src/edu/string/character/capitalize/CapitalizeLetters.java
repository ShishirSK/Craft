package edu.string.character.capitalize;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Shishir Kinkar
 * 
 */
public class CapitalizeLetters {

	public static void main(String[] args) {

		String charsToCap = null;
		CapitalizeLetters caps = new CapitalizeLetters();

		// Get input string
		BufferedReader inputStrings = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			System.out.print("Enter the string: ");
			charsToCap = inputStrings.readLine();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}

		String retString = caps.CapitalizeSelectively(charsToCap);
		System.out.println(retString);
	}

	/**
	 * @param capitalizeThese
	 *            - string with characters to capitalize
	 * @return string - formatted string
	 */
	public String CapitalizeSelectively(String capitalizeThese) {

		final int difference = 97;
		int opArrayIndex = 0, asciiVal = 0, charsToCapitalize = 0;
		char[] outputArray = new char[26];
		boolean[] presentChars = new boolean[26];
		char[] charArray = capitalizeThese.toCharArray();

		charsToCapitalize = capitalizeThese.length();
		// Check for alphabets in the string
		for (int i = 0; i < charsToCapitalize; i++) {
			if (Character.isAlphabetic(charArray[i])) {
				asciiVal = (int) Character.toLowerCase((charArray[i]))
						- difference;
				if (asciiVal >= 0 && asciiVal < 26)
					presentChars[asciiVal] = true;
			}
		}

		// Make the output string
		for (char ch = 'a'; ch <= 'z'; ch++) {
			asciiVal = (int) ch - difference;
			if (presentChars[asciiVal])
				outputArray[opArrayIndex++] = Character.toUpperCase(ch);
			else
				outputArray[opArrayIndex++] = ch;
		}

		return String.valueOf(outputArray);
	}

}
