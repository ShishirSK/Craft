package edu.problems.numerical.reverseint;

/**
 * Reverse digits of an integer. #LeetCode
 * 
 * @author Shishir Kinkar
 */
public class ReverseInteger {

	public int reverse(int x) {

		String space = " ";
		char prefix = 0;

		// No need to reverse in this range
		if (x > -10 && x < 10) {
			return x;
		} else if (x < 0) {
			prefix = '-';
			x = x * -1;
		}

		String number = Integer.toString(x);
		// Replace 0s at the start of the string
		number = number.replaceAll("\\A0*", space);
		// Replace 0s at the end of the string
		number = number.replaceAll("0*\\Z", space);

		StringBuilder sb = new StringBuilder(number.trim());
		sb.reverse();

		if (prefix != 0)
			sb.insert(0, prefix); // For negative numbers

		return Integer.parseInt(sb.toString());
	}

}
