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
    public List<TreeNode> generateTrees(int n) {
        return solveRecursion(1, n);
    }

    private List<TreeNode> solveRecursion(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            TreeNode root = new TreeNode(start);
            result.add(root);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftBST = solveRecursion(start, i - 1);
            List<TreeNode> rightBST = solveRecursion(i + 1, end);
            for (TreeNode leftBSTNode : leftBST) {
                for (TreeNode rightBSTNode : rightBST) {
                    TreeNode root = new TreeNode(i, leftBSTNode, rightBSTNode);
                    result.add(root);
                }
            }
        }
        return result;
    }
}