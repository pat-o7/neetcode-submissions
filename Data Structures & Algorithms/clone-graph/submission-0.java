/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    // original : clone
    Map<Node, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        map = new HashMap<>();

        // clone all nodes first
        dfs(node);

        // create all neighbour lists
        dfs2();

        return map.get(node);        
    }

    private void dfs(Node node) {
        // check if it exists in map
        // if it exists, return
        // if not, clone the node
        if (map.containsKey(node)) {
            return;
        } else {
            Node temp = new Node(node.val);
            map.put(node, temp);
        }

        // dfs on each neighbour
        for (Node neighbor : node.neighbors) {
            dfs(neighbor);
        }
    }

    private void dfs2() {
        // for each node in the map
        for (Node node : map.keySet()) {
            Node clone = map.get(node);
            List<Node> cloneNeighbors = new ArrayList<>();

            for (Node neighbor : node.neighbors) {
                cloneNeighbors.add(map.get(neighbor));
            }

            clone.neighbors = cloneNeighbors;
        }
    }
}