package tree.datastructure.problems;

public class TreeNode<Key extends Comparable<AnyType>, AnyType> {

	public Key key;
	public AnyType value;
	public TreeNode left, right;

	public TreeNode(Key key, AnyType val) {
		this.key = key;
		this.value = val;
	}
	
}
