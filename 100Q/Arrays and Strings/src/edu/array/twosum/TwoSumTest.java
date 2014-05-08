package edu.array.twosum;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoSumTest {

	TwoSum sumOfTwo = new TwoSum();
	int[] ret = new int[2];
	
	@Test
	public void testOne() {
		int[] numbers = {3,2,4};
		ret = sumOfTwo.twoSum(numbers, 6);
		assertEquals(2, ret[0]);
		assertEquals(3, ret[1]);
	}

	@Test
	public void testTwo() {
		int[] numbers = {1,5,3,7,2,4};
		ret = sumOfTwo.twoSum(numbers, 11);
		assertEquals(4, ret[0]);
		assertEquals(6, ret[1]);
	}
	
	@Test
	public void testThree() {
		int[] numbers = {11,23,45,9,7,3,84,22};
		ret = sumOfTwo.twoSum(numbers, 67);
		assertEquals(3, ret[0]);
		assertEquals(8, ret[1]);
	}
}
