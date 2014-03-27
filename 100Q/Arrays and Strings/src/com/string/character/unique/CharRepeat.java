package com.string.character.unique;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Program to take a string and check if it has all unique characters
 * 
 * Flow:
 * 1. Convert the string to character array
 * 2. Sort the character array
 * 3. Check for same consecutive characters
 * 
 */

public class CharRepeat {

	public static void main(String[] args) {

		String s1 = null;

		BufferedReader inputStrings = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			System.out.print("Enter the string: ");
			s1 = inputStrings.readLine();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}

		boolean doesIt = hasRepeatChar(s1);
		if (doesIt)
			System.out.println("The string has unique characters.");
		else {
			System.out.println("The string has repeat characters.");
		}
	}

	/*
	 * Method to check for repeat chars
	 */
	private static boolean hasRepeatChar(String s1) {

		char[] charA = new char[s1.length()];
		charA = s1.toCharArray();
		Arrays.sort(charA);

		for (int i = 1; i < s1.length(); i++) {
			if (charA[i] == charA[1 - 1])
				return false;
		}

		return true;

	}

}
