class Solution {
    // runtime O(nlogk) for n points in a heap of size k
    // space O(k) for heap size k
    public int[][] kClosest(int[][] points, int k) {

        // create max heap
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> {
            double distanceA = calculateDistance(a);
            double distanceB = calculateDistance(b);

            if (distanceA > distanceB) {
                return -1;
            } else if (distanceB > distanceA) {
                return +1;
            } else {
                return 0;
            }
        });

        // add all points into heap
        // while heap size > k, poll
        for (int i = 0; i < points.length; i++) {
            heap.add(points[i]);

            while (heap.size() > k) {
                heap.poll();
            }
        }

        // return array of points from heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    // calculates euclidian distance to origin
    private double calculateDistance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}