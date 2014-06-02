package edu.problems.numerical.plusone;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * The digits are stored such that the most significant digit is at the head of
 * the list. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {

		int num = 0;
		boolean overFlow = false;
		// Add 1 starting from the last position
		for (int i = digits.length - 1; i >= 0; i--) {
			num = digits[i] + 1;
			if (num < 10) {
				digits[i] = num;
				break;
			} else {
				digits[i] = 0;
				if (i == 0) {
					overFlow = true; // If array size needs to increase
				}
			}
		}

		// In case of int arrays like [9,9,9], larger return array is needed
		if (overFlow) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			for (int i = 1; i < newDigits.length; i++) {
				newDigits[i] = digits[i - 1];
			}
			return newDigits;
		} else {
			return digits;
		}
	}
}