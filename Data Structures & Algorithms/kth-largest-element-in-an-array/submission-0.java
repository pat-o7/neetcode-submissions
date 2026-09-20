class Solution {
    public int findKthLargest(int[] nums, int k) {

        // min heap
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return +1;
            } else if (b > a) {
                return -1;
            } else {
                return 0;
            }
        });

        // iterate through nums
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);

            while (heap.size() > k) {
                heap.poll();
            }
        }

        int result = heap.poll();
        return result;        
    }
}
