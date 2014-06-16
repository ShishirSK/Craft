package edu.array.maxsubarray;

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
