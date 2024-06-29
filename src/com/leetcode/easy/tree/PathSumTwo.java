package com.leetcode.easy.tree;

import com.leetcode.utils.ListUtils;
import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/06/24,
 * Time:    3:24 pm
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/description/
 */
public class PathSumTwo {
  public static void main(String[] args) {
    PathSumTwo pathSumTwo = new PathSumTwo();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    int targetSum = 22;
    ListUtils.printLists(pathSumTwo.pathSum(root, targetSum));
  }

  private List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    collectPaths(root, 0, targetSum, path, paths);
    return paths;
  }

  private void collectPaths(TreeNode root, int currentSum, int targetSum, List<Integer> path, List<List<Integer>> paths) {
    if (root == null) {
      return;
    }
    currentSum += root.val;
    path.add(root.val);
    if (root.left == null && root.right == null && currentSum == targetSum) {
      paths.add(new ArrayList<>(path));
    } else {
      collectPaths(root.left, currentSum, targetSum, path, paths);
      collectPaths(root.right, currentSum, targetSum, path, paths);
    }
    path.remove(path.size() - 1);
  }
}