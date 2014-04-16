package tree.datastructure.problems;

public class ArrayToBST {

	public TreeNode getBST(int[] array) {
		TreeNode root = getBST(array, 0, array.length - 1);
		return root;
	}

	@SuppressWarnings("unchecked")
	private TreeNode getBST(int[] arr, int start, int end) {

		if (end < start)
			return null;
		
		int mid = (int)(start + end) / 2;
		TreeNode n = new TreeNode(arr[mid], arr[mid]);
		n.left = getBST(arr, start, mid - 1);
		n.right = getBST(arr, mid + 1, end);
		return n;
	}
}