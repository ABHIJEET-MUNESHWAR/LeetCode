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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedArray = new ArrayList<>();
        inorder(root, sortedArray);
        return constructBalancedBst(sortedArray, 0, sortedArray.size() - 1);
    }

    private TreeNode constructBalancedBst(List<Integer> sortedArray, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(sortedArray.get(mid));
        root.left = constructBalancedBst(sortedArray, left, mid - 1);
        root.right = constructBalancedBst(sortedArray, mid + 1, right);
        return root;
    }

    private void inorder(TreeNode root, List<Integer> sortedArray) {
        if (root == null) {
            return;
        }
        inorder(root.left, sortedArray);
        sortedArray.add(root.val);
        inorder(root.right, sortedArray);
    }
}