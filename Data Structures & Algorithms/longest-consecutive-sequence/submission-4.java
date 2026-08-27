class Solution {
    public int longestConsecutive(int[] nums) {

        // store everything in hashset
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int best = 0;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {

                int temp = 1;

                set.remove(nums[i]);

                // fan down
                int below = 1;
                while (true) {
                    if (set.contains(nums[i] - below)) {
                        set.remove(nums[i] - below);
                        below++;
                        temp++;
                    } else {
                        break;
                    }
                }

                // fan up
                int above = 1;
                while (true) {
                    if (set.contains(nums[i] + above)) {
                        set.remove(nums[i] + above);
                        above++;
                        temp++;
                    } else {
                        break;
                    }
                }

                // update best
                best = Math.max(best, temp);


            }
        }

        return best;
        
    }
}
