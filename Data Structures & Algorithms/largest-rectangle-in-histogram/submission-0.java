class Solution {
    public int largestRectangleArea(int[] heights) {

        // compute max right boundary index that is same or taller than current
        int[] maxRight = new int[heights.length];
        Deque<Integer> waitingRight = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (waitingRight.size() > 0 && heights[i] < heights[waitingRight.peek()]) {
                maxRight[waitingRight.peek()] = i - 1;
                waitingRight.pop();
            }
            waitingRight.push(i);
        }
        while (waitingRight.size() > 0) {
            maxRight[waitingRight.pop()] = heights.length - 1;
        }

        // compute max left boundary index that is same or taller than current
        int[] maxLeft = new int[heights.length];
        Deque<Integer> waitingLeft = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (waitingLeft.size() > 0 && heights[i] < heights[waitingLeft.peek()]) {
                maxLeft[waitingLeft.peek()] = i + 1;
                waitingLeft.pop();
            }
            waitingLeft.push(i);
        }
        while (waitingLeft.size() > 0) {
            maxLeft[waitingLeft.pop()] = 0;
        }

        // track best
        int best = 0;

        // for each column, compute max rectangle with given boundaries
        for (int i = 0; i < heights.length; i++) {
            int area = (heights[i]) * (maxRight[i] - maxLeft[i] + 1);
            best = Math.max(best, area);
        }

        return best;        
    }
}
