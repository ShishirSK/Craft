package edu.array.maxpathsum;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxPathSumTest {

	MaxPathSum anInstance = new MaxPathSum();

	@Test
	public void test() {
		int[] A = { 10, 12 };
		int[] B = { 5, 7, 9 };

		assertEquals(anInstance.getmaxPathSum(A, B), 22);

	}

	@Test
	public void test2() {
		int[] A = { 2, 3, 7, 10, 12 };
		int[] B = { 1, 5, 7, 8 };

		assertEquals(anInstance.getmaxPathSum(A, B), 35);
	}

	@Test
	public void test3() {
		int[] A = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int[] B = { 1, 5, 7, 8, 10, 15, 16, 19 };

		assertEquals(anInstance.getmaxPathSum(A, B), 122);
	}
}
