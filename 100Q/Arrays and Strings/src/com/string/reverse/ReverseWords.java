package com.string.reverse;

/**
 * Given an input string, reverse the string word by word. #Leetcode 
 * Edge cases:
 * 1. Reversed string should not contain leading or trailing spaces. 
 * 2. Reduce multiple spaces to a single space in the reversed string.
 * 
 * @author Shishir Kinkar
 * 
 */
public class ReverseWords {

	public String reverseWords(String s) {

		if (s.length() == 0) // edge case for empty string
			return s;

		StringBuilder newString = new StringBuilder();
		String filteredString = null;
		char prev = ' ';
		int j = 0;

		char[] chars = s.toCharArray();
		char[] filteredChars = new char[chars.length];
		// Remove multiple consecutive spaces.
		for (int i = 0; i < chars.length; i++) {
			if (prev == ' ' && chars[i] == ' ') {
				continue;
			} else {
				filteredChars[j] = chars[i];
				j++;
				prev = chars[i];
			}
		}

		filteredString = String.valueOf(filteredChars);
		String[] words = filteredString.trim().split(" ");
		// Construct new string from the string array
		for (int i = words.length - 1; i >= 0; i--) {
			newString.append(words[i]);
			if (i != 0)
				newString.append(" ");
		}
		return newString.toString();
	}
}
