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
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, 0) >= 0;
      }

      private int isBalanced(TreeNode root, int height) {
        if (root == null) {
          return height;
        }
        int leftHeight = isBalanced(root.left, height + 1);
        int rightHeight = isBalanced(root.right, height + 1);
        if (leftHeight < 0 || rightHeight <= 0 || Math.abs(leftHeight - rightHeight) > 1) {
          return -1;
        }
        return Math.max(leftHeight, rightHeight);
      }
}