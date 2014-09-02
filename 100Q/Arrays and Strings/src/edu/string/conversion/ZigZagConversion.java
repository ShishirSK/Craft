package edu.string.conversion;

/**
 * Return a zigzag pattern on a given number of rows #LeetCode
 * 
 * Refer: https://oj.leetcode.com/problems/zigzag-conversion/
 * 
 * @author Shishir
 * 
 */
public class ZigZagConversion {

	public String convert(String s, int nRows) {

		// Base checks
		if (s == null || s.length() == 0 || nRows <= 1)
			return s;

		String str = "";
		// Increment to locate the next position to append for all rows
		int zig = 2 * (nRows - 1);
		// Increment to locate the additional positions to append for all rows
		// except the first and last one
		int zag = zig;

		// Travese and form rows.
		for (int i = 0; i < nRows; i++) {
			// Traverse the string
			for (int j = i; j < s.length(); j += zig) {

				// Character to be appended to all rows
				str += s.charAt(j);
				// Additional characters for all rows except first and last
				// Ensure the current row is not the first, the position is less
				// than the string length, and that it is not the last row.
				if (zig > zag && (j + zag) < s.length() && zag > 0)
					str += s.charAt(j + zag);

			}
			// Decrement the location increment for the next row
			zag -= 2;
		}

		return str;
	}
}