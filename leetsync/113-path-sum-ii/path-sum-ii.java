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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        collectPaths(root, 0, targetSum, path, paths);
        return paths;
    }

    private void collectPaths(TreeNode root, int currentSum, int targetSum, List<Integer> path,
            List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && currentSum == targetSum) {
            paths.add(new ArrayList<>(path));
        } else {
            collectPaths(root.left, currentSum, targetSum, path, paths);
            collectPaths(root.right, currentSum, targetSum, path, paths);
        }
        path.remove(path.size() - 1);
    }
}