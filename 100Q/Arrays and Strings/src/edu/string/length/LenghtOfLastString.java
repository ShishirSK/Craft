package edu.string.length;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class LenghtOfLastString {

	public int lengthOfLastWord(String s) {

		int strLength = s.length();
		if (strLength == 0) {
			return 0;
		}

		String[] strings = s.split(" ");
		int numOfStrings = strings.length;
		// IMP - Check to make sure that the array has strings
		if (numOfStrings > 0) {
			String lastString = strings[numOfStrings - 1];
			return lastString.length();
		}
		return 0;
	}
}