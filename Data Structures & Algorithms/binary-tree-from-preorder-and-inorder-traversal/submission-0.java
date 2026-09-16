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

    int[] preorderArray; // 1 2 3 4 
    int preorderIndex = 0; // 1
    int[] inorderArray; // 2 1 3 4

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorderArray = preorder;
        this.inorderArray = inorder;

        return dfs(0, inorder.length - 1);
        
        
    }

    private TreeNode dfs(int left, int right) {

        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(preorderArray[preorderIndex]);
        int nodeIndex = 0;
        for (int i = left; i <= right; i++) {
            if (preorderArray[preorderIndex] == inorderArray[i]) {
                nodeIndex = i;
            }
        }

        preorderIndex++;


        // left range
        int leftnewLeft = left;
        int leftnewRight = nodeIndex - 1;

        node.left = dfs(leftnewLeft, leftnewRight);


        // right range
        int rightnewLeft = nodeIndex + 1;
        int rightnewRight = right;

        node.right = dfs(rightnewLeft, rightnewRight);

        return node;
    }
}
