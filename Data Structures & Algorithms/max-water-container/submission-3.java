class Solution {
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;

        int best = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            best = Math.max(area, best);

            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return best;
    }
}
