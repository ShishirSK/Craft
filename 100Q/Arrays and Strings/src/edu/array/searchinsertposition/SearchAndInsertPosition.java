package edu.array.searchinsertposition;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order. You may assume no duplicates in the array. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class SearchAndInsertPosition {

	public int searchInsert(int[] A, int target) {

		if (A.length == 0)
			return 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target)
				return i;
			else if (A[i] > target)
				return i;
			else if (A[i] < target) {
				if (i < A.length - 1 && A[i + 1] > target)
					return i + 1;
				else if (i == A.length - 1)
					return i + 1;
			}
		}
		return -1;
	}

}
