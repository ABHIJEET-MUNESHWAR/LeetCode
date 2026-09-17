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
    int rootToLeafSum = 0, totalSum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, rootToLeafSum);
        return totalSum;
    }

    public void sumNumbers(TreeNode node, int rootToLeafSum) {
        rootToLeafSum = rootToLeafSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            totalSum += rootToLeafSum;
        }
        if (node.left != null) {
            sumNumbers(node.left, rootToLeafSum);
        }
        if (node.right != null) {
            sumNumbers(node.right, rootToLeafSum);
        }
    }
}