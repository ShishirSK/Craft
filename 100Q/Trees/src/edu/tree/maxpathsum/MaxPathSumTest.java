package edu.tree.maxpathsum;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.tree.sortedarraytotree.TreeNode;

public class MaxPathSumTest {

	MaxPathSum anInstance = new MaxPathSum();
//	@Test
//	public void test() {
//		TreeNode root = new TreeNode(2);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(3);
//		
//		assertEquals(anInstance.maxPathSum(root), 6);
//	}
//
//	
//	@Test
//	public void test2() {
//		TreeNode root = new TreeNode(-3);
////		root.left = new TreeNode(1);
////		root.right = new TreeNode(3);
//		
//		assertEquals(anInstance.maxPathSum(root), -3);
//	}
	
	@Test
	public void test3() {
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(-1);
		
		assertEquals(anInstance.maxPathSum(root), -1);
	}
}
