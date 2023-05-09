class Solution {
    public int[][] distances;
    public int POSITIVE = Integer.MAX_VALUE;
    public int[][] GRID;

    public int row;
    public int col;


    public int minPathSum(int[][] grid) {
        this.GRID = grid;
        this.distances = new int[grid.length][grid[0].length];

        this.row = grid.length;
        this.col = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                this.distances[i][j] = this.POSITIVE;
            }
        }

        this.distances[0][0] = grid[0][0];

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {

                System.out.println(this.distances[i][j]);
                
                // move down
                int newEdgex = i + 1;
                int newEdgey = j;

                if (newEdgex < this.row && newEdgey < this.col) {
                    relax(i, j, newEdgex, newEdgey);
                }

                // move right
                int newEdgex1 = i;
                int newEdgey1 = j + 1;

                if (newEdgex1 < this.row && newEdgey1 < this.col) {
                    relax(i, j, newEdgex1, newEdgey1);
                }
            }
        }

        // System.out.println(this.distances[0][1]);
        // System.out.println(this.row);
        // System.out.println(this.col);
        // 1 2 3
        // 4 5 6

        // System.out.println(this.distances[0][1]);

        return this.distances[grid.length - 1][grid[0].length - 1];
    }

    public void relax(int ax, int ay, int bx, int by) {
        if (distances[bx][by] > distances[ax][ay] + this.GRID[bx][by]) {
            distances[bx][by] = distances[ax][ay] + this.GRID[bx][by];
        }
    }
}