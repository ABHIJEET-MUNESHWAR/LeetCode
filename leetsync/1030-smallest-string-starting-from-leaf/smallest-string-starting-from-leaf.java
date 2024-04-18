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
    String smallestPath = "", rootToLeafPath = "";

    public String smallestFromLeaf(TreeNode root) {
        smallestFromLeaf(root, rootToLeafPath);
        return smallestPath;
    }

    private void smallestFromLeaf(TreeNode node, String rootToLeafPath) {
        rootToLeafPath = "" + (char) ('a' + node.val) + rootToLeafPath;
        if (node.left == null && node.right == null) {
            if (smallestPath == "") {
                smallestPath = rootToLeafPath;
            } else {
                smallestPath = smallestPath.compareTo(rootToLeafPath) < 0 ? smallestPath : rootToLeafPath;
            }
        }
        if (node.left != null) {
            smallestFromLeaf(node.left, rootToLeafPath);
        }
        if (node.right != null) {
            smallestFromLeaf(node.right, rootToLeafPath);
        }
    }
}