class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // [-4,-1,-1,0,1,2]
        int i = 0;
        while (i < nums.length - 2) {
        // for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    continue;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    continue;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    while (left < right) {
                        if (nums[left] == nums[left - 1]) {
                            left++;
                        } else {
                            break;
                        }
                    }
                }
            }
            i++;
            while (i < nums.length - 2) {
                if (nums[i] == nums[i - 1]) {
                    i++;
                } else {
                    break;
                }
            }
        // }
        }
        return result;        
    }
}
