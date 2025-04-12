package com.leetcode.companies.meta.practice.tree;

import com.leetcode.utils.ListUtils;
import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/06/24,
 * Time:    9:28 pm
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class RightSideView {
  public static void main(String[] args) {
    RightSideView rightSideView = new RightSideView();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(4);
    ListUtils.printList(rightSideView.rightSideViewBfs(root));
    ListUtils.printList(rightSideView.rightSideViewDfs(root));
  }

  List<Integer> list = new ArrayList<>();

  private List<Integer> rightSideViewDfs(TreeNode root) {
    if (root == null) {
      return list;
    }
    rightSideViewDfs(root, 1);
    return list;
  }

  private void rightSideViewDfs(TreeNode root, int currentLevel) {
    if (root == null) {
      return;
    }
    if (list.size() < currentLevel) {
      list.add(root.val);
    }
    rightSideViewDfs(root.right, currentLevel + 1);
    rightSideViewDfs(root.left, currentLevel + 1);
  }

  private List<Integer> rightSideViewBfs(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (i == 0) {
          list.add(node.val);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
      }
    }
    return list;
  }
}