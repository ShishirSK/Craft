package edu.problems.numerical;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class AddBinary {

	public String addBinary(String a, String b) {

		int m = a.length();
		int n = b.length();
		int carry = 0;
		String str = "";

		// Get the greater of the two as length of the new number
		int maxLen = Math.max(m, n);

		for (int i = 0; i < maxLen; i++) {

			// Access the last position of the number. It is is greater than the
			// lengtho of that number, assume it to be 0
			int p = i < m ? a.charAt(m - 1 - i) - '0' : 0;
			int q = i < n ? b.charAt(n - 1 - i) - '0' : 0;
			// Add, including carry
			int temp = p + q + carry;
			// Get carry if any
			carry = temp / 2;
			// Get the value at temp at last position and pre-pend it to the
			// current string
			str = temp % 2 + str;
		}
		// If carry present, add 1 before returning
		return (carry == 0) ? str : "1" + str;
	}
}