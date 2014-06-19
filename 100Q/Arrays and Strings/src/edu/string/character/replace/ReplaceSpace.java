package edu.string.character.replace;

/**
 * Replace the space in a string by '%20'. Use a character array to do so.
 * 
 * @author Shishir Kinkar
 * 
 */
public class ReplaceSpace {

	public String replaceTheSpace(String str) {

		char[] charsInString = str.trim().toCharArray();
		int strLength = charsInString.length;
		int spaceCount = 0;
		for (int i = 0; i < strLength; i++) {
			if (charsInString[i] == ' ') {
				spaceCount++;
			}
		}

		char[] newCharString = new char[strLength + 2 * spaceCount];
		int newStringLength = newCharString.length - 1;

		for (int j = strLength - 1; j >= 0; j--) {
			if (charsInString[j] == ' ') {
				newCharString[newStringLength] = '0';
				newCharString[newStringLength - 1] = '2';
				newCharString[newStringLength - 2] = '%';
				newStringLength -= 3;
			} else {
				newCharString[newStringLength] = charsInString[j];
				newStringLength--;
			}
		}
		System.out.println(String.valueOf(newCharString));
		return String.valueOf(newCharString);
	}
}
