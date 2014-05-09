package edu.tree.sortedarraytotree;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeNodeTest {

	ArrayToBST anArray = new ArrayToBST();
	int[] evenLengthArray = { 10, 20, 30, 40, 50, 60, 70, 80 };
	int[] oddLengthArray = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
	TreeNode root;

	@Test
	public void testEvenArrayToBST() {
		root = anArray.sortedArrayToBST(evenLengthArray);
		assertEquals(root.val, 40);
		System.out.println(root.val);
	}

	@Test
	public void testOddArrayToBST() {
		root = anArray.sortedArrayToBST(oddLengthArray);
		assertEquals(root.val, 50);
		System.out.println(root.val);
	}

}
