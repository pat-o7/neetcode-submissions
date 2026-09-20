class KthLargest {

    // min heap of k size
    Queue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>((a, b) -> {
            if (a < b) {
                return -1;
            } else if (a > b) {
                return +1;
            } else {
                return 0;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            while (heap.size() > k) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        heap.add(val);
        while (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();        
    }
}
