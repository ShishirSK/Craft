package edu.array.twosum;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {

		int[] retVals = new int[2];
		// Put the difference of the target and the value as a key in a HashMap
		// with the index as value. While looping ahead, see if the current
		// array value is present in the HashMap. If yes, get the indices!
		HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (values.containsKey(numbers[i])) {
				retVals[0] = values.get(numbers[i]) + 1;
				retVals[1] = i + 1;
			} else {
				values.put(target - numbers[i], i);
			}
		}
		return retVals;
	}
}
