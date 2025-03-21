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

    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return list;
        }
        rightSideView(root, 1);
        return list;
    }

    private void rightSideView(TreeNode root, int currentLevel) {
        if (root == null) {
            return;
        }
        if (list.size() < currentLevel) {
            list.add(root.val);
        }
        rightSideView(root.right, currentLevel + 1);
        rightSideView(root.left, currentLevel + 1);
    }
}