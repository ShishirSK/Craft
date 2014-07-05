package edu.array.rotatematrix;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * @author Shishir Kinkar
 * 
 */
public class RotateMatrix {

	public void rotate(int[][] matrix) {

		int n = matrix.length;
		if (n == 0 || n == 1) {
			return;
		}

		// Go layer by layer from outside.
		for (int layer = 0; layer < n / 2; layer++) {

			int first = layer;
			int last = n - 1 - layer;

			// Go by position of the block in the layer.
			for (int i = first; i < last; i++) {
				// Offset is the differene of the current block from start of
				// layer
				int offset = i - first;

				// Top is top-left of the matrix
				int top = matrix[first][i]; // Current layer's first element

				// Left is bottom-left of the matrix
				// Since the row number of the elements changes with each
				// iteration, while column number remains the same, consider the
				// offset while deciding the row
				matrix[first][i] = matrix[last - offset][first];

				// Bottom is bottom-right of the matrix
				// Since the column number of the elements changes with each
				// iteration, while the row number remains the same, consider
				// the offset while deciding the column
				matrix[last - offset][first] = matrix[last][last - offset];

				// Right is top-right of the matrix
				matrix[last][last - offset] = matrix[i][last]; // Current
																// layer's last
																// element

				// Move top to right
				matrix[i][last] = top;
			}

		}
	}
}
