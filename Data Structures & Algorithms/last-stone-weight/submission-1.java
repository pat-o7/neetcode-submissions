class Solution {
    public int lastStoneWeight(int[] stones) {

        // max heap
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return -1;
            } else if (b > a) {
                return +1;
            } else {
                return 0;
            }
        });

        // populate heap
        for (int i = 0; i < stones.length; i++) {
            heap.add(stones[i]);
        }

        // smash rocks
        while (!heap.isEmpty() && heap.size() > 1) {
            int rockOne = heap.poll();
            int rockTwo = heap.poll();

            int rockLeftOver = Math.abs(rockOne - rockTwo);

            if (rockLeftOver > 0) {
                heap.add(rockLeftOver);
            }
        }

        if (heap.isEmpty()) {
            return 0;
        } else {
            return heap.poll();
        }
        // return heap.poll();        
    }
}
