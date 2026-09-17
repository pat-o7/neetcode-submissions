class Solution {
    public void islandsAndTreasure(int[][] grid) {

        // queue for bfs
        Deque<int[]> queue = new ArrayDeque<>();

        // iterate through grid and add all treasures to queue first
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // if it is a treasure
                if (grid[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        // iterate through queue, and for every land we hit, add 1 distance to it
        while (!queue.isEmpty()) {
            // distance to all neighbours is current + 1
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            queue.poll();

            // must be in bounds, not water, and not treasure
            int distance = grid[row][col] + 1;

            // top
            if (row > 0) {
                if (grid[row - 1][col] == 2147483647) {
                    grid[row - 1][col] = distance;
                    queue.offer(new int[]{row - 1, col});
                }
            }

            // right
            if (col < grid[0].length - 1) {
                if (grid[row][col + 1] == 2147483647) {
                    grid[row][col + 1] = distance;
                    queue.offer(new int[]{row, col + 1});
                }
            }

            // bottom
            if (row < grid.length - 1) {
                if (grid[row + 1][col] == 2147483647) {
                    grid[row + 1][col] = distance;
                    queue.offer(new int[]{row + 1, col});
                }
            }

            // left
            if (col > 0) {
                if (grid[row][col - 1] == 2147483647) {
                    grid[row][col - 1] = distance;
                    queue.offer(new int[]{row, col - 1});
                }
            }
        }
    }
}
