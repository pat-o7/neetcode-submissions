class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // iterate through nums
        for (int i = 0; i < nums.length; i++) {
            // check number we need
            int difference = target - nums[i];

            // check if it exists in hashmap
            if (map.containsKey(difference)) {
                // if it exists, we can sum it
                return new int[] {map.get(difference), i};
            } else {
                // if not, we add to map
                map.put(nums[i], i);
            }
        }
        return null;   
    }
}
