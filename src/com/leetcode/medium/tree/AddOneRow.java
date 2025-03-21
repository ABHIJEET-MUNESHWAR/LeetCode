package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/04/24,
 * Time:    7:44 am
 * https://leetcode.com/problems/add-one-row-to-tree/?envType=daily-question&envId=2024-04-16
 */
public class AddOneRow {
  public static void main(String[] args) {
    AddOneRow addOneRow = new AddOneRow();
    int val = 1, depth = 2;
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(1);
    root.right.left = new TreeNode(5);

//    int val = 5, depth = 4;
//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(3);
//    root.left.left = new TreeNode(4);

//    int val = 1, depth = 1;
//    TreeNode root = new TreeNode(4);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(6);
//    root.left.left = new TreeNode(3);
//    root.left.right = new TreeNode(1);
//    root.right.left = new TreeNode(5);
    //root.inorderTraversal(addOneRow.addOneRowBFS(root, val, depth));
    root.inorderTraversal(addOneRow.addOneRowDFS(root, val, depth));
  }

  private TreeNode addOneRowDFS(TreeNode root, int val, int depth) {
    if (depth == 0 || depth == 1) {
      TreeNode newRoot = new TreeNode(val);
      newRoot.left = depth == 1 ? root : null;
      newRoot.right = depth == 0 ? root : null;
      return newRoot;
    }
    if (root != null && depth >= 2) {
      root.left = addOneRowDFS(root.left, val, depth > 2 ? depth - 1 : 1);
      root.right = addOneRowDFS(root.right, val, depth > 2 ? depth - 1 : 0);
    }
    return root;
  }

  private TreeNode addOneRowDfsTwo(TreeNode root, int val, int depth) {
    if (depth == 1) {
      TreeNode newRoot = new TreeNode(val);
      newRoot.left = root;
      return newRoot;
    }
    return addDfsTwo(root, val, depth, 1);
  }

  private TreeNode addDfsTwo(TreeNode root, int val, int depth, int currentDepth) {
    if (root == null) {
      return null;
    }
    if (currentDepth == depth - 1) {
      TreeNode leftNode = root.left;
      TreeNode rightNode = root.right;

      root.left = new TreeNode(val);
      root.right = new TreeNode(val);
      root.left.left = leftNode;
      root.right.right = rightNode;
      return root;
    }
    root.left = addDfsTwo(root.left, val, depth, currentDepth + 1);
    root.right = addDfsTwo(root.right, val, depth, currentDepth + 1);
    return root;
  }

  private TreeNode addOneRowBFS(TreeNode root, int val, int depth) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (depth == 1) {
      TreeNode newNode = new TreeNode(val);
      newNode.left = root;
      root = newNode;
      queue.add(newNode);
    } else {
      queue.add(root);
    }
    int depthCounter = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      depthCounter++;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (depthCounter == depth - 1) {
          TreeNode leftVal = new TreeNode(val);
          leftVal.left = node.left;
          node.left = leftVal;
          queue.add(node.left);
          TreeNode rightVal = new TreeNode(val);
          rightVal.right = node.right;
          node.right = rightVal;
          queue.add(node.right);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
    return root;
  }
}