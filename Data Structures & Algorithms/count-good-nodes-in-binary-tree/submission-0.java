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

class Solution {

    int good = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return good;        
    }

    private void dfs(TreeNode node, int greatest) {
        if (node == null) {
            return;
        }

        // update greatest
        int newGreatest = greatest;

        // good node
        if (node.val >= greatest) {
            good++;
            newGreatest = node.val;
        }

        // continue search
        dfs(node.left, newGreatest);
        dfs(node.right, newGreatest);
    }
}
