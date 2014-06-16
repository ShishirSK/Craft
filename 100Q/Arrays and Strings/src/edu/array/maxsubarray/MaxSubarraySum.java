package edu.array.maxsubarray;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum. For example, given the array
 * [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest
 * sum = 6. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class MaxSubarraySum {
	public int maxSubArray(int[] A) {

		if (A.length == 0) {
			return 0;
		}

		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}

		// If all are negative, return max negative
		if (max < 0) {
			return max;
		} else {
			int currentMax = 0;
			for (int j = 0; j < A.length; j++) {
				currentMax += A[j];
				if (currentMax < 0) {
					currentMax = 0;
				} else if (currentMax > max) {
					max = currentMax;
				}
			}
		}
		System.out.println(max);
		return max;
	}
}
