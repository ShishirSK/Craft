package mergeSort;

import java.util.Comparator;

public class MergeSort {

	public static void sort(@SuppressWarnings("rawtypes") Comparable[] toBeSorted) {

		Comparable[] copyArray = new Comparable[toBeSorted.length];
		sort(toBeSorted, copyArray, 0, toBeSorted.length);

	}

	private static void sort(Comparable[] toBeSorted, Comparable[] copyArray,
			int low, int high) {

		if (high <= low) return;
		int mid = low + (high - low) / 2;
		sort(toBeSorted, copyArray, low, mid);
		sort(toBeSorted, copyArray, mid + 1, high);
		merge(toBeSorted, copyArray, low, mid, high);
	}

	private static void merge(Comparable[] toBeSorted, Comparable[] copyArray, int low, int mid, int high){
		
//		assert isSorted(toBeSorted, low, mid);
		
		for(int k = low; k <= high; k++){
			copyArray[k] = toBeSorted[k];
		}
		
		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++){
			if 	(i > mid) 				toBeSorted[k] = copyArray[j++];
			else if (j > high)			toBeSorted[k] = copyArray[j++];
			else if (less(null, copyArray[j], copyArray[i]))	toBeSorted[k] = copyArray[j++];
			else 						toBeSorted[k] = copyArray[j++];
		}
	}
	
	private static boolean less(Comparator<Object> c, Object v, Object w){ 
		return c.compare(v, w) < 0; 
	}
}
