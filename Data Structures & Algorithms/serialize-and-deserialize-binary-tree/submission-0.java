/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    String[] data;
    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        dfsSerialize(root, result);
        return result.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder result) {
        // if node is null, append N
        // otherwise append val
        if (node == null) {
            result.append("N");
            result.append(",");
            return;
        }

        result.append(node.val);
        result.append(",");

        // dfs left
        dfsSerialize(node.left, result);

        // dfs right
        dfsSerialize(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.index = 0;

        String[] dataString = data.split(",");
        this.data = dataString;


        return dfsDeserialize();
    }

    private TreeNode dfsDeserialize() {
        if (index >= data.length) {
            return null;
        }
        if (data[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data[index]));
        index++;

        node.left = dfsDeserialize();
        node.right = dfsDeserialize();

        return node;
    }
}
