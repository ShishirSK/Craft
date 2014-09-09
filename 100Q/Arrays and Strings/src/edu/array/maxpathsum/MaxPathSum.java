package edu.array.maxpathsum;

/**
 * Given two sorted arrays such the arrays may have some common elements. Find
 * the sum of the maximum sum path to reach from beginning of any array to end
 * of any of the two arrays. We can switch from one array to another array only
 * at common elements.
 * 
 * Expected time complexity is O(m+n) where m is the number of elements in ar1[]
 * and n is the number of elements in ar2[].
 * 
 * Ref: http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
 * 
 * @author Shishir Kinkar
 * 
 */
public class MaxPathSum {

	public int getmaxPathSum(int[] A, int[] B) {

		int m = A.length;
		int n = B.length;
		int i = 0, j = 0, result = 0;
		int sum1 = 0, sum2 = 0;

		// The idea is to do sum of values in the array by the index. If value
		// in A[] is lesser, add it to sum1, and increment the index i. If value
		// in B[] is lesser, add it to sum1, and increment the index j. If the
		// values are same, add the max of those values to the result. Then add
		// the current position. Continue.

		while (i < m && j < n) {

			if (A[i] < B[j]) { // Value in A[] is lesser
				sum1 += A[i++];
			} else if (A[i] > B[j]) { // Value in B[] is lesser
				sum2 += B[j++];
			} else if (A[i] == B[j]) { // Value in A[] and B[] are equals for
										// the index

				result += Math.max(sum1, sum2); // Take Max
				result += A[i++]; // Add current value. Increment both indices
				j++;

				// Reset array sums
				sum1 = 0;
				sum2 = 0;

				// For the case of repeat same values
				while (i < m && j < n && A[i] == B[j]) {
					result += A[i++];
					j++;
				}
			}
		}

		// Make sure end of array A is reached
		while (i < m) {
			sum1 += A[i++];
		}
		// Make sure end of array B is reached
		while (j < n) {
			sum2 += B[j++];
		}

		// Update final total
		result += Math.max(sum1, sum2);
		return result;
	}

}
