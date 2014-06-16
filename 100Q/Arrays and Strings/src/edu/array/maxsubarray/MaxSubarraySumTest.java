package edu.array.maxsubarray;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSubarraySumTest {

	MaxSubarraySum arr = new MaxSubarraySum();
	
	@Test
	public void test() {
		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		assertEquals(arr.maxSubArray(array), 6);
	}

}
