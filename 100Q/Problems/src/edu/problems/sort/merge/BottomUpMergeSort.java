package edu.problems.sort.merge;

import java.util.Comparator;

/**
 * Another approach to doing merge sort
 * 
 * @author Shishir Kinkar
 *
 */
public class BottomUpMergeSort {

	/*
	 * Non-iterative method for merge sort
	 * 
	 * @param - toBeSorted - array to be sorted
	 */
	public static void sort(Comparable[] toBeSorted) {
		int n = toBeSorted.length;
		Comparable[] copyArray = new Comparable[n];

		for (int size = 1; size < n; size = size + size) {
			for (int lo = 0; lo < n - size; lo += size + size) {
				merge(toBeSorted, copyArray, lo, lo + size - 1,
						Math.min(lo + size + size - 1, n - 1));
			}
		}
	}

	/*
	 * Method to merge two individual sorted halves of an array
	 * 
	 * @param - toBeSorted - array to be sorted
	 * 
	 * @param - copyArray - array to save sorted results
	 * 
	 * @param - low - least value of the passed values
	 * 
	 * @param - mid - mid value of the passes values
	 * 
	 * @param - high - highest value of the passes values
	 */
	private static void merge(Comparable[] toBeSorted, Comparable[] copyArray,
			int low, int mid, int high) {

		for (int k = low; k <= high; k++) {
			copyArray[k] = toBeSorted[k];
		}

		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid)
				toBeSorted[k] = copyArray[j++];
			else if (j > high)
				toBeSorted[k] = copyArray[j++];
			else if (less(null, copyArray[j], copyArray[i]))
				toBeSorted[k] = copyArray[j++];
			else
				toBeSorted[k] = copyArray[j++];
		}
	}

	/*
	 * Method to compare two objects
	 * 
	 * @return boolean
	 */
	private static boolean less(Comparator<Object> c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}

}
