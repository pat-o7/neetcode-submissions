class Solution {
    public int trap(int[] height) {

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        // hashmap for the tallest wall to the left of key slice
        int bestLeft = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = bestLeft;
            bestLeft = Math.max(bestLeft, height[i]);
        }

        // hashmap for the tallest wall to the right of key slice
        int bestRight = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            maxRight[i] = bestRight;
            bestRight = Math.max(bestRight, height[i]);
        }

        // find water height for each slide
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (water > 0) {
                result = result + water;
            }
        }

        return result;        
    }
}
