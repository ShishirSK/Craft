package quickSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class QuickSort {

	/*
	 * Method to shuffle array and call the recursive call method
	 * 
	 * @param - a Comparable array to sort
	 */
	public static void sort(Comparable[] arrayToSort) {

		Collections.shuffle(Arrays.asList(arrayToSort));
		sort(arrayToSort, 0, arrayToSort.length);
	}

	/*
	 * Recursively called method for sorting
	 * 
	 * @param - a Comparable array to sort
	 * 
	 * @param - starting position of array to be sorted
	 * 
	 * @param - ending position of array to be sorted
	 */
	private static void sort(Comparable[] arrayToSort, int lo, int hi) {

		if (hi <= lo)
			return;
		int j = partition(arrayToSort, lo, hi);
		sort(arrayToSort, lo, j - 1);
		sort(arrayToSort, j + 1, hi);

	}

	/*
	 * Private method to partition the given array around a pivot at low
	 * position
	 * 
	 * @param - a Comparable array to sort
	 * 
	 * @param - starting position of array to be sorted
	 * 
	 * @param - ending position of array to be sorted
	 */
	private static int partition(Comparable[] a, int lo, int hi) {

		int i = lo, j = hi;
		while (true) {

			while (less(a[++i], a[lo]))
				if (i == hi)
					break;

			while (less(a[lo], a[--j]))
				if (j == lo)
					break;

			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	/*
	 * Method to exchange position of values in two places in the array
	 * 
	 * @param - a Comparable array to exchange the values in
	 * 
	 * @param - first position in array to be swapped
	 * 
	 * @param - second position in array to be swapped
	 */
	private static void exch(Comparable[] a, int i, int j) {

		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/*
	 * Method that compares objects and returns boolean value
	 * 
	 * @param - first object to be compared
	 * 
	 * @param - second object to be compared
	 */
	private static boolean less(Object v, Object w) {
		Comparator<Object> c = null;
		return c.compare(v, w) < 0;
	}
}
