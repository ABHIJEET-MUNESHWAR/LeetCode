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
    private int idx;

    private TreeNode solve(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx]);
        int i = start;

        for (; i <= end; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }

        idx++;

        root.left = solve(preorder, inorder, start, i - 1);
        root.right = solve(preorder, inorder, i + 1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        idx = 0;

        return solve(preorder, inorder, 0, n - 1);

    }
}