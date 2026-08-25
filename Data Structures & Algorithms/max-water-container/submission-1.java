class Solution {
    public int maxArea(int[] heights) {

        // [1,100,2,5,4,100,3,6]

        int best = 0;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            // calculate area of water
            int temp = Math.min(heights[left], heights[right]) * (right - left);

            // compare to best
            best = Math.max(temp, best);

            // move shorter pointer inwards
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;        
    }
}
