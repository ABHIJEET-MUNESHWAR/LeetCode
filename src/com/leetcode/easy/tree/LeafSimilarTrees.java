package com.leetcode.easy.tree;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.TreeNode;

import java.util.ArrayList;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    08/12/22, Time:    11:29 pm
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {

  public static void main(String[] args) {
    LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(2);
    System.out.println(leafSimilarTrees.leafSimilar(root1, root2));
  }

  private boolean leafSimilar(TreeNode root1, TreeNode root2) {
    return traverse(root1).equals(traverse(root2));
  }

  private String traverse(TreeNode root) {
    if (root == null) {
      return "";
    }
    if (root.left == null && root.right == null) {
      return root.val + "-";
    }
    return traverse(root.left) + traverse(root.right);
  }
}