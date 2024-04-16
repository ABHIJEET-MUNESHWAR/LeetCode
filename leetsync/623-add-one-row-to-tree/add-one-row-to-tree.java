/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            queue.add(newNode);
            root = newNode;
        } else {
            queue.add(root);
        }
        int depthCounter = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depthCounter++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (depthCounter == depth - 1) {
                    TreeNode leftVal = new TreeNode(val);
                    leftVal.left = node.left;
                    node.left = leftVal;
                    queue.add(node.left);
                    TreeNode rightVal = new TreeNode(val);
                    rightVal.right = node.right;
                    node.right = rightVal;
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}