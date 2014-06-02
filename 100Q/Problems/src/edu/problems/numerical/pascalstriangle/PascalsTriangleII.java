package edu.problems.numerical.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class PascalsTriangleII {

	List<List<Integer>> triangle = new ArrayList<List<Integer>>();

	public List<Integer> getRow(int rowIndex) {

		int rowCount = 0;
		while (rowCount <= rowIndex) {

			if (rowCount == 0) {
				ArrayList<Integer> aRow = new ArrayList<Integer>();
				aRow.add(1);
				triangle.add(aRow);
				rowCount++;
			} else if (rowCount == 1) {
				ArrayList<Integer> aRow = new ArrayList<Integer>();
				aRow.add(1);
				aRow.add(1);
				triangle.add(aRow);
				rowCount++;
			} else if (rowCount >= 2 && rowCount <= rowIndex) {
				ArrayList<Integer> nextRow = new ArrayList<Integer>();
				ArrayList<Integer> aRow = new ArrayList<Integer>(
						triangle.get(triangle.size() - 1));
				nextRow.add(1);
				for (int i = 0; i < aRow.size() - 1; i++) {
					nextRow.add(i + 1, aRow.get(i) + aRow.get(i + 1));
				}
				nextRow.add(1);
				triangle.add(nextRow);
				rowCount++;
			}
		}
		return triangle.get(rowIndex);
	}
}
