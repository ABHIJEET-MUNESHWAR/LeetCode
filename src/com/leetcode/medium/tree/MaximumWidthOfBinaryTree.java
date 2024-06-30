package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/07/24,
 * Time:    1:43 am
 * 662. Maximum Width of Binary Tree
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 */
public class MaximumWidthOfBinaryTree {
  public static void main(String[] args) {
    MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(9);
    System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(root));
  }

  class Node {
    TreeNode node;
    int index;

    public Node(TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }
  }

  private int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(root, 0));
    int max = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      int start = 0, end = 0;
      for (int i = 0; i < size; i++) {
        Node eachNode = queue.poll();
        int index = eachNode.index;
        if (i == 0) {
          start = index;
        }
        if (i == size - 1) {
          end = index;
        }
        if (eachNode.node.left != null) {
          queue.add(new Node(eachNode.node.left, 2 * eachNode.index));
        }
        if (eachNode.node.right != null) {
          queue.add(new Node(eachNode.node.right, 2 * eachNode.index + 1));
        }
      }
      max = Math.max(max, end - start + 1);
    }
    return max;
  }
}