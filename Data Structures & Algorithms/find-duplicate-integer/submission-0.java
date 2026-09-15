class Solution {
    public int findDuplicate(int[] nums) {

        // floyds algorithm

        // cycle through until we see slow overlaps fast
        int slow = 0;
        int fast = 0;
        do {
            // cycle
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // reset cycle to count from same speed
        int slow2 = 0;
        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        } while (slow != slow2);

        // return overlap
        return slow;        
    }
}
