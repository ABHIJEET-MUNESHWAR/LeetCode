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
    int sum = 0;

    public int deepestLeavesSum(TreeNode node) {
        int maxDepth = maxDepth(node);
        deepestLeavesSum(node, 1, maxDepth);
        return sum;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    private void deepestLeavesSum(TreeNode node, int currentDepth, int maxDepth) {
        if (node != null) {
            if (currentDepth == maxDepth) {
                sum += node.val;
            }
            deepestLeavesSum(node.left, currentDepth + 1, maxDepth);
            deepestLeavesSum(node.right, currentDepth + 1, maxDepth);
        }
    }
}