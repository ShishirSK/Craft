package edu.string.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class GroupAnagrams {

	public List<String> anagrams(String[] strs) {

		ArrayList<String> anagramList = new ArrayList<String>();

		if (strs.length == 0) {
			return anagramList;
		}

		HashMap<String, ArrayList<String>> angs = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < strs.length; i++) {
			char[] currStr = strs[i].toCharArray();

			// IMP - Arrays.sort sorts the passed object and does not return
			// sorted array
			Arrays.sort(currStr);
			String sortedStr = String.valueOf(currStr);

			// If present in map, add to the value arraylist
			if (angs.containsKey(sortedStr)) {
				(angs.get(sortedStr)).add(strs[i]);
			} else {
				// Create a new entry
				ArrayList<String> anagrams = new ArrayList<String>();
				anagrams.add(strs[i]);
				angs.put(sortedStr, anagrams);
			}
		}

		// HashMap is not iterable. Get a keyset and iterate over it.
		Set<String> keys = angs.keySet();
		for (String str : keys) {
			// Only groups of anagrams are needed. So a single string is not
			// added
			if (angs.get(str).size() > 1)
				anagramList.addAll(angs.get(str));
		}

		return anagramList;
	}
}
