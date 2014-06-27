package edu.array.rotated;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are given a target
 * value to search. If found in the array return its index, otherwise return -1.
 * #LeetCode
 * 
 * Assume there are no duplicate exists in the array.
 * 
 * @author Shishir Kinkar
 * 
 */
public class RotatedSortedArray {
	public int search(int[] A, int target) {

		int high = A.length - 1;
		int low = 0;

		return doSearch(A, target, low, high);
	}

	// Since there is no repetition of digits, even after rotation, one side of
	// the mid-digit would be ordered
	private int doSearch(int[] a, int x, int low, int high) {

		int mid = (high + low) / 2;

		if (a[mid] == x) {
			return mid;
		}

		if (high < low) {
			return -1;
		}

		if (a[low] < a[mid]) { // Left is ordered
			if (x >= a[low] && x <= a[mid]) {
				return doSearch(a, x, low, mid - 1);
			} else {
				return doSearch(a, x, mid + 1, high);
			}
		} else if (a[mid] < a[low]) { // Right is ordered
			if (x >= a[mid] && x <= a[high]) {
				return doSearch(a, x, mid + 1, high);
			} else {
				return doSearch(a, x, low, mid - 1);
			}
		} else if (a[mid] == a[low]) { // For cases like {1,3} where low and mid
										// overlap
			if (a[mid] != a[high]) {
				return doSearch(a, x, mid + 1, high);
			}
		}
		return -1;
	}
}