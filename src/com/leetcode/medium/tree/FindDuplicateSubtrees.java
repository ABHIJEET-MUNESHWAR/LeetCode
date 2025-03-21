package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/06/24,
 * Time:    11:43 pm
 * 652. Find Duplicate Subtrees
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 */
public class FindDuplicateSubtrees {
  public static void main(String[] args) {
    FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    root.right.left.left = new TreeNode(4);
    List<TreeNode> treeNodes = findDuplicateSubtrees.findDuplicateSubtrees(root);
  }


  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Integer> paths = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    dfs(root, paths, result);
    return result;
  }

  private String dfs(TreeNode root, Map<String, Integer> paths, List<TreeNode> result) {
    if (root == null) {
      return "NULL";
    }
    String path = root.val + "," + dfs(root.left, paths, result) + "," + dfs(root.right, paths, result);
    if (paths.containsKey(path) && paths.get(path) == 1) {
      result.add(root);
    }
    paths.put(path, paths.getOrDefault(path, 0) + 1);
    return path;
  }
}