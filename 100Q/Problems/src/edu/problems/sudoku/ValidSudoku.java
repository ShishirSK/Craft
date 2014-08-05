package edu.problems.sudoku;

import java.util.ArrayList;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		// Size has to be 9 x 9
		if (board.length != 9 || board[0].length != 9) {
			return false;
		}
		char empty = '.';

		// Arraylists of Boolean arrays for row, column and block
		ArrayList<boolean[]> rowCheck = new ArrayList<boolean[]>();
		ArrayList<boolean[]> colCheck = new ArrayList<boolean[]>();
		ArrayList<boolean[]> blockCheck = new ArrayList<boolean[]>();

		// 9 boolean arrays in each arraylist
		for (int i = 0; i < 9; i++) {
			rowCheck.add(new boolean[9]);
			colCheck.add(new boolean[9]);
			blockCheck.add(new boolean[9]);
		}

		// loop through the matrix
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				// Skip loop for empty positions
				if (board[i][j] == empty) {
					continue;
				}

				// Get number at current position. Its index position in array
				// would be 1 less than it value
				int curr = board[i][j] - '1'; // ' ' due to char data type

				// Check that row, column or block does not have the value yet
				if (rowCheck.get(i)[curr] == true
						|| colCheck.get(j)[curr] == true
						|| blockCheck.get(i / 3 * 3 + j / 3)[curr] == true) {
					return false;
				} else { // If not found yet, set to true
					rowCheck.get(i)[curr] = true;
					colCheck.get(j)[curr] = true;
					blockCheck.get(i / 3 * 3 + j / 3)[curr] = true;
				}
			}
		}

		return true; // Valid
	}
}