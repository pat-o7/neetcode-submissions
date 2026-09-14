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

    boolean same = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {

        dfs(p, q);
        return same;        
    }

    private void dfs(TreeNode p, TreeNode q) {
        if (!same) {
            return;
        }
        if (p != null && q != null) {
            if (p.val != q.val) {
                same = false;
            }
            dfs(p.left, q.left);
            dfs(p.right, q.right);            
        } else if (p == null && q == null) {
            same = true;
        } else {
            same = false;
        }
    

    }
}
