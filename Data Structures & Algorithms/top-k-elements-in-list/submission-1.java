class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (map.get(a) < map.get(b)) { // a is smaller than b
                return -1; // a goes before b
            } else if (map.get(a) > map.get(b)) {
                return +1;
            } else {
                return 0;
            }
            // this is now a min heap
        });

        // iterate through nums
        for (int i = 0; i < nums.length; i++) {
            // store nums in a frequency map

            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        
        // add nums in priority queue
        for (int key : map.keySet()) {
            queue.add(key);

            if (queue.size() > k) {
                queue.poll(); // remove smallest element
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (i < k) {
            result[i] = queue.poll();
            i++;
        }

        return result;        
    }
}
