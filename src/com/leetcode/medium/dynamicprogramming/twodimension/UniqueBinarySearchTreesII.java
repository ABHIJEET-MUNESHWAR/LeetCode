package com.leetcode.medium.dynamicprogramming.twodimension;

import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/06/24,
 * Time:    11:03 pm
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 */
public class UniqueBinarySearchTreesII {
  public static void main(String[] args) {
    UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
    int n = 3;
    System.out.println(uniqueBinarySearchTreesII.generateTreesRecursion(n));
    System.out.println(uniqueBinarySearchTreesII.generateTreesRecursionMemoization(n));
  }

  List<TreeNode>[][] dp;

  private List<TreeNode> generateTreesRecursionMemoization(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    // Initialize dp array
    dp = new List[n + 1][n + 1];
    return solveRecursionMemoization(1, n);
  }

  private List<TreeNode> solveRecursionMemoization(int start, int end) {
    List<TreeNode> result = new ArrayList<>();

    if (start > end) {
      result.add(null); // Base case: return null for empty subtree
      return result;
    }

    // Check if result for this range is already computed
    if (dp[start][end] != null) {
      return dp[start][end];
    }

    // Generate all possible BSTs for current range [start, end]
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftSubtrees = solveRecursionMemoization(start, i - 1);
      List<TreeNode> rightSubtrees = solveRecursionMemoization(i + 1, end);

      // Combine left and right subtrees with current root i
      for (TreeNode left : leftSubtrees) {
        for (TreeNode right : rightSubtrees) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          result.add(root);
        }
      }
    }
    // Memoize the result
    dp[start][end] = result;
    return result;
  }

  private List<TreeNode> generateTreesRecursion(int n) {
    return solveRecursion(1, n);
  }

  private List<TreeNode> solveRecursion(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }
    if (start == end) {
      TreeNode root = new TreeNode(start);
      result.add(root);
      return result;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftBST = solveRecursion(start, i - 1);
      List<TreeNode> rightBST = solveRecursion(i + 1, end);
      for (TreeNode leftBSTNode : leftBST) {
        for (TreeNode rightBSTNode : rightBST) {
          TreeNode root = new TreeNode(i, leftBSTNode, rightBSTNode);
          result.add(root);
        }
      }
    }
    return result;
  }
}