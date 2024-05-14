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
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findDiameter(root);
        return maxDiameter;
    }

    private int findDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);
        maxDiameter = Math.max(maxDiameter, leftDiameter + rightDiameter);
        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}