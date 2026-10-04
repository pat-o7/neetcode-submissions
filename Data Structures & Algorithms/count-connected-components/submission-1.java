class Solution {
    public int countComponents(int n, int[][] edges) {
        // graph count
        int graphs = 0;

        // create adjacency list
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }

        // create seen list
        boolean[] seen = new boolean[n];

        // create queue
        Deque<Integer> queue = new ArrayDeque<>();

        // iterate through seen list, for each unseen node
        // add all neighbours into queue
        // iterate through queue until we have seen all neighbours
        // increment graph counter
        for (int i = 0; i < seen.length; i++) {
            if (seen[i] == false) {
                queue.add(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int neighbour : adjacency.get(node)) {
                        if (seen[neighbour] == false) {
                            seen[neighbour] = true;
                            queue.add(neighbour);
                        }
                    }
                }
                graphs++;
            }
        }

        return graphs;
    }
}
