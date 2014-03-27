package com.string.rotate.substring;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Program to check if one string is a rotation of other using isSubstring method 
 * 
 */

public class StringRotate {

	public static void main(String[] args) {

		String s1 = null, s2 = null;

		BufferedReader inputStrings = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			System.out.print("Enter the first string: ");
			s1 = inputStrings.readLine();
			System.out.print("Enter the second string: ");
			s2 = inputStrings.readLine();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}

		boolean isRotation = checkIfRotation(s1, s2);
		if (isRotation)
			System.out.println("One string is rotation of other.");
		else {
			System.out.println("One string is NOT the rotation of other.");
		}
	}

	/*
	 * Method to check if one string is rotated version of the other one
	 */
	public static boolean checkIfRotation(String first, String second) {

		int l1 = first.length();
		if (l1 == second.length() && l1 > 0) {
			String doubleString = first + first;
			return isSubstring(doubleString, second);
		}
		return false;
	}

	/*
	 * Method to check if one string is substring of the other
	 */
	private static boolean isSubstring(String longer, String shorter) {
		if (longer.contains(shorter)) {
			return true;
		}
		return false;
	}
}
