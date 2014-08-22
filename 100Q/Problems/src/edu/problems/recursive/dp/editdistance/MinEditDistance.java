package edu.problems.recursive.dp.editdistance;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * #LeetCode
 * 
 * Refer: http://web.stanford.edu/class/cs124/lec/med.pdf 
 * Also: Use substitution distance as 1, not 2
 * 
 * @author Shishir Kinkar
 * 
 */
public class MinEditDistance {

	public int minDistance(String word1, String word2) {

		// Get lenghts of strings
		int w1 = word1.length();
		int w2 = word2.length();

		// Make a matrix of one size larger
		int[][] matrix = new int[w1 + 1][w2 + 1];

		// Base distance
		matrix[0][0] = 0;

		// Along one word, in all rows, column 0 - set distances
		for (int i = 1; i <= w1; i++) {
			matrix[i][0] = i;
		}

		// Along one word, in all columns, row 0 - set distances
		for (int j = 1; j <= w2; j++) {
			matrix[0][j] = j;
		}

		int dist = 0;

		// For each row
		for (int i = 1; i <= w1; i++) {
			// For each column
			for (int j = 1; j <= w2; j++) {
				// Get Characters at one position less
				char one = word1.charAt(i - 1);
				char two = word2.charAt(j - 1);
				// If the characters are not same, they are one distance apart
				if (one != two) {
					dist = 1;
				} else {
					dist = 0;
				}

				// Distance is min of 3 combinations, as below.
				matrix[i][j] = Math.min(
						Math.min(matrix[i - 1][j] + 1, 
								 matrix[i][j - 1] + 1),
						matrix[i - 1][j - 1] + dist);
			}
		}
		// Minimum distance is at last position
		return matrix[w1][w2];
	}
}
