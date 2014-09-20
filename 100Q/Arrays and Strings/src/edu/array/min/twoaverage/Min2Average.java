package edu.array.min.twoaverage;

/**
 * Given an array of integers, return the average of the least two.
 * 
 * @author Shishir Kinkar
 *
 */
public class Min2Average {

	public double getMinTwoAverage(int[] arr){
		
		if (arr.length == 0){
			return 0;
		} else if (arr.length == 1){
			return arr[0];
		}
		
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length; i++){
			if (arr[i] < first){
				second = first;
				first = arr[i];
			} else if (arr[i] >= first && arr[i] < second){
				second = arr[i];
			}			
		}
		// IMP: Don't forget the explicit conversion 
		double average = 1.0d * (first + second) / 2; 
		return average;
	}
	
}
