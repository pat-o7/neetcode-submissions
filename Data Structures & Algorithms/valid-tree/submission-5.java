class Solution {
    public boolean validTree(int n, int[][] edges) {

        // create adjacency list
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }

        // create seen
        boolean[] seen = new boolean[n];

        // queue
        // initialize with node 0
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, -1});

        // go through queue
        // for each node, visit the neighbours
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];
            
            // mark seen
            seen[node] = true;

            // for each neighbour
            // if unseen, add to queue
            // if seen, it is a cycle unless it is the parent
            for (int neighbour : adjacency.get(node)) {
                if (seen[neighbour] == false) {
                    queue.add(new int[] {neighbour, node});
                } else if (neighbour != parent) {
                    // cycle
                    return false;
                }
            }
        }

        // check we visited all nodes
        for (boolean node : seen) {
            if (node == false) {
                // disconnected tree
                return false;
            }
        }

        return true;
    }
}
