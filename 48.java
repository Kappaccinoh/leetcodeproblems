class Solution {
    public void rotate(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        copy = transpose(matrix, copy);
        copy = mirrorFlip(copy);
        matrix = copy(matrix, copy);
    }

    public int[][] transpose(int[][] matrix, int[][] copy) {
        int N = matrix.length;
        int i, j;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                copy[i][j] = matrix[j][i];
            }
        }
        return copy;
    }

    public int[][] mirrorFlip(int[][] arr) {
        int M = arr.length;
        int N = M;
        for (int i = 0; i < M; i++) {
    
            int start = 0;
            int end = N - 1;
    
            while (start < end) {
    
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
    
                start++;
                end--;
            }
        }
        return arr;
    }

    public int[][] copy(int[][] matrix, int[][] copy) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = copy[i][j];
            }
        }
        return matrix;
    }
}