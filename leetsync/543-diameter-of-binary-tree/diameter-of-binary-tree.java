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
    public int diameter(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left, result);
        int right = diameter(root.right, result);
        result[0] = Math.max(result[0], left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = { Integer.MIN_VALUE };
        diameter(root, result);
        return result[0];
    }
}