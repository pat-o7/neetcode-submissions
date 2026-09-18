class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] flowableToPacific = new boolean[heights.length][heights[0].length];
        boolean[][] flowableToAtlantic = new boolean[heights.length][heights[0].length];

        // todo list
        Deque<int[]> queue = new ArrayDeque<>();

        // pass 1: mark all pacific flowable cells edge
        // top edge
        for (int col = 0; col < heights[0].length; col++) {
            queue.offer(new int[]{0, col});
            flowableToPacific[0][col] = true;
        }
        // left edge
        for (int row = 0; row < heights.length; row++) {
            queue.offer(new int[]{row, 0});
            flowableToPacific[row][0] = true;
        }
        // BFS
        while (!queue.isEmpty()) {
            // current level
            int size = queue.size();
            while (size > 0) {
                // current node
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // for each neighbour, check that its in bounds and that the current cell is flowable to pacific
                // if so, check that the neighbour can flow to current cell, and add to queue if true

                // top
                if (row > 0 && flowableToPacific[row][col] == true) {
                    if (heights[row - 1][col] >= heights[row][col]) {
                        if (flowableToPacific[row - 1][col] == false) {
                            flowableToPacific[row - 1][col] = true;
                            queue.offer(new int[] {row - 1, col});
                        }
                    }
                }

                // right
                if (col < heights[0].length - 1 && flowableToPacific[row][col] == true) {
                    if (heights[row][col + 1] >= heights[row][col]) {
                        if (flowableToPacific[row][col + 1] == false) {
                            flowableToPacific[row][col + 1] = true;
                            queue.offer(new int[] {row, col + 1});
                        }
                    }
                }

                // bottom
                if (row < heights.length - 1 && flowableToPacific[row][col] == true) {
                    if (heights[row + 1][col] >= heights[row][col]) {
                        if (flowableToPacific[row + 1][col] == false) {
                            flowableToPacific[row + 1][col] = true;
                            queue.offer(new int[] {row + 1, col});
                        }
                    }
                }

                // left
                if (col > 0 && flowableToPacific[row][col] == true) {
                    if (heights[row][col - 1] >= heights[row][col]) {
                        if (flowableToPacific[row][col - 1] == false) {
                            flowableToPacific[row][col - 1] = true;
                            queue.offer(new int[] {row, col - 1});
                        }
                    }
                }

                size--;
            }
        }


        // pass 2: mark all atlantic flowable cells edge
        // bottom edge
        for (int col = 0; col < heights[0].length; col++) {
            queue.offer(new int[]{heights.length - 1, col});
            flowableToAtlantic[heights.length - 1][col] = true;
        }
        // right edge
        for (int row = 0; row < heights.length; row++) {
            queue.offer(new int[]{row, heights[0].length - 1});
            flowableToAtlantic[row][heights[0].length - 1] = true;
        }
        // BFS
        while (!queue.isEmpty()) {
            // current level
            int size = queue.size();
            while (size > 0) {
                // current node
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // for each neighbour, check that its in bounds and that the current cell is flowable to atlantic
                // if so, check that the neighbour can flow to current cell, and add to queue if true

                // top
                if (row > 0 && flowableToAtlantic[row][col] == true) {
                    if (heights[row - 1][col] >= heights[row][col]) {
                        if (flowableToAtlantic[row - 1][col] == false) {
                            flowableToAtlantic[row - 1][col] = true;
                            queue.offer(new int[] {row - 1, col});
                        }
                    }
                }

                // right
                if (col < heights[0].length - 1 && flowableToAtlantic[row][col] == true) {
                    if (heights[row][col + 1] >= heights[row][col]) {
                        if (flowableToAtlantic[row][col + 1] == false) {
                            flowableToAtlantic[row][col + 1] = true;
                            queue.offer(new int[] {row, col + 1});
                        }
                    }
                }

                // bottom
                if (row < heights.length - 1 && flowableToAtlantic[row][col] == true) {
                    if (heights[row + 1][col] >= heights[row][col]) {
                        if (flowableToAtlantic[row + 1][col] == false) {
                            flowableToAtlantic[row + 1][col] = true;
                            queue.offer(new int[] {row + 1, col});
                        }
                    }
                }

                // left
                if (col > 0 && flowableToAtlantic[row][col] == true) {
                    if (heights[row][col - 1] >= heights[row][col]) {
                        if (flowableToAtlantic[row][col - 1] == false) {
                            flowableToAtlantic[row][col - 1] = true;
                            queue.offer(new int[] {row, col - 1});
                        }
                    }
                }

                size--;
            }
        }

        // pass 3: record down all cells with both flowable to pacific and flowable to atlantic
        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[0].length; col++) {
                if (flowableToPacific[row][col] && flowableToAtlantic[row][col]) {
                    result.add(new ArrayList<Integer>(Arrays.asList(row, col)));
                }
            }
        }

        return result;        
    }
}
