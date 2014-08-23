package edu.string.justify;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * #LeetCode - https://oj.leetcode.com/problems/text-justification/
 * 
 * @author Shishir Kinkar
 * 
 */
public class JustifyString {

	public List<String> fullJustify(String[] words, int L) {

		List<String> justified = new ArrayList<String>(); // Result
		List<String> eachString = new ArrayList<String>();// Each row

		if (words.length == 0) {
			return justified;
		}

		int currLen = 0;
		int wordCount = 0;

		// Row length needs to be = L
		// Iterate over the words
		for (int i = 0; i < words.length; i++) {

			currLen += words[i].length();
			wordCount++;
			eachString.add(words[i]);
			// If total of words + spaces exceeds L, remove last word, adjust
			// index
			// and justify the row. Once row is added, reset all variables.
			// wordCount - 1 = number of spaces
			if (currLen + wordCount - 1 > L) {
				eachString.remove(eachString.size() - 1);
				i--;
				justify(eachString, justified, L);
				eachString.clear();
				wordCount = 0;
				currLen = 0;
				// If total of words + spaces = L, justify the row. Once row is
				// added,
				// reset all variables.
			} else if (currLen + wordCount - 1 == L) {
				justify(eachString, justified, L);
				eachString.clear();
				wordCount = 0;
				currLen = 0;
				// Total length < L, continue
			} else if (currLen + wordCount - 1 < L) {
				continue;
			}
		}

		// This is the case for the last row, when the total length < L
		// If total length == L, eachString would be of size 0
		if (eachString.size() > 0) {
			String lastRow = "";
			for (String str : eachString) {
				lastRow += str + " ";
			}
			// Pad the row with spaces to justify
			// For cases like ([""], 2)
			while (lastRow.length() < L) {
				lastRow += " ";
			}
			justified.add(lastRow);
		}

		return justified;
	}

	/**
	 * This method justifies the current row.
	 * 
	 * @param currString
	 *            List of words to justify
	 * @param justified
	 *            Result list
	 * @param len
	 *            Length for justification
	 */
	private void justify(List<String> currString, List<String> justified,
			int len) {

		int strLen = 0;
		int numberOfWords = currString.size();

		// Current Length
		for (int i = 0; i < numberOfWords; i++) {
			strLen += currString.get(i).length();
		}

		int totalSpaces = len - strLen;

		// Get an array of appropriate spaces
		String[] spaces = getSpaces(numberOfWords, totalSpaces);

		String justifiedString = "";

		// Compile the string for current row
		for (int i = 0; i < numberOfWords; i++) {

			justifiedString += currString.get(i);

			// Apply available spaces
			if (i < spaces.length) {
				justifiedString += spaces[i];
			}
		}

		// Add string to result
		justified.add(justifiedString);
	}

	/**
	 * Gives back an array of proper sized space strings
	 * 
	 * @param words
	 *            number of words in the row
	 * @param spaces
	 *            total spaces in the row
	 * @return
	 */
	private String[] getSpaces(int words, int spaces) {

		String[] spacesArray = null;
		int spaceCount = words - 1;
		// For one word or one space
		if (words == 1 || spaceCount == 1) {
			spacesArray = new String[1];
			spacesArray[0] = makeSpace(spaces);

			// For more than 1 words
		} else if (words > 1) {
			spacesArray = new String[spaceCount];
			for (int i = 0; i < words - 1; i++) {
				// More spaces first - Hence the use of Math.ceil
				// Type case to float for proper conversion
				spacesArray[i] = makeSpace(Math.ceil((float) spaces / spaceCount));
				spaces -= Math.ceil((float) spaces / spaceCount);
				spaceCount--;
			}
		}

		// Array with proper sized spaces
		return spacesArray;
	}

	/**
	 * A method to create space strings of stated size
	 * 
	 * @param d
	 *            size of string
	 * @return
	 */
	private String makeSpace(double d) {

		String space = " ";
		String spaces = "";
		for (int i = 0; i < d; i++) {
			spaces += space;
		}

		return spaces;
	}

}