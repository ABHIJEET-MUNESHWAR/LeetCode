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

    Map<Integer, Integer> map = new HashMap<>();

    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);
        int maxSum = Integer.MIN_VALUE;
        int maxSumLevel = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (maxSum < value) {
                maxSum = value;
                maxSumLevel = key;
            }
        }
        return maxSumLevel;
    }

    private void dfs(TreeNode root, int currentLevel) {
        if (root == null) {
            return;
        }
        dfs(root.left, currentLevel + 1);
        map.put(currentLevel, map.getOrDefault(currentLevel, 0) + root.val);
        dfs(root.right, currentLevel + 1);
    }
}