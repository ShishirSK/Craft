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
public class MinPathSumDP {

	// More efficient solution - Calculate min value path to each of the
	// positions on the grid and proceed till the last position.

	public int minPathSum(int[][] grid) {

		int numOfRows = grid.length - 1;
		int numOfCols = grid[0].length - 1;

		// Calculate path value along the first row.
		for (int col = 1; col <= numOfCols; col++) {
			grid[0][col] += grid[0][col - 1];
		}

		// Calculate path value along the first column.
		for (int row = 1; row <= numOfRows; row++) {
			grid[row][0] += grid[row - 1][0];
		}

		// For each remaining position on the grid, get the min of the path to
		// get there.
		for (int cols = 1; cols <= numOfCols; cols++) {
			for (int rows = 1; rows <= numOfRows; rows++) {
				grid[rows][cols] = Math.min(grid[rows][cols]
						+ grid[rows][cols - 1], grid[rows][cols]
						+ grid[rows - 1][cols]);
			}
		}
		// Last position now holds the nim value path to that position.
		return grid[numOfRows][numOfCols];
	}
}
