class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int rows = 0; rows < grid.length; rows++) {
            for (int cols = 0; cols < grid[0].length; cols++) {
                if (grid[rows][cols] == '1') {
                    islands++;
                    dfs(grid, rows, cols);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int rows, int cols) {
        if (grid[rows][cols] == '1') {
            grid[rows][cols] = 0;

            if (rows > 0) {
                dfs(grid, rows - 1, cols);
            }
            if (rows < grid.length - 1) {
                dfs(grid, rows + 1, cols);
            }
            if (cols > 0) {
                dfs(grid, rows, cols - 1);
            }
            if (cols < grid[0].length - 1) {
                dfs(grid, rows, cols + 1);
            }
        }
    }
}
