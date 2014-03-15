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

	/*
	 * Overloaded method to put nodes into a BST
	 * 
	 * @return Node - returns a node object
	 * 
	 * @param currentNode - current node object, pKey - key of the node, pVal -
	 * value of the node
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

	public boolean delete(Key key) {
		return false;
	}

	public Iterable<Key> iterator() {
		return null;
	}
}
