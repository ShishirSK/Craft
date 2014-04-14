package tree.datastructure;

/*
 * A binary search tree implementation 
 * 
 * @author Shishir Kinkar
 * 
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
		private int visited = 0;

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

	/*
	 * Method to get the value of a key from the tree
	 * 
	 * @return value - if key is present, null - if key is not present
	 * 
	 * @param checkKey - key to check
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

	/*
	 * Method to return the minimum value in the tree
	 * 
	 * @return Value - value of the min node
	 */
	public Value min() {

		Node currentNode = root;
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode.val;
	}

	/*
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

	public boolean delete(Key key) {
		return false;
	}

	public Iterable<Key> iterator() {
		return null;
	}

	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(Node x) {

		if (x.left == null && x.right == null) {
			System.out.println(x.val + " ");
			x.visited = 1;
			return;
		}

		if (x.left == null) {
			System.out.println(x.val + " ");
		} else {
			inOrder(x.left);
			System.out.println(x.val + " ");
		}

		if (x.right == null) {
			System.out.println(x.val + " ");
		} else {
			inOrder(x.right);
//			System.out.println(x.val + " ");
		}
		return;
	}
}