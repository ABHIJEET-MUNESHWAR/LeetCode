package com.leetcode.hard.tree;

import com.leetcode.utils.ListUtils;
import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/03/24,
 * Time:    8:56 am
 * 987. Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 */
public class VerticalTraversal {
  List<Location> locations = new ArrayList<>();

  class Location implements Comparable<Location> {
    int x, y, value;

    public Location(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }

    @Override
    public int compareTo(Location l) {
      if (this.x != l.x) {
        return Integer.compare(this.x, l.x);
      } else if (this.y != l.y) {
        return Integer.compare(l.y, this.y);
      } else {
        return Integer.compare(this.value, l.value);
      }
    }
  }

  public static void main(String[] args) {
    VerticalTraversal verticalTraversal = new VerticalTraversal();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    ListUtils.printLists(verticalTraversal.verticalTraversal(root));
  }

  private List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> answer = new ArrayList<>();
    dfs(root, 0, 0);
    Collections.sort(locations);
    int x = locations.get(0).x;
    answer.add(new ArrayList<>());
    for (Location location : locations) {
      if (x != location.x) {
        x = location.x;
        answer.add(new ArrayList<>());
      }
      answer.get(answer.size() - 1).add(location.value);
    }
    return answer;
  }

  private void dfs(TreeNode root, int x, int y) {
    if (root != null) {
      locations.add(new Location(x, y, root.val));
      dfs(root.left, x - 1, y - 1);
      dfs(root.right, x + 1, y - 1);
    }
  }
}