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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = getLca(root, startValue, destValue);
        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();
        dfs(lca, startValue, lcaToStart);
        dfs(lca, destValue, lcaToDest);
        String answer = "";
        int leftPathLen = lcaToStart.length();
        for (int i = 0; i < leftPathLen; i++) {
            answer += "U";
        }
        return answer + lcaToDest.toString();
    }

    private boolean dfs(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        path.append("L");
        if (dfs(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        path.append("R");
        if (dfs(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }

    private TreeNode getLca(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return null;
        }
        if (root.val == startValue || root.val == destValue) {
            return root;
        }
        TreeNode left = getLca(root.left, startValue, destValue);
        TreeNode right = getLca(root.right, startValue, destValue);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}