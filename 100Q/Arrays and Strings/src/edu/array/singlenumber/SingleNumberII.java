package edu.array.singlenumber;

import java.util.HashSet;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class SingleNumberII {

	public int singleNumber(int[] A) {

		HashSet<Integer> nums = new HashSet<Integer>();
		int number = 0;
		for (int i = 0; i < A.length; i++) {
			if (nums.add(A[i])) {
				number += A[i];
			} else {
				number -= (2 * A[i]);
				nums.remove(A[i]);
			}
		}
		return number;
	}
}
