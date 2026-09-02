class Solution {
    public int findMin(int[] nums) {
        // guard 1
        if (nums.length == 1) {
            return nums[0];
        }

        // guard 2
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while (true) {
            // min is to the right of mid
            if (nums[mid] > nums[end]) {
                start = mid + 1;
                mid = (start + end) / 2;
            // min is at mid or to the left of mid
            } else if (nums[mid] < nums[end]) {
                end = mid;
                mid = (start + end) / 2;
            }

            if (start == end) {
                return nums[mid];
            }
        }
        
    }
}
