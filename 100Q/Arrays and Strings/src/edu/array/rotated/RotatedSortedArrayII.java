package edu.array.rotated;

/**
 * Write a function to determine if a given target is in the array.
 * 
 * @author Shishir Kinkar
 * 
 */
public class RotatedSortedArrayII {
	public boolean search(int[] A, int target) {

		int high = A.length - 1;
		int low = 0;

		int searchResult = doSearch(A, target, low, high);
		if (searchResult == -1) {
			return false;
		}

		return true;
	}

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
		} else if (a[mid] == a[low]) { // For cases like {1,1,1,1,1,3} where low
										// and mid
										// have the same value
			if (a[mid] != a[high]) {
				return doSearch(a, x, mid + 1, high);
			} else { // For cases like {1,1,1,1,1,2,3,4,1} - search both halves
				int result = doSearch(a, x, mid + 1, high);
				if (result == -1) {
					return doSearch(a, x, low, mid - 1);
				} else {
					return result;
				}
			}
		}
		return -1;
	}
}