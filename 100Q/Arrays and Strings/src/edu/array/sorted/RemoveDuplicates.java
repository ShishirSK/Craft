package edu.array.sorted;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class RemoveDuplicates {

	public int remDuplicates(int[] A) {

		int j = 0;

		// For empty array
		if (A.length != 0) {
			A[j] = A[0];
		} else {
			return 0;
		}

		// Replace duplicated element with new element
		for (int i = 0; i < A.length; i++) {
			if (A[j] != A[i]) {
				j++;
				A[j] = A[i];
			}
		}
		// Convert position to length
		return j + 1;
	}
}
