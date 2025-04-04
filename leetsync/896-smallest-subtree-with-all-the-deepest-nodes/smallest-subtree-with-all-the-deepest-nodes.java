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
    Map<Integer, Integer> map = new HashMap<>();
    int maxDepth = 0;

    public TreeNode lca(TreeNode root) {
        if (root == null || map.getOrDefault(root.val, -1) == maxDepth) {
            return root;
        }
        TreeNode l = lca(root.left);
        TreeNode r = lca(root.right);

        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }

    public void depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, depth);
        map.put(root.val, depth);
        depth(root.left, depth + 1);
        depth(root.right, depth + 1);
    }

    // T.C : O(n)
    // S.C : O(maxD) system recursion stack space
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth(root, 0);
        return lca(root);
    }
}