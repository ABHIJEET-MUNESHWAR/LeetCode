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
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = inorderCount(root);
        int index = 1;
        return dfs(root, totalNodes, index);
    }

    private boolean dfs(TreeNode root, int totalNodes, int index) {
        if (root == null) {
            return true;
        }
        if (index > totalNodes) {
            return false;
        }
        return dfs(root.left, totalNodes, 2 * index) && dfs(root.right, totalNodes, 2 * index + 1);
    }

    private int inorderCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + inorderCount(root.left) + inorderCount(root.right);
    }
}