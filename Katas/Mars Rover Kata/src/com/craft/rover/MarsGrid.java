package com.craft.rover;

public class MarsGrid {

	private int gridWidth = 10;
	private int gridHeight = 10;
	private int mulFactor = 10;
	private int obstacle = 1;
	private int[][] grid = null;

	public int getGridWidth() {
		return gridWidth;
	}

	public void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}

	public int getGridHeight() {
		return gridHeight;
	}

	public void setGridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	public MarsGrid() {

		grid = new int[gridWidth][gridHeight];
		double randomPos = 0.0;
		int position = 0;

		for (int i = 0; i < gridWidth; i++) {

			// Obstacle 1
			randomPos = Math.random();
			System.out.println("Position:" + randomPos);
			position = (int) (randomPos * mulFactor);
			System.out.println("Position:" + position);
			grid[i][position] = obstacle;
			// Obstacle 2
			randomPos = Math.random();
			position = (int) (randomPos * mulFactor);
			System.out.println("Position:" + position);
			grid[i][position] = obstacle;

		}
	}

	public void showGrid() {
		for (int i = 0; i < this.gridHeight; i++) {
			for (int j = 0; j < gridWidth; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * Check position is empty
	 */
	public boolean isPositionEmpty(int x, int y) {
		System.out.println("Checking if position is empty");
		if (grid[x][y] == 1) {
			return false;
		}
		return true;
	}

	/*
	 * Set the rover position
	 */
	public void setPosition(int x, int y) {
		grid[x][y] = 8;
	}

	/*
	 * Update the rover position
	 */
	public void updateRoverPosition(int currX, int currY, int nextX, int nextY) {
		grid[currX][currY] = 0;
		grid[nextX][nextY] = 8;
	}

}
