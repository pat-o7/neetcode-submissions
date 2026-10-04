class Solution {
    int[] parents;

    public int[] findRedundantConnection(int[][] edges) {
        // union find
        int[] redundant = null;

        // create parent array
        parents = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        // iterate through edges
        for (int[] edge : edges) {
            // check if both edges exist in group
            if (findRoot(edge[0]) == findRoot(edge[1])) {
                redundant = new int[] {edge[0], edge[1]};
            } else {
                parents[findRoot(edge[1])] = findRoot(edge[0]);
            }
        }

        if (redundant == null) {
            throw new IllegalArgumentException("No redundant connection found");
        }

        return redundant;
    }

    private int findRoot(int node) {
        while (parents[node] != node) {
            node = parents[node];
        }
        return node;
    }
}
