package edu.ds.tree;


public class TreeNode<Key extends Comparable<AnyType>, AnyType> {

	public int val;
	public Key key;
	public AnyType value;
	public TreeNode left, right;

	public TreeNode(Key key, AnyType val) {
		this.key = key;
		this.value = val;
	}
	
}