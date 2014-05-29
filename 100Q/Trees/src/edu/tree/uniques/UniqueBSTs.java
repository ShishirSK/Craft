package edu.tree.uniques;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n? #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 *         Resources: http://cs.lmu.edu/~ray/notes/binarytrees/
 *         http://en.wikipedia.org/wiki/Catalan_numbers
 * 
 */
public class UniqueBSTs {

	public int numTrees(int n) {

		if (n == 0 || n == 1 || n == 2) {
			return n;
		}
		int result = 2;
		for (int i = 3; i <= n; i++) {
			result = result * 2 * (2 * i - 1) / (i + 1);
		}
		return result;
	}

}
