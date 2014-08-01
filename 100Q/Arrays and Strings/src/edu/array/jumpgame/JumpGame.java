package edu.array.jumpgame;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your MAXIMUM jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class JumpGame {

	public boolean canJump(int[] A) {

		// If first value is same as length, last index is reachable
		if (A.length == 0 || A.length == A[0])
			return true;

		int lastPosition = A.length - 1; // Index to reach

		int maxIndex = A[0]; // Maximum index reachable (yet)

		for (int i = 0; i < A.length;) {

			int indexIncrement = A[i]; // Increment in reach from this position

			// Current Position is maxIndex reachable, no increment and it is
			// not the last postion yet. Return false.
			if (indexIncrement == 0 && i == maxIndex && maxIndex < lastPosition) {
				return false;
			}

			// Update the maxIndex reachable
			maxIndex = maxIndex >= i + indexIncrement ? maxIndex : i
					+ indexIncrement;
			i++; // Go to next index

			// If you can reach last postion or ahead of it, return true
			if (maxIndex >= lastPosition)
				return true;
			else
				// Go on to the next index
				continue;

		}

		return false;
	}
}