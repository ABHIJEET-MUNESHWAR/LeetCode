package com.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    07/08/22, Time:    10:35 AM
 */
public class SpiralLevelOrderTraversal {

  public static void main(String[] args) {
    SpiralLevelOrderTraversal levelOrderTraversal = new SpiralLevelOrderTraversal();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    List<List<Integer>> lists = levelOrderTraversal.levelOrderTraversal(root);
    for (List list : lists) {
      for (Object item : list) {
        System.out.print(item + ", ");
      }
      System.out.println();
    }
  }

  private List<List<Integer>> levelOrderTraversal(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if (root == null) {
      return lists;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < qSize; i++) {
        TreeNode node = queue.remove();
        list.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      lists.add(list);
    }
    return lists;
  }
}