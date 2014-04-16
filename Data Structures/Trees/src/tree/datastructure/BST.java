package tree.datastructure;

/**
 * A binary search tree implementation. Also includes solutions to some problems
 * based on the Tree data structure
 * 
 * @author Shishir Kinkar
 * 
 * @param <Key>
 *            - Key of the node
 * @param <Value>
 *            - Value of the node
 */
public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	/*
	 * Definition of a tree node
	 */
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;

		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}

	/*
	 * Method to put nodes into a BST
	 * 
	 * @return void - does not return a value
	 * 
	 * @param Key - key of the node, Val - value of the node
	 */
	public void put(Key Key, Value Val) {
		root = put(root, Key, Val);
	}

	/**
	 * Overloaded method to put nodes into a BST
	 * 
	 * @param currentNode
	 *            - current node object
	 * @param pKey
	 *            - key of the node
	 * @param pVal
	 *            - value of the node
	 * @return Node - returns a node object
	 */
	private Node put(Node currentNode, Key pKey, Value pVal) {

		if (currentNode == null)
			return new Node(pKey, pVal);
		int compareNode = pKey.compareTo(currentNode.key);
		if (compareNode < 0) {
			currentNode.left = put(currentNode.left, pKey, pVal);
		} else if (compareNode > 0) {
			currentNode.right = put(currentNode.right, pKey, pVal);
		} else {
			currentNode.val = pVal;
		}
		return currentNode;
	}

	/**
	 * Method to get the value of a key from the tree
	 * 
	 * @param checkKey
	 *            - key to check
	 * @return value - if key is present null - if key is not present
	 */
	public Value get(Key checkKey) {

		Node x = root;
		while (x != null) {
			int compareResult = checkKey.compareTo(x.key);
			if (compareResult < 0) {
				x = x.left;
			} else if (compareResult > 0) {
				x = x.right;
			} else {
				return x.val;
			}
		}
		return null;
	}

	/**
	 * Method to return the minimum value in the tree
	 * 
	 * @return Value - value of the minimum node
	 */
	public Value min() {

		Node currentNode = root;
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode.val;
	}

	/**
	 * Method to return the maximum value in the tree
	 * 
	 * @return Value - value of the max node
	 */
	public Value max() {

		Node currentNode = root;
		while (currentNode.right != null) {
			currentNode = currentNode.right;
		}
		return currentNode.val;
	}

	// public boolean delete(Key key) {
	// return false;
	// }
	//
	// public Iterable<Key> iterator() {
	// return null;
	// }

	/**
	 * Traverse the tree in-order and show node values
	 */
	public void inOrder() {
		System.out.println("In-order values of tree nodes: ");
		inOrder(root);
	}

	/**
	 * Overloaded method for in-order tree traversal
	 * 
	 * @param x
	 *            - Node
	 */
	private void inOrder(Node x) {

		if (x.left == null && x.right == null) {
			System.out.print(x.val + " ");
			return;
		}
		if (x.left == null)
			System.out.print(x.val + " ");
		else {
			inOrder(x.left);
			System.out.print(x.val + " ");
		}
		if (x.right == null)
			System.out.print(x.val + " ");
		else
			inOrder(x.right);
		return;
	}

	/**
	 * Traverse the tree in pre-order and show node values
	 */
	public void preOrder() {
		System.out.println("Pre-ordered values of tree nodes: ");
		preOrder(root);
	}

	/**
	 * Overloaded method for in pre-order tree traversal
	 * 
	 * @param x
	 *            - Node
	 */
	private void preOrder(Node x) {
		System.out.print(x.val + " ");
		if (x.left == null && x.right == null)
			return;
		if (x.left != null)
			preOrder(x.left);
		if (x.right != null)
			preOrder(x.right);
		return;
	}

	/**
	 * Traverse the tree in post-order and show node values
	 */
	public void postOrder() {
		System.out.println("Post-ordered values of tree nodes: ");
		postOrder(root);
	}

	/**
	 * Overloaded method for in post-order tree traversal
	 * 
	 * @param x
	 *            - Node
	 */
	private void postOrder(Node x) {

		if (x.left == null && x.right == null) {
			System.out.print(x.val + " ");
			return;
		}
		if (x.left != null)
			postOrder(x.left);
		if (x.right != null)
			postOrder(x.right);
		System.out.print(x.val + " ");
		return;
	}

	//
	/**
	 * Check that the tree is balanced
	 * 
	 * Balanced (according to the problem definition) means that the height of
	 * any of the subtrees of the tree-node should not be greater than one
	 * 
	 * @return boolean - whether tree is balanced or not
	 */
	public boolean isBalanced() {
		int height = 0;
		height = getHeight(root);
		if (height == -1)
			return false;
		else
			return true;
	}

	/**
	 * Method to return the height of the tree and tell if it is unbalanced.
	 * Returns the height of the tree otherwise
	 * 
	 * @param x
	 *            - Node
	 * @return - int - Height or -1
	 */
	private int getHeight(Node x) {

		if (x == null)
			return 0;

		// Left branch
		int lHeight = getHeight(x.left);
		if (lHeight == -1)
			return lHeight;

		// Right branch
		int rHeight = getHeight(x.right);
		if (rHeight == -1)
			return rHeight;

		int heightDiff = lHeight - rHeight;
		// Parameter to control allowed difference
		if (Math.abs(heightDiff) > 1) {
			System.out.println("Height Difference: " + heightDiff);
			return -1;
		} else {
			// System.out.println("Height of tree: " + (Math.max(lHeight,
			// rHeight) + 1)); // For checking tree height
			return Math.max(lHeight, rHeight) + 1;
		}

	}
}
