class Solution {
    List<List<Integer>> adjacency;
    boolean[] visited;

    public boolean validTree(int n, int[][] edges) {

        // creates visited list
        visited = new boolean[n];

        // creates adjacency list
        adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }

        // dfs from 0
        if (dfs(0, -1) == false) {
            return false;
        }

        for (boolean node : visited) {
            if (node == false) {
                return false;
            }
        }
        return true;
    }

    // for node:
    // mark all unvisited neighbours as visited
    // unless neighbour is parent or neighbour is already visited
    private boolean dfs(int node, int parent) {
        visited[node] = true;

        for (int neighbour : adjacency.get(node)) {
            if (visited[neighbour] == false) {
                visited[neighbour] = true;
                if (dfs(neighbour, node) == false) {
                    return false;
                }
            } else if (neighbour != parent) {
                // already seen
                return false;
            }
        }
        return true;
    }
}
