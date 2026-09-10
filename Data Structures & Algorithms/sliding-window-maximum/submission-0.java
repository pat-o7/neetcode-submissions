class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        // max heap
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] > b[0]) {
                return -1;
            } else if (a[0] < b[0]) {
                return +1;
            } else {
                return 0;
            }
        });

        // initialize heap
        for (int i = 0; i < k - 1; i++) {
            int[] temp = new int[2];
            temp[0] = nums[i];
            temp[1] = i;

            heap.add(temp);
        }

        int left = 0;
        int right = k - 1;

        while (right < nums.length) {
            heap.add(new int[]{nums[right], right});
            while (!heap.isEmpty() && heap.peek()[1] < left) {
                heap.poll();
            }

            // add top element to result array
            if (!heap.isEmpty()) {
                result[left] = heap.peek()[0];
            }

            // move window
            left++;
            right++;
        }
        return result;
    }
}
