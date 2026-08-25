class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // [-4,-1,-1,0,1,2]

        // sort array
        Arrays.sort(nums);

        // [-1,-1,0,1]

        // for each number, have a pointer left and right
        // check for sum, then move pointers inwards
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                System.out.println("triggered same last number");
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            System.out.println("current iteration: " + i + " with numbers: " + nums[i] + " " + nums[left] + " " + nums[right]);

            if (sum > 0) {
                right--;
                continue;
            } else if (sum < 0) {
                System.out.println("triggered sum is less than zero");
                left++;
                continue;
            } else if (sum == 0) {
                result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                right--;
                left++;
                while (left < right) {
                    if (nums[left] == nums[left - 1]) {
                        left++;
                    } else {
                        break;
                    }
                }
                while (left < right) {
                    if (nums[right] == nums[right + 1]) {
                        right--;
                    } else {
                        break;
                    }
                }
            }

            }
        }
        return result;
    }
}
