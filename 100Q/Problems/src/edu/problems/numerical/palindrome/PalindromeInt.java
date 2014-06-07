package edu.problems.numerical.palindrome;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class PalindromeInt {
	public boolean isPalindrome(int x) {

		// Negative numbers are not palindrome
		if (x < 0) {
			return false;
		}

		if (x >= 0 && x <= 9) {
			return true;
		}

		int digits = 0;
		// Number of digits in the number
		for (int n = x; n != 0; n /= 10) {
			digits++;
		}

		// Compare each digit
		for (int i = 0; i < digits / 2; i++) {
			if (digitAt(x, i) != digitAt(x, digits - i - 1)) {
				return false;
			}
		}
		return true;
	}

	// Method to return each digit from the number
	private int digitAt(int num, int index) {
		while (index > 0) {
			index--;
			num /= 10;
		}
		return num % 10;
	}
}