class Solution {
    public boolean hasDuplicate(int[] nums) {

        // create a hashmap
        HashMap<Integer, Boolean> map = new HashMap<>();

        // iterate through nums
        for (int i = 0; i < nums.length; i++) {
            // if hashmap contains num, return true
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], true);
            }
            // otherwise add num to hashmap
        }
        return false;        
    }
}

// O(n) time for iterating through nums
// O(1) time for looking up hashmap