package edu.problems.recursive.dp.wordbreak;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	private Map<String, Boolean> myMap = new HashMap<>();

	public boolean wordBreak(String s, Set<String> dict) {

		if (s.length() == 0) {
			return false;
		}

		if (dict.contains(s)) {
			return true;
		}

		// divide the string and check for each substring
		for (int i = 1; i < s.length(); i++) {

			// check for left half substring
			if (!myMap.containsKey(s.substring(0, i))) {
				myMap.put(s.substring(0, i), wordBreak(s.substring(0, i), dict));
			}

			// check for right half substring
			if (!myMap.containsKey(s.substring(i, s.length()))) {
				myMap.put(s.substring(i, s.length()),
						wordBreak(s.substring(i, s.length()), dict));
			}

			// if both substrings are breakable, then the total string is also
			// breakable
			if (myMap.get(s.substring(0, i))
					&& myMap.get(s.substring(i, s.length()))) {
				return true;
			}
		}

		// else the string is not breakable
		return false;
	}
}