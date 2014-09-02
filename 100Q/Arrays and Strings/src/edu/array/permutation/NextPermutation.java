package edu.array.permutation;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class NextPermutation {

	public void nextPermutation(int[] num) {

		int len = num.length;
		int pos1 = 0;
		int pos2 = len - 1;

		// Traverse the array
		for (int i = 1; i < len; i++) {
			// Here, find the two indices to swap values at. The aim is to find
			// the least valued second index that is greater in value than the
			// first pivot.
			if (num[pos2] > num[i] && num[i] > num[pos1])
				pos2 = i;
			// If the current value is greater than the previous among adjacent
			// values, update the indices
			if (num[i - 1] < num[i]) {
				pos1 = i - 1;
				pos2 = i;
			}
		}

		// Swap values at the two indices
		int temp = num[pos1];
		num[pos1] = num[pos2];
		num[pos2] = temp;

		// Sort the rest of the array after first index to get min value greater
		// than previous one.
		Arrays.sort(num, pos1 + 1, len);
	}
}