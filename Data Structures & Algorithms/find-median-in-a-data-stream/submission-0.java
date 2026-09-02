class MedianFinder {

    Queue<Integer> leftMaxHeap = new PriorityQueue<>((a, b) -> {
        if (a > b) {
            return -1;
        } else if (a < b) {
            return +1;
        } else {
            return 0;
        }
    });
    Queue<Integer> rightMinHeap = new PriorityQueue<>((a, b) -> {
        if (a < b) {
            return -1;
        } else if (a > b) {
            return +1;
        } else {
            return 0;
        }
    });

    public MedianFinder() {
    }
    
    public void addNum(int num) {
        // add it to proper side
        if (leftMaxHeap.size() == 0 || num <= leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        // rebalance heaps
        // left side bigger
        while (leftMaxHeap.size() - rightMinHeap.size() > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        }
        // right side bigger
        while (rightMinHeap.size() - leftMaxHeap.size() > 1) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            return (double) leftMaxHeap.peek();
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            return (double) rightMinHeap.peek();
        } else {
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }
        
    }
}
