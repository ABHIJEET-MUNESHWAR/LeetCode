package com.leetcode.easy.tree;

import com.leetcode.utils.NaryTreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    26/11/22, Time:    1:17 pm
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaxDepthOfNaryTree {

  public static void main(String[] args) {
    MaxDepthOfNaryTree maxDepthOfNaryTree = new MaxDepthOfNaryTree();
    NaryTreeNode root = new NaryTreeNode(1);
    root.children.add(new NaryTreeNode(3));
    root.children.add(new NaryTreeNode(2));
    root.children.add(new NaryTreeNode(4));
    root.children.get(0).children.add(new NaryTreeNode(5));
    root.children.get(0).children.add(new NaryTreeNode(6));
    System.out.println(maxDepthOfNaryTree.maxDepth(root));
  }

  private int maxDepth(NaryTreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxDepth = 0;
    for (NaryTreeNode child : root.children) {
      maxDepth = Math.max(maxDepth, maxDepth(child));
    }
    return maxDepth + 1;
  }
}