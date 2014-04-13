package edu.string.palindrome.longest;

import java.util.Arrays;

/**
 * @author Shishir Kinkar
 * 
 *         Program to find the longest palindrome in a given string
 */
public class LongestPalindromeInString {

	static int palLength = 0;
	static int palStartPos = 0;
	static int largestShift = 0;

	public static void main(String[] args) {

		String withPalindrome = "82aeiouoiea95e58~321nkomokn123~k434748293rhvjiow";
		getLongest(withPalindrome);
	}

	/**
	 * @param str
	 * 
	 *            Method to loop through the characters to find the longest
	 *            palindrome
	 */
	public static void getLongest(String str) {

		char[] carray = str.toCharArray();

		for (int i = 1; i < carray.length - 1; i++) {

			if (carray[i - 1] == carray[i + 1]) {
				getPossiblePalindrome(carray, i - 1, i + 1, 1);
			} else if (carray[i] == carray[i - 1]) {
				getPossiblePalindrome(carray, i - 1, i, 0);
			}
		}

		char[] palArray = Arrays.copyOfRange(carray, palStartPos + 1,
				palStartPos + palLength + 1);
		String pal = String.valueOf(palArray);
		System.out.println(pal);
	}

	/**
	 * @param charray
	 *            - array with all characters
	 * @param leftPos
	 *            - left pointer to check character
	 * @param rightPos
	 *            - right pointer to check character
	 * @param centerPos
	 *            - pointer to the center position of palindrome - O in case of
	 *            even length palindrome - 1 in case of odd length palindrome
	 */
	public static void getPossiblePalindrome(char[] charray, int leftPos,
			int rightPos, int centerPos) {

		int shiftCount = 0;

		while (leftPos >= 0 && rightPos < charray.length) {

			if (charray[leftPos] == charray[rightPos]) {
				leftPos--;
				rightPos++;
				shiftCount++;
			} else
				break;
		}
		if (shiftCount > largestShift) {
			largestShift = shiftCount;
			palLength = 2 * shiftCount + centerPos; // 2 is due to shift of both
													// pointers simultaneously
			palStartPos = leftPos++;
		}
	}

}
