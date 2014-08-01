package edu.problems.numerical.readout;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class ReadOutNthNumber {

	public String countAndSay(int n) {

		if (n < 0)
			return "";

		String result = "1"; // base case
		for (int i = 1; i < n; i++) { // Go till (n - 1)th iteration
			StringBuilder strBuilder = new StringBuilder();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				// Compare this character to previous one
				if (result.charAt(j) == result.charAt(j - 1)) {
					count++;
				} else { // Construct the part of the sequence
					strBuilder.append(count);
					strBuilder.append(result.charAt(j - 1));
					count = 1;
				}
			}
			// Construct the end part of the sequence, as else is skipped when
			// loop breaks
			strBuilder.append(count);
			strBuilder.append(result.charAt(result.length() - 1));
			result = strBuilder.toString();
		}
		return result;
	}
}
