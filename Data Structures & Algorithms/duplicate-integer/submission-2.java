class Solution {
    public boolean hasDuplicate(int[] nums) {
        // create hashset
        HashSet<Integer> set = new HashSet<>();

        // iterate through nums
        for (int i = 0; i < nums.length; i++) {
            // if it contains key, return true
            if (set.contains(nums[i])) {
                return true;
            }
            // if not, add it to the hashset
            set.add(nums[i]);
        }
        return false;
    }
}

// O(n) time for iterating through nums
// O(1) time for looking up set