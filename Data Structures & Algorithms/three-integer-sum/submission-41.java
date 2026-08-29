class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // -4, -1, -1, 0, 1, 2

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;


            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
            
                if (sum == 0) {
                    System.out.println("i: " + nums[i] + " | left: " + nums[left] + " | right: " + nums[right] + " | sum: " + sum);
                    
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    left++;

                    while (nums[left] == nums[left - 1] && left < nums.length - 1) {
                        left++;
                    }
                } else if (sum < 0) {
                    left++;            
                } else {
                    right--;             
                }
            }
        }
        return result;        
    }
}
