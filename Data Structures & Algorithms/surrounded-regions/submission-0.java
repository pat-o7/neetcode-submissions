class Solution {
    public void solve(char[][] board) {

        boolean[][] touchingEdge = new boolean[board.length][board[0].length];
        Deque<int[]> queue = new ArrayDeque<>();

        // top
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') {
                touchingEdge[0][col] = true;
                queue.offer(new int[] {0, col});
            }
        }
        // right
        for (int row = 0; row < board.length; row++) {
            if (board[row][board[0].length - 1] == 'O') {
                touchingEdge[row][board[0].length - 1] = true;
                queue.offer(new int[] {row, board[0].length - 1});
            }
        }
        // bottom
        for (int col = 0; col < board[0].length; col++) {
            if (board[board.length - 1][col] == 'O') {
                touchingEdge[board.length - 1][col] = true;
                queue.offer(new int[] {board.length - 1, col});
            }
        }
        // left
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                touchingEdge[row][0] = true;
                queue.offer(new int[] {row, 0});
            }
        }

        // touchingEdge with all Os touching the edge
        // queue with all edge Os
        // BFS through all edge Os simultaneously, and mark those in touchingEdge
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // check neighbours
            // if neighbour is O and touchingEdge at neighbour is false, mark true
            // add neighbour to queue

            // top
            if (row > 0 
            && board[row - 1][col] == 'O' 
            && touchingEdge[row - 1][col] == false) {
                touchingEdge[row - 1][col] = true;
                queue.offer(new int[] {row - 1, col});
            }
            // right
            if (col < board[0].length - 1
            && board[row][col + 1] == 'O'
            && touchingEdge[row][col + 1] == false) {
                touchingEdge[row][col + 1] = true;
                queue.offer(new int[] {row, col + 1});
            }
            // bottom
            if (row < board.length - 1
            && board[row + 1][col] == 'O'
            && touchingEdge[row + 1][col] == false) {
                touchingEdge[row + 1][col] = true;
                queue.offer(new int[] {row + 1, col});
            }
            // left
            if (col > 0
            && board[row][col - 1] == 'O'
            && touchingEdge[row][col - 1] == false) {
                touchingEdge[row][col - 1] = true;
                queue.offer(new int[] {row, col - 1});
            }
        }

        // iterate through board
        // if node is O and touching edge is false, change to X
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O' && touchingEdge[row][col] == false) {
                    board[row][col] = 'X';
                }
            }
        }
    }
}
