package edu.array.matrixzeroes;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class SetMatrixZeros {

	public void setZeroes(int[][] matrix) {

		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

}
