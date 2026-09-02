class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while (true) {
            if (target == nums[mid]) {
                return mid;
            }            
            // determine sorted side
            if (nums[start] <= nums[mid]) {
                // left half is sorted
                // so is target in this range?
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                    mid = (start + end) / 2;
                } else {
                    start = mid + 1;
                    mid = (start + end) / 2;
                }
            } else if (nums[end] >= nums[mid]) {
                // right half is sorted
                // so is target in this range?
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                    mid = (start + end) / 2;
                } else {
                    end = mid - 1;
                    mid = (start + end) / 2;
                }
            }
            if (start > end) {
                return -1;
            }
            
        }
        
    }
}
