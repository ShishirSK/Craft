package tree.datastructure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBalancedTree {

	BST<Integer, Integer> unbalancedBST = new BST<Integer, Integer>();

	@Before
	public void addAFewNodes() {

		unbalancedBST.put(50, 50);
		unbalancedBST.put(40, 40);
		unbalancedBST.put(30, 30);
		unbalancedBST.put(20, 20);
		unbalancedBST.put(60, 60);
		unbalancedBST.put(70, 70);
		unbalancedBST.put(80, 80);
		unbalancedBST.put(45, 45);
		unbalancedBST.put(35, 35);
		unbalancedBST.put(42, 42);
		unbalancedBST.put(47, 47);
		unbalancedBST.put(56, 56);
		unbalancedBST.put(55, 55);
		unbalancedBST.put(54, 54);
		unbalancedBST.put(53, 53);
		unbalancedBST.put(52, 52);
		unbalancedBST.put(51, 51);
		unbalancedBST.put(57, 57);
		unbalancedBST.put(65, 65);

	}

	@Test
	public void seeIfBalancedAgain() {
		assertFalse(unbalancedBST.isBalanced());
	}

}
