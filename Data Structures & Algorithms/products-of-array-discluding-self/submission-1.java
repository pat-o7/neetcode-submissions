class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int totalproduct = 1;

        // at least two zeroes in array
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            }
        }
        if (zeroes >= 2) {
            return new int[nums.length];

        // one zero
        } else if (zeroes == 1) {
            int zeroindex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    totalproduct = totalproduct * nums[i];
                } else {
                    zeroindex = i;
                }
            }
            output[zeroindex] = totalproduct;
            return output;
        } else {
            for (int i = 0; i < nums.length; i++) {
                totalproduct = totalproduct * nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                output[i] = totalproduct / nums[i];
            }
            return output;
        }
    }
}  
