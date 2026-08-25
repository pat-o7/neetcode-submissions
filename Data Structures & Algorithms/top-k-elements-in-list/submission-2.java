class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (map.get(a) < map.get(b)) {
                // a is smaller than b, b should go first
                return -1;
            } else if (map.get(a) > map.get(b)) {
                // a is bigger than b, a should go first
                return +1;
            } else {
                return 0;
            }
            // this is now a min heap
        });

        // iterate through nums
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // add nums in min heap
        for (int key : map.keySet()) {
            queue.add(key);

            // keep heap only size k
            if (queue.size() > k) {
                queue.poll(); // removes the smallest element
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
        
    }
}
