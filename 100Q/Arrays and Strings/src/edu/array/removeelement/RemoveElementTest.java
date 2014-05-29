package edu.array.removeelement;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveElementTest {

	RemoveElement testArray = new RemoveElement();

	@Test
	public void oneElementArray() {
		int[] a = { 1 };
		assertEquals(testArray.removeElement(a, 1), 0);
	}

	@Test
	public void twoElementArray() {
		int[] a = { 3, 3 };
		assertEquals(testArray.removeElement(a, 3), 0);
	}

	@Test
	public void threeElementArray() {
		int[] a = { 2, 2, 3 };
		assertEquals(testArray.removeElement(a, 2), 1);
	}

	@Test
	public void otherThreeElementArray() {
		int[] a = { 2, 2, 2 };
		assertEquals(testArray.removeElement(a, 2), 0);
	}

	@Test
	public void simpleArray() {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertEquals(testArray.removeElement(a, 10), 10);
	}

	@Test
	public void oneRepeatElement() {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 0, 9 };
		assertEquals(testArray.removeElement(a, 0), 8);
	}

}
