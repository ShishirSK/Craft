package edu.array.singlenumber;

import java.util.HashSet;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one. Note: The algorithm should have a linear runtime complexity.
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class SingleNumber {

	public int singleNumber(int[] A) {
		HashSet<Integer> singleInt = new HashSet<Integer>();
		int number = 0;
		for (int i = 0; i < A.length; i++) {
			if (singleInt.add(A[i])) {
				number += A[i];
			} else {
				number -= A[i];
			}
		}
		return number;
	}
}
