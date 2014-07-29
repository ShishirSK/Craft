package edu.problems.recursive.dp.uniquepaths;

/**
 * A robot is located at the top-left corner of a m x n grid.
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid.
 * 
 * How many possible unique paths are there? #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class UniquePathsI {
	public int uniquePaths(int m, int n) {

		int[][] grid = new int[m][n];

		// Only 1 path across the first row
		for (int col = 0; col < n; col++) {
			grid[0][col] = 1;
		}

		// Only 1 path across the first column
		for (int row = 0; row < m; row++) {
			grid[row][0] = 1;
		}

		// For each remaining position on the grid, get the number of paths of
		// getting there by summing up the number of paths to get to its
		// adjacent blocks
		for (int cols = 1; cols < n; cols++) {
			for (int rows = 1; rows < m; rows++) {
				grid[rows][cols] = (grid[rows - 1][cols] + grid[rows][cols - 1]);
			}
		}
		// Last position now holds the number of unique paths to that position.
		return grid[m - 1][n - 1];
	}
}