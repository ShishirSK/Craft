package edu.string.character.unique;

/**
 * Check if all the characters in the string are equal
 * 
 * @author Shishir Kinkar
 * 
 */
public class CheckUniqueChars {

	public boolean checkUnique(String str) {

		boolean[] characters = new boolean[256]; // Assuming ASCII
		int currentChar = 0;
		for (int i = 0; i < str.length(); i++) {
			currentChar = str.charAt(i);
			if (characters[currentChar]) {
				return false;
			}
			characters[currentChar] = true;
		}
		return true;
	}

}
