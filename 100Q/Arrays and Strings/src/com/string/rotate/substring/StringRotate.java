package com.string.rotate.substring;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Program to check if one string is a rotation of other using isSubstring method 
 * 
 * NOTE: isSubstring is assumed to be a method that checks if one string is a 
 * substring of other
 */

public class StringRotate {

	public static void main(String[] args) {

		String s1 = null, s2 = null;

		BufferedReader inputStrings = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			s1 = inputStrings.readLine();
			s2 = inputStrings.readLine();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}

		checkIfRotation(s1, s2);
	}

	/*
	 * Method to check if one string is rotated version of the other one
	 */

	public static boolean checkIfRotation(String first, String Second) {

		return false;
	}
}
