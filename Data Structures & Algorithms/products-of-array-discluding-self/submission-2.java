class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;



        // walk forward
        int prefix = nums[0];        
        for (int i = 1; i < nums.length; i++) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        // walk backward
        int suffix = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0 ; i--) {
            result[i] = result[i] * suffix;
            suffix = suffix * nums[i];
        }

        return result;        
    }
}  
