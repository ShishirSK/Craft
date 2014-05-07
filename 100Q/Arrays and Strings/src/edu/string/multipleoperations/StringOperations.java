package edu.string.multipleoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * A program to perform various string manipulation operations
 * 
 * @author 	- Shishir Kinkar 
 * 
 * @version - 0.1 	- Initial commit
 *			  0.2 	- String Reversal
 * 			  0.3 	- Check for one string being permutation of other
 *			  0.4 	- Replace blank spaces by %20
 *			  0.5  	- Replace repeat characters by repeat count
 */
public class StringOperations {

	/*
	 * Gives the menu for the program
	 * 
	 * @throws - IOException
	 */
	public static void main(String args[]) throws IOException {

		StringOperations allOps = new StringOperations();
		allOps.menu();

	}

	/*
	 * Promts the user to enter a string, displays a menu of operations that can
	 * be performed, and asks the user to choose an operation
	 * 
	 * @param - none
	 * 
	 * @return - void
	 * 
	 * @throws - IOException
	 */
	void menu() throws IOException {

		int inputOption = 0;

		System.out.print("Enter a string: ");
		BufferedReader str = new BufferedReader(
				new InputStreamReader(System.in));
		String string = str.readLine();

		System.out
				.println("String operations: \n 1. String reversal \n 2. Check for all uniques");
		System.out
				.println(" 3. Check if one is permutation of other \n 4. Insert %20 in place of spaces between words");
		System.out
				.println(" 5. Compress String by Replacing Repeat Characters by count");
		System.out.print("Choose operation to perform: ");
		BufferedReader opr = new BufferedReader(
				new InputStreamReader(System.in));

		try {
			inputOption = Integer.parseInt(opr.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		}

		// Perform operation based on user input
		switch (inputOption) {
		case 1:
			strReversal(string);
			break;
		case 2:
			checkForAllUniques(string);
			break;
		case 3:
			checkForOnePermOfOther(string);
			break;
		case 4:
			repalceBlankSpaces(string);
			break;
		case 5:
			strRepeatCount(string);
			break;
		default:
			System.out.println("Choose another operation.");
		}
	}

	/*
	 * Takes a string, reverses it and returns
	 * 
	 * @param - inputstream - A string given by the user
	 * 
	 * @return - void
	 */
	void strReversal(String inputString) {

		StringBuffer reverseString = new StringBuffer();
		String[] strArray = new String[inputString.length()];

		strArray = inputString.split("");

		for (int strIndex = strArray.length - 1; strIndex >= 0; strIndex--) {
			reverseString.append(strArray[strIndex]);
		}

		System.out.println("The reversed string is: "
				+ reverseString.toString());
	}

	/*
	 * Checks if an entered string is composed of all unique characters
	 * 
	 * @param - inputstream - A string given by the user
	 * 
	 * @return - void
	 */
	void checkForAllUniques(String inputString) {

		int strLength = inputString.length();

		for (int i = 1; i < strLength; i++) {

			char currentChar = inputString.charAt(i);
			if (inputString.substring(i + 1).contains(
					String.valueOf(currentChar))) {
				System.out
						.println("String does not contain all unique characters.");
				return;
			}
		}
		System.out.println("String contains all unique characters.");
	}

	/*
	 * Checks if an entered string is permutation of other string
	 * 
	 * @param - inputstream - A string given by the user
	 * 
	 * @return - void
	 */

	// NOTE: Consider the cases of case sensitivity and blank spaces in the
	// strings.

	void checkForOnePermOfOther(String inputString) throws IOException {

		System.out.println("Enter the second string:");
		BufferedReader str2 = new BufferedReader(new InputStreamReader(
				System.in));
		String inputString2 = str2.readLine();

		if (inputString == inputString2)
			System.out.println("They are same strings!");
		else if (inputString.length() != inputString2.length())
			System.out.println("The strings are not valid permutations.");
		else {

			for (int i = 0; i < inputString.length(); i++) {

				char currentChar = inputString.charAt(i);
				if (!inputString2.contains(String.valueOf(currentChar))) {
					System.out
							.println("Second string is not a permutation of the first.");
					return;
				}
			}
			System.out.println("Second string is a permutation of the first.");
		}
	}

	/*
	 * Replaces all blanks between words by %20. Blanks at the end should not be
	 * replaced
	 * 
	 * @param - inputstream - A string given by the user
	 * 
	 * @return - void
	 */

	void repalceBlankSpaces(String inputString) {

		String[] strArray = inputString.trim().split(" ");
		String filler = "%20";
		StringBuilder modifiedString = new StringBuilder();

		for (int i = 0; i < strArray.length; i++) {

			modifiedString.append(strArray[i]);

			if (i != strArray.length - 1) {
				modifiedString.append(filler);
			}
		}
		System.out.print("Modified String is: " + modifiedString);
	}

	/*
	 * Replace all consecutive characters in a string by count of repetition. If
	 * the length of string is not reduced, print out the original string.
	 * 
	 * @param - inputstream - A string given by the user
	 * 
	 * @return - void
	 */

	void strRepeatCount(String inputString) {

		int strSize = countCompression(inputString);
		if (strSize >= inputString.length()) {
			System.out.println("The string is uncompressed: " + inputString);
			return;
		}

		StringBuilder newString = new StringBuilder();
		char last = inputString.charAt(0);
		int count = 1;

		for (int i = 1; i < inputString.length(); i++) {
			if (inputString.charAt(i) == last) {
				count++;
			} else {
				newString.append(last);
				newString.append(count);
				last = inputString.charAt(i);
				count = 1;
			}
		}

		newString.append(last);
		newString.append(count);
		System.out.println("The output string is: " + newString.toString());
	}

	/*
	 * Returns size of string passed by the strRepeatCount string compression
	 * method
	 * 
	 * @param - str - String to check the size of
	 * 
	 * @return - int - The size of the string
	 */

	int countCompression(String str) {

		if (str == null || str.isEmpty())
			return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
}
