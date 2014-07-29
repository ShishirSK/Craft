package edu.problems.recursive.dp.queens;

import java.util.ArrayList;
import java.util.List;

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
	    
	    private void placeQueen(int row, Integer[] columns, ArrayList<String[]> queenCombos){
	        
	        if (row == gridSize){               // Base condition
	            String[] positions = new String[gridSize];
	            fillBoard(positions, columns);
	            queenCombos.add(positions);
	        } else {
	            for (int col = 0; col < gridSize; col++){
	                if (checkValid(columns, row, col)){
	                    columns[row] = col;
	                    placeQueen(row + 1, columns, queenCombos);
	                }
	            }
	        }
	    }
	    
	    private boolean checkValid(Integer[] columns, int row1, int column1){
	        for (int row2 = 0; row2 < row1; row2++){
	            
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
	    
	    private void fillBoard(String[] queenPositions, Integer[] queenColumns){
	        
	        for (int rowPos = 0; rowPos < gridSize; rowPos++){
	            StringBuffer str = new StringBuffer();
	            int queenCol = queenColumns[rowPos];
	            for (int boardCols = 0; boardCols < gridSize; boardCols++){
	                if (boardCols == queenCol){
	                    str.append("Q");
	                } else {
	                    str.append(".");
	                }
	            }
	            queenPositions[rowPos] = str.toString();
	        }
	    }
	}
