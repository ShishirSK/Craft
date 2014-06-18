package edu.string.character.unique;

/**
 * Check if all the characters in the string are equal
 * 
 * @author Shishir Kinkar
 * 
 */
public class CheckUniqueCharsBitWise {

	public boolean isUniqueBitWise(String str) {

		int checker = 0;
		int currentChar;
		for (int i = 0; i < str.length(); i++) {
			currentChar = str.charAt(i) - 'a';
			if ((checker & (1 << currentChar)) > 0) {
				return false;
			}
			checker |= currentChar;
		}
		return true;
	}
}
