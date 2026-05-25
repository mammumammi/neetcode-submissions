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
    private static final String SPLITTER = ",";
    private static final String NULL_MARKER = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    private void buildString(TreeNode node,StringBuilder sb){
        if (node == null) {
            sb.append(NULL_MARKER).append(SPLITTER);
            return;
        }

        sb.append(node.val).append(SPLITTER);
        buildString(node.left,sb);
        buildString(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(SPLITTER);
        Queue<String> nodesQueue = new LinkedList<>(Arrays.asList(tokens));
        return buildTree(nodesQueue);
    }

    private TreeNode buildTree(Queue<String> nodesQueue){
        String currentToken = nodesQueue.poll();

        if (currentToken.equals(NULL_MARKER)){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(currentToken));
        root.left = buildTree(nodesQueue);
        root.right = buildTree(nodesQueue);

        return root;
    }
}
