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

    Map<Integer, Integer> levelToMaxValueMap = new HashMap<>();

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        for (Map.Entry<Integer, Integer> entry : levelToMaxValueMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private void dfs(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }
        dfs(root.left, currentDepth + 1);
        if (levelToMaxValueMap.containsKey(currentDepth)) {
            if (levelToMaxValueMap.get(currentDepth) < root.val) {
                levelToMaxValueMap.put(currentDepth, root.val);
            }
        } else {
            levelToMaxValueMap.put(currentDepth, root.val);
        }
        dfs(root.right, currentDepth + 1);
    }
}