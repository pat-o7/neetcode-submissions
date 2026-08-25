class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        // walk forwards and calculate prefix
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        // [1, 1, 2, 8]


        // walk backwards and calculate suffix
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix = suffix * nums[i];
        }

        // [48, 24, 12, 8]





        return result;
    }
}  
