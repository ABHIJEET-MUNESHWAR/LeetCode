package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    zigZagLevelOrderTraversal(lists, root, 0);
    return lists;
  }

  private void zigZagLevelOrderTraversal(List<List<Integer>> lists, TreeNode root, int level) {
    if (root == null) {
      return;
    }
    int size = lists.size();
    if (size <= level) {
      lists.add(new ArrayList<>());
    }
    if (level % 2 == 0) {
      lists.get(level).add(root.val);
    } else {
      lists.get(level).add(0, root.val);
    }
    zigZagLevelOrderTraversal(lists, root.left, level + 1);
    zigZagLevelOrderTraversal(lists, root.right, level + 1);
  }
}