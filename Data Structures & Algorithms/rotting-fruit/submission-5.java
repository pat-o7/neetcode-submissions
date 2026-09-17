class Solution {
    public int orangesRotting(int[][] grid) {

        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        int minutes = 0;

        // iterate through grid to add rotting fruit to queue
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }
                if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        // BFS
        while (!queue.isEmpty() && fresh > 0) {
            int levelSize = queue.size();

            while (levelSize > 0) {
                // process neighbours
                // must be in bounds, must be a fresh fruit
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // neighbouring fresh fruit
                // top
                if (row > 0) {
                    if (grid[row - 1][col] == 1) {
                        grid[row - 1][col] = 2;
                        fresh--;
                        queue.add(new int[]{row - 1, col});
                    }
                }

                // right
                if (col < grid[0].length - 1) {
                    if (grid[row][col + 1] == 1) {
                        grid[row][col + 1] = 2;
                        fresh--;
                        queue.add(new int[]{row, col + 1});
                    }
                }

                // bottom
                if (row < grid.length - 1) {
                    if (grid[row + 1][col] == 1) {
                        grid[row + 1][col] = 2;
                        fresh--;
                        queue.add(new int[]{row + 1, col});
                    }
                }                

                // left
                if (col > 0) {
                    if (grid[row][col - 1] == 1) {
                        grid[row][col - 1] = 2;
                        fresh--;
                        queue.add(new int[]{row, col - 1});
                    }
                }
                levelSize--;
            }
            minutes++;
        }

        if (fresh > 0) {
            return -1;
        }      
        
        return minutes;
    }
}
