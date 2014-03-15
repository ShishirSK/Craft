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

	public Value get(Key key) {
		return null;
	}

	public boolean delete(Key key) {
		return false;
	}

	public Iterable<Key> iterator() {
		return null;
	}
}
