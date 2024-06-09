package com.leetcode.medium.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/06/24,
 * Time:    4:45 pm
 * 1361. Validate Binary Tree Nodes
 * https://leetcode.com/problems/validate-binary-tree-nodes/description/
 */
public class ValidateBinaryTreeNodes {
  public static void main(String[] args) {
    ValidateBinaryTreeNodes validateBinaryTreeNodes = new ValidateBinaryTreeNodes();
    int n = 4;
    int[] leftChild = {1, -1, 3, -1};
    int[] rightChild = {2, 3, -1, -1};
    System.out.println(validateBinaryTreeNodes.validateBinaryTreeNodes(n, leftChild, rightChild));
  }

  private int[] parent;
  private int components;

  private int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  private boolean union(int par, int child) {
    int childParent = find(child);
    if (childParent != child) {
      return false;
    }

    int parentParent = find(par);
    if (parentParent == childParent) {
      return false;
    }

    parent[child] = par;
    components--;
    return true;
  }

  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    components = n;
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < n; i++) {
      if (leftChild[i] != -1 && !union(i, leftChild[i])) {
        return false;
      }
      if (rightChild[i] != -1 && !union(i, rightChild[i])) {
        return false;
      }
    }

    return components == 1;
  }
}