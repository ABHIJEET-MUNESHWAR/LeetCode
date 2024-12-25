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

    List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }
        if (currentDepth == result.size()) {
            result.add(root.val);
        } else {
            result.set(currentDepth, Math.max(result.get(currentDepth), root.val));
        }
        dfs(root.left, currentDepth + 1);
        dfs(root.right, currentDepth + 1);
    }
}