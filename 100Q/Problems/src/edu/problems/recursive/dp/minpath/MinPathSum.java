package edu.problems.recursive.dp.minpath;

public class MinPathSum {

	int numOfRows = 0;
    int numOfCols = 0;
    int minPath;
    public int minPathSum(int[][] grid) {
        
        numOfRows = grid.length - 1;
        numOfCols = grid[0].length - 1;
        
        doPathSum(0, 0, 0, grid);
        System.out.println(minPath);
        return minPath;    
    }
    
    private void doPathSum(int row, int col, int pathSum, int[][] matrix){
        
        pathSum += matrix[row][col];
        
        if (row < numOfRows){
            doPathSum(row + 1, col, pathSum, matrix);
        }
        
        if (col < numOfCols){
            doPathSum(row, col + 1, pathSum, matrix);
        }
        
        if (row == numOfRows && col == numOfCols){
            if (minPath == 0){
                minPath = pathSum;
            } else if (pathSum < minPath){
                minPath = pathSum;
            }
        }
    }
}
