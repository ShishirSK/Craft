package edu.string.commonprefix;

import java.util.Arrays;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		// Return empty string for empty array
		if (strs.length == 0) {
			return "";
		}

		// Sort
		Arrays.sort(strs);
		// See which string amongst first and last one is shorter and longer
		String shorter = strs[0].length() <= strs[strs.length - 1].length() ? strs[0]
				: strs[strs.length - 1];
		String longer = strs[0].length() > strs[strs.length - 1].length() ? strs[0]
				: strs[strs.length - 1];

		int prefixLength = 0;
		int currLength = 0;
		// Check for same prefix in the first and last strings of the sorted
		// array
		while (true) {
			// max common prefix is the shorter of the two strings
			if (currLength < shorter.length()) {
				// if chars at currLenght are same, increase prefix size.
				if (shorter.charAt(currLength) == longer.charAt(currLength)) {
					currLength++;
					prefixLength++;
				} else { // When characters are not same
					break;
				}
			} else { // When currLength = shorter string length
				break;
			}
		}

		return shorter.substring(0, prefixLength);
	}
}
