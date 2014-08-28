package edu.problems.recursive.combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination must be in non-descending order. The solution set must not
 * contain duplicate combinations.
 * 
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class CombinationSum {

	List<List<Integer>> combos = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		getCombos(candidates, target, 0, new ArrayList<Integer>());
		return combos;
	}

	/**
	 * Recursively called function to get combinations
	 * 
	 * @param arr
	 *            array of numbers
	 * @param target
	 *            target
	 * @param sum
	 *            sum of numbers in current list
	 * @param aCombo
	 *            current list
	 */
	private void getCombos(int[] arr, int target, int sum, ArrayList<Integer> aCombo) {

		// If sum of the numbers in current combo == target
		if (sum == target) {
			// Clone
			ArrayList<Integer> oneCombo = (ArrayList<Integer>) aCombo.clone();
			// Sort
			Collections.sort(oneCombo);
			// Check if already added
			if (combos.contains(oneCombo)) {
				return;
			} else { // If not present, add
				combos.add(oneCombo);
			}
			return;
		}

		// For all elements in the array
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			// Recursive calls as long as sum <= target
			if (sum <= target) {
				// Add to current combination and recurse
				aCombo.add(arr[i]);
				getCombos(arr, target, sum, aCombo);
				// Remove most recently added number to try combination with the
				// next number in the loop
				aCombo.remove(aCombo.size() - 1);
			}
			// Update sum to add the next number
			sum -= arr[i];
		}
	}
}