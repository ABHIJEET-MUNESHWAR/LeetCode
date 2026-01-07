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

    int mod = 1000000007;
    long maxProduct = 0;
    long totalSum = 0;

    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        totalSum = findMaxProduct(root);
        findMaxProduct(root);
        return (int) (maxProduct % mod);
    }

    private int findMaxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = findMaxProduct(root.left);
        int rightSum = findMaxProduct(root.right);
        int subTreeSum = leftSum + rightSum + root.val;
        long remainingSubTreeSum = totalSum - subTreeSum;
        maxProduct = Math.max(maxProduct, remainingSubTreeSum * subTreeSum);
        return subTreeSum;
    }
}