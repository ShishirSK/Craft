package edu.problems.recursive.dp.queens;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an nxn chessboard
 * such that no two queens attack each other. Given an integer n, return all
 * distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class NQueens {

	int gridSize;

	public List<String[]> solveNQueens(int n) {

		ArrayList<String[]> queenCombos = new ArrayList<String[]>();
		if (n < 1)
			return queenCombos;
		gridSize = n;
		Integer[] columns = new Integer[n];
		placeQueen(0, columns, queenCombos);
		return queenCombos;
	}

	/**
	 * @param row
	 *            - Index of the columns array
	 * @param columns
	 *            - column position of queen in row (index of array)
	 * @param queenCombos
	 *            - list to return
	 */
	private void placeQueen(int row, Integer[] columns,
			ArrayList<String[]> queenCombos) {

		if (row == gridSize) { // Base condition
			String[] positions = new String[gridSize];
			fillBoard(positions, columns);
			queenCombos.add(positions);
		} else {
			for (int col = 0; col < gridSize; col++) {
				if (checkValid(columns, row, col)) {
					// Place queen
					columns[row] = col;
					// Recurse
					placeQueen(row + 1, columns, queenCombos);
				}
			}
		}
	}

	/**
	 * @param columns
	 *            - column position of queen in row (index of array)
	 * @param row1
	 *            - current row
	 * @param column1
	 *            - current column
	 * @return
	 */
	private boolean checkValid(Integer[] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {

			// Column position of queen in row2
			int column2 = columns[row2];

			// Same column
			if (column1 == column2)
				return false;

			// Absolute value as column 2 can be greater
			int columnDistance = Math.abs(column1 - column2);
			int rowDistance = row1 - row2;

			// Same distance = diagonal position
			if (columnDistance == rowDistance)
				return false;
		}
		return true;
	}

	/**
	 * @param queenPositions
	 *            - contains string rows to construct for the board
	 * @param queenColumns
	 *            - positions of the queen on that board
	 */
	private void fillBoard(String[] queenPositions, Integer[] queenColumns) {

		for (int rowPos = 0; rowPos < gridSize; rowPos++) {
			StringBuffer str = new StringBuffer();
			int queenCol = queenColumns[rowPos];
			for (int boardCols = 0; boardCols < gridSize; boardCols++) {
				if (boardCols == queenCol) {
					str.append("Q");
				} else {
					str.append(".");
				}
			}
			queenPositions[rowPos] = str.toString();
		}
	}
}
