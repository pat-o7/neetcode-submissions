class Solution {
    public int longestConsecutive(int[] nums) {
        int best = 0;

        HashSet<Integer> set = new HashSet<>();

        // store everything in hashset
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // for each number, fan out in the set 
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                int temp = 0;

                // increase best
                temp++;

                // remove from set
                set.remove(nums[i]);

                // fan below
                int below = 1;
                while (true) {
                    if (set.contains(nums[i] - below)) {
                        temp++;
                        set.remove(nums[i] - below);
                        below++;
                    } else {
                        break;
                    }

                }

                // fan above
                int above = 1;
                while (true) {
                    if (set.contains(nums[i] + above)) {
                        temp++;
                        set.remove(nums[i] + above);
                        above++;
                    } else {
                        break;
                    }
                }

                best = Math.max(temp, best);
            }
        }

        return best;        
    }
}
