package edu.array.sorted;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class MergeSorted {

	public void merge(int A[], int m, int B[], int n) {

		if (n == 0) {
			return;
		}

		if (m == 0) {
			for (int i = 0; i < n; i++) {
				A[i] = B[i];
			}
			return;
		}
		int aLast = m - 1;
		int bLast = n - 1;
		int mergedLength = m + n - 1;

		while (aLast >= 0 && bLast >= 0) {
			if (A[aLast] > B[bLast]) {
				A[mergedLength--] = A[aLast--];
			} else {
				A[mergedLength--] = B[bLast--];
			}
		}

		while (bLast >= 0) {
			A[mergedLength--] = B[bLast--];
		}
	}
}