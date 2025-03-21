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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int inStart = 0;
        int postStart = 0;
        int inEnd = n - 1;
        int postEnd = n - 1;
        return solve(inorder, postorder, inStart, inEnd, postStart, postEnd);
    }

    private TreeNode solve(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        int leftSize = i - inStart;
        int rightSize = inEnd - i;
        root.left = solve(inorder, postorder, inStart, i - 1, postStart, postStart + leftSize - 1);
        root.right = solve(inorder, postorder, i + 1, inEnd, postEnd - rightSize, postEnd - 1);
        return root;
    }
}