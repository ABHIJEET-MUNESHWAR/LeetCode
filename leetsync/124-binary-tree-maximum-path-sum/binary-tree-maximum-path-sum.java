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
    int maxSum;

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);

        int neecheHiMilGayaAnswer = left + right + root.val; //(1)
        int koiEkAccha = Math.max(left, right) + root.val; //(2)
        int onlyRootAccha = root.val; //(3)
        maxSum = Math.max(maxSum, Math.max(neecheHiMilGayaAnswer, Math.max(koiEkAccha, onlyRootAccha)));
        return Math.max(koiEkAccha, onlyRootAccha);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}