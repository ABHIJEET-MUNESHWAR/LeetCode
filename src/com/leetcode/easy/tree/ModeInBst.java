package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/10/22, Time:    8:44 AM
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class ModeInBst {

  int maxCount = 1;

  public static void main(String[] args) {
    ModeInBst modeInBst = new ModeInBst();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(2);
    int[] modes = modeInBst.findMode(root);
    //
  }

  public int[] findMode(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    findMode(root, map);

    int[] result = new int[map.size()];
    int index = 0;
    for (Integer key : map.keySet()) {
      if (map.get(key) == maxCount) {
        result[index++] = key;
      }
    }

    return Arrays.copyOf(result, index);
  }

  private void findMode(TreeNode root, Map<Integer, Integer> map) {
    if (root == null) {
      return;
    } else if (map.containsKey(root.val)) {
      int count = map.get(root.val) + 1;
      map.put(root.val, count);
      maxCount = Math.max(maxCount, count);
    } else {
      map.put(root.val, 1);
    }

    findMode(root.left, map);
    findMode(root.right, map);
  }
}