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

    int kth;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        // left child
        dfs(node.left);

        // current node
        kth--;
        if (kth == 0) {
            result = node.val;
        }

        // right child
        dfs(node.right);
    }
}
