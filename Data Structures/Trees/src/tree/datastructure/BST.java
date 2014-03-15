package tree.datastructure;

public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	private class Node {
		private Key key;
		private Value val;
		private Node left, right;

		public void Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}

	}

	public void put(Key key, Value val) {

	}

	/*
	 * Method to get the value of a key from the tree
	 * 
	 * @return value - if key is present, null - if key is not present
	 */
	public Value get(Key checkKey) {

		Node x = root;
		while (x != null) {
			int compareResult = checkKey.compareTo(x.key);
			if (compareResult < 0) {
				x = x.left;
			}
			if (compareResult > 0) {
				x = x.right;
			}
			if (compareResult == 0) {
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
