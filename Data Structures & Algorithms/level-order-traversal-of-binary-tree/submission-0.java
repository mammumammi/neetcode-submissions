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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        helper(root,0,levels);
        return levels;
    }

    private void helper(TreeNode node,int depth,List<List<Integer>> levels){
        if (node == null){
            return;
        }

        if (levels.size()==depth){
            levels.add(new ArrayList<>());
        }

        levels.get(depth).add(node.val);

        helper(node.left,depth+1,levels);
        helper(node.right,depth+1,levels);
    }
}
