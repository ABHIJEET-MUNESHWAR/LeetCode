package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/02/24,
 * Time:    7:25 am
 * https://leetcode.com/problems/find-bottom-left-tree-value/?envType=daily-question&envId=2024-02-28
 */
public class FindBottomLeftValue {
  public static void main(String[] args) {
    FindBottomLeftValue findBottomLeftValue = new FindBottomLeftValue();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(7);
    System.out.println(findBottomLeftValue.findBottomLeftValue(root));
  }

  private int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode last = null;
    queue.add(root);
    while (!queue.isEmpty()) {
      last = queue.poll();
      if (last.right != null) {
        queue.add(last.right);
      }
      if (last.left != null) {
        queue.add(last.left);
      }
    }
    return last.val;
  }
}