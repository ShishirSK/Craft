package edu.array.min.twoaverage;

import static org.junit.Assert.*;

import org.junit.Test;

public class Min2AverageTest {

	Min2Average anInstance = new Min2Average();

	@Test
	public void EdgeCase1() {
		int[] arr = {};
		assertTrue(anInstance.getMinTwoAverage(arr) == 0);
	}

	@Test
	public void EdgeCase2() {
		int[] arr = { 5 };
		assertTrue(anInstance.getMinTwoAverage(arr) == 5);
	}

	@Test
	public void EdgeCase3() {
		int[] arr = { -2 };
		assertTrue(anInstance.getMinTwoAverage(arr) == -2);
	}

	@Test
	public void Case1() {
		int[] arr = { 2, 4 };
		assertTrue(anInstance.getMinTwoAverage(arr) == 3);
	}

	@Test
	public void Case2() {
		int[] arr = { -2, -5 };
		assertTrue(anInstance.getMinTwoAverage(arr) == -3.5);
	}

	@Test
	public void Case3() {
		int[] arr = { 7, 2, 4, 6, 9, -2, -4, 0, -2, -8, 11, 17, -3 };
		assertTrue(anInstance.getMinTwoAverage(arr) == -6);
	}

}
