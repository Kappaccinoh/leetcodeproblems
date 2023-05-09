import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        LinkedList rowsToZero = new LinkedList();
        LinkedList colsToZero = new LinkedList();

        // process
        for (int i = 0; i < matrix.length; i++)  {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsToZero.add(i);
                    colsToZero.add(j);
                }
            }
        }

        // fill matrix
        while (!rowsToZero.isEmpty()) {
            int row = (int) rowsToZero.poll();
            setRow(matrix, row);
        }

        while (!colsToZero.isEmpty()) {
            int col = (int) colsToZero.poll();
            setCol(matrix, col);
        }
    }

    public void setRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public void setCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}