package edu.array.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class Subsets {

	public List<ArrayList<Integer>> subsets(int[] S) {

		List<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();

		// Empty subset
		subsets.add(new ArrayList<Integer>());

		// Always return an empty subset - []
		if (S.length == 0) {
			return subsets;
		}

		// To meet the ascending order condition
		Arrays.sort(S);

		// For the current integer value
		for (int i = 0; i < S.length; i++) {
			// This variable in need to keep tab on the count of subsets before
			// you start adding new subsets to the same arraylist
			int subsetCount = subsets.size();
			// Add it to all the subsets
			for (int j = 0; j < subsetCount; j++) {
				// Make a copy of the current subset
				ArrayList<Integer> newSet = (ArrayList<Integer>) subsets.get(j).clone();
				// Add current integer to it.
				newSet.add(S[i]);
				// Add it to the final arraylist
				subsets.add(newSet);
			}
		}

		return subsets;
	}
}