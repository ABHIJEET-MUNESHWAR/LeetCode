package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/07/24,
 * Time:    9:24 am
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/?envType=daily-question&envId=2024-07-16
 */
public class GetDirections {
    public static void main(String[] args) {
        GetDirections getDirections = new GetDirections();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        int startValue = 3;
        int destValue = 6;
        System.out.println(getDirections.getDirectionsUsingLCA(root, startValue, destValue));
        System.out.println(getDirections.getDirectionsUsingRootToNodePath(root, startValue, destValue));
    }

    private String getDirectionsUsingRootToNodePath(TreeNode root, int startValue, int destValue) {
        StringBuilder rootToStart = new StringBuilder();
        StringBuilder rootToDest = new StringBuilder();
        dfs(root, startValue, rootToStart);
        dfs(root, destValue, rootToDest);
        String answer = "";
        int l = 0;
        while (l < rootToDest.length() && l < rootToStart.length() && rootToStart.charAt(l) == rootToDest.charAt(l)) {
            l++;
        }
        for (int i = l; i < rootToStart.length(); i++) {
            answer += "U";
        }
        for (int i = l; i < rootToDest.length(); i++) {
            answer += rootToDest.charAt(i);
        }
        return answer;
    }

    private String getDirectionsUsingLCA(TreeNode root, int startValue, int destValue) {
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