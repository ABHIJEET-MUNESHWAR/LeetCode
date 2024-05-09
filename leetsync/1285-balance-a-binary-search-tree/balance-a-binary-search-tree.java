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
    List<Integer> sortedArray = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBstToSortedArray(root);
        return balanceBST(0, sortedArray.size() - 1);
    }

    private void convertBstToSortedArray(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBstToSortedArray(root.left);
        sortedArray.add(root.val);
        convertBstToSortedArray(root.right);
    }

    private TreeNode balanceBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sortedArray.get(mid));
        root.left = balanceBST(start, mid - 1);
        root.right = balanceBST(mid + 1, end);
        return root;
    }
}