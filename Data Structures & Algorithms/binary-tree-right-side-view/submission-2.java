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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root,0,result);

        List<Integer> res = new ArrayList<>();

        for (List<Integer> list: result){
            res.add(list.get(list.size() - 1));
        }

        return res;
    }

    private void dfs(TreeNode root,int level,List<List<Integer>> result){
        if (root == null) return;

        if (level == result.size()) result.add(new ArrayList<>());

        result.get(level).add(root.val);

        dfs(root.left,level+1,result);
        dfs(root.right,level +1,result);
    }
}
