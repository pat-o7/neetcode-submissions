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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return dfs(root, p, q);        
    }

    // return the lca
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        // at every node

        // if p is node or q is node, node is lca
        if (node == p || node == q) {
            return node;
        }

        // if p is less than node and q is greater than node, node is lca
        if (p.val < node.val && q.val > node.val) {
            return node;
        }

        // if p is greater than node and q is less than node, node is lca
        if (p.val > node.val && q.val < node.val) {
            return node;
        }


        // if p and q is greater than node, search node.right
        if (p.val > node.val && q.val > node.val) {
            return dfs(node.right, p, q);
        }

        // if p and q is less than node, search node.left
        if (p.val < node.val && q.val < node.val) {
            return dfs(node.left, p, q);
        }

        throw new IllegalArgumentException("not found");

        

    }
}
