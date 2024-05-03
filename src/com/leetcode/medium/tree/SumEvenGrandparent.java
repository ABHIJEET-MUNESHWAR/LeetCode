package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/05/24,
 * Time:    4:38 pm
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
 */
public class SumEvenGrandparent {
  int sum = 0;

  public static void main(String[] args) {
    SumEvenGrandparent sumEvenGrandparent = new SumEvenGrandparent();
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(7);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(7);
    root.left.left.left = new TreeNode(9);
    root.left.right.left = new TreeNode(1);
    root.left.right.right = new TreeNode(4);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(5);
    System.out.println(sumEvenGrandparent.sumEvenGrandparent(root));
  }

  private int sumEvenGrandparent(TreeNode root) {
    preOrder(root);
    return sum;
  }

  private void preOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.val % 2 == 0) {
      if (root.left != null) {
        if (root.left.left != null) {
          sum += root.left.left.val;
        }
        if (root.left.right != null) {
          sum += root.left.right.val;
        }
      }
      if (root.right != null) {
        if (root.right.left != null) {
          sum += root.right.left.val;
        }
        if (root.right.right != null) {
          sum += root.right.right.val;
        }
      }
    }
    preOrder(root.left);
    preOrder(root.right);
  }
}