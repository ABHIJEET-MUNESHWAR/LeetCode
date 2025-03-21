package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/05/24,
 * Time:    4:58 pm
 * 894. All Possible Full Binary Trees
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 */
public class AllPossibleFBT {
  Map<Integer, List<TreeNode>> cache = new HashMap<>();

  public static void main(String[] args) {
    AllPossibleFBT allPossibleFBT = new AllPossibleFBT();
    List<TreeNode> answer = allPossibleFBT.allPossibleFBT(7);
  }

  private List<TreeNode> allPossibleFBT(int n) {
    List<TreeNode> result = new ArrayList<>();
    if (n % 2 == 0) {
      return result;
    }
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    if (n == 1) {
      result.add(new TreeNode(0));
      return result;
    }
    n--;
    for (int i = 1; i < n; i += 2) {
      List<TreeNode> left = allPossibleFBT(i);
      List<TreeNode> right = allPossibleFBT(n - i);
      for (TreeNode nl : left) {
        for (TreeNode nr : right) {
          TreeNode current = new TreeNode(0);
          current.left = nl;
          current.right = nr;
          result.add(current);
        }
      }
    }
    cache.put(n + 1, result);
    return result;
  }
}