class Solution {
    int sol;
    int dimension;

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        board = setup(n, board);
        recur(board, 0, n);
        return this.sol;
    }

    public int[][] setup(int n, int[][] board) {
        this.sol = 0;
        this.dimension = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        return board;
    }

    // Follow the steps mentioned below to implement the idea:

    // Make a recursive function that takes the state of the board and the current row number as its parameter.
    // Start in the topmost row.
    // If all queens are placed return true
    // Try all columns in the current row. Do the following for every tried column.
    //     If the queen can be placed safely in this column
    //         Then mark this [row, column] as part of the solution and recursively check if placing queen here leads to a solution.
    //         If placing the queen in [row, column] leads to a solution then return true.
    //         If placing queen doesn’t lead to a solution then unmark this [row, column] and track back and try other columns.
    // If all columns have been tried and nothing worked return false to trigger backtracking.

    public void recur(int[][] board, int row, int numQueens) {
        if (numQueens == 0) {
            this.sol += 1;
            return;
        }

        for (int col = 0; col < this.dimension; col++) {
            if (isValid(board, row, col)) {
                int[][] temp = copyArray(board);
                temp[row][col] = 1;
                recur(temp, row + 1, numQueens - 1);
            }
        }

        return;
    }

    public boolean isValid(int[][] board, int row, int col) {
        // check col
        for (int i = 0; i < this.dimension; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // check row
        for (int i = 0; i < this.dimension; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // check diag north west
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        // check diag north east
        i = row;
        j = col;
        while (i >= 0 && j < this.dimension) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        // check diag south west
        i = row;
        j = col;
        while (i < this.dimension && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i++;
            j--;
        }

        // check diag south east
        i = row;
        j = col;
        while (i < this.dimension && j < this.dimension) {
            if (board[i][j] == 1) {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }

    public int[][] copyArray(int[][] board) {
        int n = board.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = board[i][j];
            }
        }
        return ans;
    }
}