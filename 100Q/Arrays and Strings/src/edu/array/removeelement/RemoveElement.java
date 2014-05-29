package edu.array.removeelement;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length. The order of elements can be changed. It doesn't
 * matter what you leave beyond the new length. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {

		if (A.length == 0)
			return 0;

		int newLength = A.length - 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				if (A[newLength] == elem) {
					newLength--;
					i--;
				} else {
					A[i] = A[newLength];
					newLength--;
				}
			}
			if (i >= newLength)
				break;
		}

		if (newLength < -1)
			return 0;
		else
			return newLength + 1;
	}
}
