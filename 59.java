class Solution {
    public int[][] generateMatrix(int n) {
        int[][] grid = new int[n][n];

        if (n == 2) {
            grid[0][0] = 1;
            grid[0][1] = 2;
            grid[1][0] = 4;
            grid[1][1] = 3;

            return grid;
        }
        return topRight(grid, 0, n - 1, 0, n - 1, n, 1);
    }

    public int[][] topRight(int[][] grid, int leftbound, int rightbound, int upperbound, int lowerbound, int n, int count) {

        int i = leftbound;
        int j = upperbound + 1;
        
        if (n == 1) {
            grid[leftbound][rightbound] = count;
            return grid;
        }

        // top row
        while (i <= rightbound) {
            grid[upperbound][i] = count;
            count++;
            i++;
        }

        // right col
        while (j <= lowerbound) {
            grid[j][rightbound] = count;
            count++;
            j++;
        }

        if (rightbound - leftbound > 0) {
            return bottomLeft(grid, leftbound, rightbound - 1, upperbound + 1, lowerbound, n, count);
        } else {
            return grid;
        }
    }

    public int[][] bottomLeft(int[][] grid, int leftbound, int rightbound, int upperbound, int lowerbound, int n, int count) {
        if ((upperbound - lowerbound == 1) && (rightbound - leftbound == 1)) {
            grid[leftbound][lowerbound] = count;
            return grid;
        }

        int i = rightbound;
        int j = lowerbound - 1;

        // lower row
        while (i >= leftbound) {
            grid[lowerbound][i] = count;
            count++;
            i--;
        }

        // left col
        while (j >= upperbound) {
            grid[j][leftbound] = count;
            count++;
            j--;
        }

        if (rightbound - leftbound > 0) {
            return topRight(grid, leftbound + 1, rightbound, upperbound, lowerbound - 1, n - 2, count);
        } else {
            return grid;
        }
    }
}