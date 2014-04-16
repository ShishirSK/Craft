package tree.datastructure.problems;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArrayToBST {

	ArrayToBST anArray = new ArrayToBST();
	int[] evenLengthArray = { 10, 20, 30, 40, 50, 60, 70, 80 };
	int[] oddLengthArray = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
	TreeNode root;

	@Test
	public void testEvenArrayToBST() {
		root = anArray.getBST(evenLengthArray);
		assertEquals(root.value, 40);
		System.out.println(root.value);
	}

	@Test
	public void testOddArrayToBST() {
		root = anArray.getBST(oddLengthArray);
		assertEquals(root.value, 50);
		System.out.println(root.value);
	}
}
