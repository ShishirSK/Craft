package com.string.character.replaceSpace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Program to replace Space ' ' by %20 using character array
 * 
 */

public class ReplaceSpace {

	public static void main(String[] args) {

		String s1 = null;

		// Get String
		BufferedReader inputStrings = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			System.out.print("Enter the string: ");
			s1 = inputStrings.readLine();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}

		// Modify
		String outputString = replaceSpaceChar(s1);
		// Output
		System.out.println(outputString);
	}

	/*
	 * Method to get count of spaces and replace each by %20 Returns the
	 * modified string
	 */
	private static String replaceSpaceChar(String str) {

		int spaceCount = 0, newLength = 0, newIndex = 0;

		char[] strToChar = str.trim().toCharArray();
		int strLength = strToChar.length;

		for (int i = 0; i < strLength; i++) {
			if (strToChar[i] == ' ')
				spaceCount++;
		}

		// 1 Space replaced by 3 characters (%20)
		newLength = (spaceCount * 3) + strLength;
		char[] newArray = new char[newLength];
		newIndex = newLength - 1;

		// Construct new array
		for (int j = strLength - 1; j >= 0; j--) {
			if (strToChar[j] != ' ') {
				newArray[newIndex] = strToChar[j];
				newIndex--;
			} else {
				newArray[newIndex] = '0';
				newArray[--newIndex] = '2';
				newArray[--newIndex] = '%';
				newIndex--;
			}
		}
		return String.valueOf(newArray);
	}
}
