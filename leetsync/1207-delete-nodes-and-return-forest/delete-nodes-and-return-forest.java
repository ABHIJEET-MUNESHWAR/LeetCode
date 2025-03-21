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
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int node : toDelete) {
            toDeleteSet.add(node);
        }
        deleteUtil(root, toDeleteSet, result);
        if (!toDeleteSet.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    private TreeNode deleteUtil(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> result) {
        if (root == null) {
            return root;
        }
        root.left = deleteUtil(root.left, toDeleteSet, result);
        root.right = deleteUtil(root.right, toDeleteSet, result);
        if (toDeleteSet.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        } else {
            return root;
        }
    }
}