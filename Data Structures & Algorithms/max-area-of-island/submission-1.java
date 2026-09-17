class Solution {

    int tempBest = 0;

    public int maxAreaOfIsland(int[][] grid) {

        int best = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    // dfs(grid, row, col);
                    // best = Math.max(best, tempBest);
                    // tempBest = 0;
                    best = Math.max(best, dfs(grid, row, col));
                }
            }
        }

        return best;        
    }

    private int dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }

        // tempBest++;
        grid[row][col] = 0;

        int top = 0;
        if (row > 0) {
            top = dfs(grid, row - 1, col);
        }

        int right = 0;
        if (col < grid[0].length - 1) {
            right = dfs(grid, row, col + 1);
        }

        int bottom = 0;
        if (row < grid.length - 1) {
            bottom = dfs(grid, row + 1, col);
        }

        int left = 0;
        if (col > 0) {
            left = dfs(grid, row, col - 1);
        }

        return 1 + top + right + bottom + left;
    }
}
