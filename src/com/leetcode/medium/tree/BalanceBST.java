package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/05/24,
 * Time:    2:56 pm
 * 1382. Balance a Binary Search Tree
 * https://leetcode.com/problems/balance-a-binary-search-tree/description/
 */
public class BalanceBST {
  List<Integer> sortedArray = new ArrayList<>();

  public static void main(String[] args) {
    BalanceBST balanceBST = new BalanceBST();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);
    root = balanceBST.balanceBSTApproachTwo(root);
    root = balanceBST.balanceBST(root);
  }

  private TreeNode balanceBSTApproachTwo(TreeNode root) {
    List<Integer> sortedArray = new ArrayList<>();
    inorder(root, sortedArray);
    return constructBalancedBst(sortedArray, 0, sortedArray.size() - 1);
  }

  private TreeNode constructBalancedBst(List<Integer> sortedArray, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    TreeNode root = new TreeNode(sortedArray.get(mid));
    root.left = constructBalancedBst(sortedArray, left, mid - 1);
    root.right = constructBalancedBst(sortedArray, mid + 1, right);
    return root;
  }

  private void inorder(TreeNode root, List<Integer> sortedArray) {
    if (root == null) {
      return;
    }
    inorder(root.left, sortedArray);
    sortedArray.add(root.val);
    inorder(root.right, sortedArray);
  }

  private TreeNode balanceBST(TreeNode root) {
    if (root == null) {
      return null;
    }
    convertBstToSortedArray(root);
    return balanceBST(0, sortedArray.size() - 1);
  }

  private void convertBstToSortedArray(TreeNode root) {
    if (root == null) {
      return;
    }
    convertBstToSortedArray(root.left);
    sortedArray.add(root.val);
    convertBstToSortedArray(root.right);
  }

  private TreeNode balanceBST(int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(sortedArray.get(mid));
    root.left = balanceBST(start, mid - 1);
    root.right = balanceBST(mid + 1, end);
    return root;
  }
}