package edu.problems.numerical.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	
	List<List<Integer>> triangle = new ArrayList<List<Integer>>();

	public List<List<Integer>> generate(int numRows) {

		int rowCount = 1;
		while (rowCount <= numRows) {

			if (rowCount == 1){
			    ArrayList<Integer> aRow = new ArrayList<Integer>();
                aRow.add(1);
                triangle.add(aRow);
                rowCount++;
            } else if (rowCount == 2){
                ArrayList<Integer> aRow = new ArrayList<Integer>();
                aRow.add(1);
                aRow.add(1);
                triangle.add(aRow);
                rowCount++;
            } else if (rowCount > 2 && rowCount <= numRows){
                ArrayList<Integer> nextRow = new ArrayList<Integer>();
                ArrayList<Integer> aRow = new ArrayList<Integer>(triangle.get(triangle.size() - 1));
                nextRow.add(1);
                for (int i = 0; i < aRow.size() - 1; i++){
                    nextRow.add(i + 1, aRow.get(i) + aRow.get(i + 1));
                }
                nextRow.add(1);
                triangle.add(nextRow);

                rowCount++;
            }
		}
		return triangle;
	}
}

//	ArrayList<Integer> aRow = new ArrayList<Integer>();
//    ArrayList<Integer> cRow = new ArrayList<Integer>();
//	ArrayList<Integer> nextRow = new ArrayList<Integer>();
//	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
//
//	public List<List<Integer>> generate(int numRows) {
//
//		int rowCount = 1;
//		while (rowCount <= numRows) {
//
//			if (rowCount == 1){
//                aRow.add(1);
//                cRow = aRow;
//                triangle.add(cRow);
//                rowCount++;
//            } else if (rowCount == 2){
//                cRow.clear();
//                aRow.add(1);
//                cRow = aRow;
//                triangle.add(cRow);
//                rowCount++;
//            } else if (rowCount > 2 && rowCount <= numRows){
//                nextRow.clear();
//                nextRow.add(1);
//                for (int i = 0; i < aRow.size() - 1; i++){
//                    nextRow.add(i + 1, aRow.get(i) + aRow.get(i + 1));
//                }
//                nextRow.add(1);
//                triangle.add(nextRow);
//                aRow.clear();
//                aRow = nextRow;
//                rowCount++;
//            }
//		}
//		return triangle;
//	}
//}
