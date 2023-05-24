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