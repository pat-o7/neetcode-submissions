class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i]; // i = 0, difference = 4

            if (map.containsKey(nums[i])) { // i = 1, difference = 3
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(difference, i); // 4, 0
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}
