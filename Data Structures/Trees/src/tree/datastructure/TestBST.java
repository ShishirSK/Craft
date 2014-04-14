package tree.datastructure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBST {

	BST<Integer,Integer> bst = new BST<Integer, Integer>();
	
	@Before
	public void addAFewNodes() {
		
		bst.put(50, 50);
		bst.put(40, 40);
		bst.put(30, 30);
		bst.put(20, 20);
		bst.put(60, 60);
		bst.put(70, 70);
		bst.put(80, 80);
		bst.put(70, 70);
		bst.put(35, 35);
		bst.put(45, 45);
		bst.put(42, 42);
		bst.put(47, 47);
		bst.put(55, 55);
		bst.put(52, 52);
		bst.put(57, 57);
		bst.put(65, 65);
		
	}
	
	@Test
	public void getMin(){
		int minVal = bst.min();
		assertEquals(minVal,20);
	}

	@Test
	public void getMax(){
		int maxVal = bst.max();
		assertEquals(maxVal,80);
	}	
	
	@Test
	public void inOrder(){
		System.out.println();
		bst.inOrder();
	}
	
	@Test
	public void preOrder(){
		bst.preOrder();
	}
	
	@Test
	public void postOrder(){
		System.out.println();
		bst.postOrder();
	}
}
