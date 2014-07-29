package edu.problems.recursive.dp.queens;

import java.util.ArrayList;

public class NQueensII {
	int gridSize;
	int solutions = 0;

	public int totalNQueens(int n) {
		ArrayList<String[]> queenCombos = new ArrayList<String[]>();
		if (n < 1)
			return solutions;
		gridSize = n;
		Integer[] columns = new Integer[n];
		placeQueen(0, columns, queenCombos);
		return solutions;
	}

	private void placeQueen(int row, Integer[] columns,
			ArrayList<String[]> queenCombos) {

		if (row == gridSize) { // Base condition
			solutions++;
		} else {
			for (int col = 0; col < gridSize; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueen(row + 1, columns, queenCombos);
				}
			}
		}
	}

	private boolean checkValid(Integer[] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {

			int column2 = columns[row2];

			if (column1 == column2)
				return false;

			int columnDistance = Math.abs(column1 - column2);
			int rowDistance = row1 - row2;

			if (columnDistance == rowDistance)
				return false;
		}
		return true;
	}
}