package edu.string.fuzzymatching;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a source string and a target string, find if the source string has a
 * fuzzy match with the target string.
 * 
 * @author Shishir Kinkar
 * 
 */
public class FuzzyStringMatching {

	public boolean matchString(String target, String source) {

		// Use a queue to store the characters from the target string
		Deque<Character> original = new LinkedList<Character>();

		for (int i = 0; i < target.length(); i++) {
			original.offer(target.charAt(i));
		}

		int j = 0;

		// For each character of source string, check if it is present in the
		// queue in fuzzy-sequential manner
		while (j < source.length()) {

			if (!original.isEmpty()) // Null check
				if (source.charAt(j) == original.peek()) {
					// Character found. Increment both string positions
					j++;
					original.poll();
				} else {
					// Character not found. Just move to next target character
					original.poll();
				}
			else {
				return false;
			}

		}
		return true;
	}

}
