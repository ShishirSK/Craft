package edu.array.removeDuplicates;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory.
 * 
 * What if duplicates are allowed at most twice? #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] A) {

		boolean aDup = false; // Flag for one duplicate
		int j = 0;
		if (A.length != 0) {
			A[j] = A[0];
		} else
			return 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1] && aDup == false) {
				j++;
				A[j] = A[i];
				aDup = true; // One duplicate considered
			}

			if (A[j] != A[i]) {
				j++;
				A[j] = A[i];
				aDup = false;
			}
		}
		return j + 1;
	}

}
