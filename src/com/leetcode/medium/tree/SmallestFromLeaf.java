package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    18/04/24,
 * Time:    7:39 am
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/?envType=daily-question&envId=2024-04-17
 * 988. Smallest String Starting From Leaf
 */
public class SmallestFromLeaf {
  String smallestPath = "", rootToLeafPath = "";

  public static void main(String[] args) {
    SmallestFromLeaf smallestFromLeaf = new SmallestFromLeaf();
    TreeNode root = new TreeNode(25);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(2);
    System.out.println(smallestFromLeaf.smallestFromLeaf(root));
  }

  private String smallestFromLeaf(TreeNode root) {
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