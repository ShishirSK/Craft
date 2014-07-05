package edu.problems.sort.merge;

import java.util.Comparator;

public class MergeSort {

	/*
	 * Public sort method called for sorting the array
	 * 
	 * @param - toBeSorted - array to be sorted
	 */
	public static void sort(Comparable[] toBeSorted) {

		Comparable[] copyArray = new Comparable[toBeSorted.length];
		sort(toBeSorted, copyArray, 0, toBeSorted.length);

	}

	/*
	 * Sort method that is called recursively for sorting the array
	 * 
	 * @param - toBeSorted - array to be sorted
	 * 
	 * @param - copyArray - array to save sorted results
	 * 
	 * @param - low - least value of the passed values
	 * 
	 * @param - high - highest value of the passes values
	 */
	private static void sort(Comparable[] toBeSorted, Comparable[] copyArray,
			int low, int high) {

		if (high <= low)
			return;
		int mid = low + (high - low) / 2;
		sort(toBeSorted, copyArray, low, mid);
		sort(toBeSorted, copyArray, mid + 1, high);
		merge(toBeSorted, copyArray, low, mid, high);
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
				toBeSorted[k] = copyArray[i++];
			else if (less(null, copyArray[j], copyArray[i]))
				toBeSorted[k] = copyArray[j++];
			else
				toBeSorted[k] = copyArray[i++];
		}
	}

	private static boolean less(Comparator<Object> c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}
}
