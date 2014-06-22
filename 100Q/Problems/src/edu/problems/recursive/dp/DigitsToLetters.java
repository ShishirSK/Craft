package edu.problems.recursive.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DigitsToLetters {

	public List<String> letterCombinations(String digits) {

		HashMap<String, String> digitsNLetters = new HashMap<String, String>();
		digitsNLetters.put("2", "abc");
		digitsNLetters.put("3", "def");
		digitsNLetters.put("4", "ghi");
		digitsNLetters.put("5", "jkl");
		digitsNLetters.put("6", "mno");
		digitsNLetters.put("7", "pqrs");
		digitsNLetters.put("8", "tuv");
		digitsNLetters.put("9", "wxyz");

		ArrayList<String> combos = new ArrayList<String>();

		if (digits == null) {
			return null;
		} else if (digits.length() == 0) {
			combos.add("");
			return combos;
		}

		int numberOfLetters = digits.length();
		String[] letters = new String[numberOfLetters];

		// Create array of letters corresponding to digits
		for (int i = 0; i < numberOfLetters; i++) {
			letters[i] = digitsNLetters.get(digits.substring(i, i + 1));
		}
		getCombinations(combos, letters);

		// The increment is done conditionally as removing the arraylist element
		// re-arranges the indices. Increment is needed as elements are not
		// sorted, and there might be elements of smaller length in the list.
		String current;
		for (int i = 1; i <= combos.size();) {
			current = combos.get(i - 1);
			if (current.length() < numberOfLetters) {
				combos.remove(i - 1);
			} else if (i <= combos.size()) {
				i++;
			} else {
				break;
			}
		}
		return combos;
	}

	// Recursively creates combinations of the letters
	public static void getCombinations(ArrayList<String> combos,
			String[] letters) {

		String secondString;
		String firstString;
		String firstChar, secondChar;
		if (letters.length <= 0) {
			return;
		} else if (letters.length == 1) {
			firstString = letters[0];
			for (int k = 0; k < firstString.length(); k++) {
				firstChar = firstString.substring(k, k + 1);
				combos.add(firstChar);
			}
		} else {
			String[] letArray = new String[letters.length - 1];
			for (int i = 0; i < letArray.length; i++) {
				letArray[i] = letters[i];
			}
			getCombinations(combos, letArray);

			int currentCombos = combos.size();
			secondString = letters[letters.length - 1];
			for (int j = 0; j < secondString.length(); j++) {
				secondChar = secondString.substring(j, j + 1);
				for (int k = 0; k < currentCombos; k++) {
					combos.add(combos.get(k) + secondChar);
				}
			}
		}
	}
}