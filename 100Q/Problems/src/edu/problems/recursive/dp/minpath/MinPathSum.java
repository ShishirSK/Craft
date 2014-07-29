package edu.problems.recursive.dp.minpath;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class MinPathSum {

	int numOfRows = 0;
	int numOfCols = 0;
	int minPath;

	// Recursive solution
	
	public int minPathSum(int[][] grid) {

		numOfRows = grid.length - 1;
		numOfCols = grid[0].length - 1;

		doPathSum(0, 0, 0, grid);
		System.out.println(minPath);
		return minPath;
	}

	private void doPathSum(int row, int col, int pathSum, int[][] matrix) {

		pathSum += matrix[row][col];

		if (row < numOfRows) {
			doPathSum(row + 1, col, pathSum, matrix);
		}

		if (col < numOfCols) {
			doPathSum(row, col + 1, pathSum, matrix);
		}

		if (row == numOfRows && col == numOfCols) {
			if (minPath == 0) {
				minPath = pathSum;
			} else if (pathSum < minPath) {
				minPath = pathSum;
			}
		}
	}
}
