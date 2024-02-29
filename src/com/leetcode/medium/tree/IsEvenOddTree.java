package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/02/24,
 * Time:    7:18 am
 * https://leetcode.com/problems/even-odd-tree/description/?envType=daily-question&envId=2024-02-29
 */
public class IsEvenOddTree {
  public static void main(String[] args) {
    IsEvenOddTree isEvenOddTree = new IsEvenOddTree();
    /*TreeNode root = new TreeNode(1);
    root.left = new TreeNode(10);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(12);
    root.left.left.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.right.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(2);*/
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(7);
    System.out.println(isEvenOddTree.isEvenOddTree(root));
  }

  private boolean isEvenOddTree(TreeNode root) {
    boolean isEvenOddTree = true;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isEvenLevel = true;
    int previousValue = 0;
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        root = queue.poll();
        if (isEvenLevel) {
          if (isEven(root.val)) {
            return false;
          }
          if (i > 0 && root.val <= previousValue) {
            return false;
          }
        } else {
          if (isOdd(root.val)) {
            return false;
          }
          if (i > 0 && root.val >= previousValue) {
            return false;
          }
        }
        if (root.left != null) {
          queue.add(root.left);
        }
        if (root.right != null) {
          queue.add(root.right);
        }
        previousValue = root.val;
      }
      isEvenLevel = !isEvenLevel;
    }
    return isEvenOddTree;
  }

  private boolean isEven(int val) {
    return (val % 2) == 0;
  }

  private boolean isOdd(int val) {
    return (val % 2) != 0;
  }
}