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
        if (depth == 0 || depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = depth == 1 ? root : null;
            newRoot.right = depth == 0 ? root : null;
            return newRoot;
        }
        if (root != null && depth >= 2) {
            root.left = addOneRow(root.left, val, depth > 2 ? depth - 1 : 1);
            root.right = addOneRow(root.right, val, depth > 2 ? depth - 1 : 0);
        }
        return root;
    }
}