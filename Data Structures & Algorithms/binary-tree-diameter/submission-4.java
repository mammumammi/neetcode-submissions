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
    private int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxD = 0;
        getHeight(root);
        return maxD;
    }

    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        maxD = Math.max(maxD,left + right);

        return 1 + Math.max(left,right);
    }
}
