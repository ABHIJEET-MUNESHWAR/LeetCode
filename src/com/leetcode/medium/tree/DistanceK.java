package com.leetcode.medium.tree;

import com.leetcode.utils.ListUtils;
import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/07/24,
 * Time:    9:11 am
 * 863. All Nodes Distance K in Binary Tree
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 */
public class DistanceK {
  public static void main(String[] args) {
    DistanceK distanceK = new DistanceK();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    TreeNode target = root.left;
    int k = 2;
    ListUtils.printList(distanceK.distanceK(root, target, k));
  }

  Map<TreeNode, TreeNode> childToParentMap = new HashMap<>();
  List<Integer> result = new ArrayList<>();

  private List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    assignParent(root);
    bfs(root, target, k);
    return result;
  }

  private void bfs(TreeNode root, TreeNode target, int k) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    queue.add(target);
    visited.add(target.val);
    int currentLevel = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (currentLevel == k) {
          result.add(node.val);
        }
        if (node.left != null && !visited.contains(node.left.val)) {
          queue.add(node.left);
          visited.add(node.left.val);
        }
        if (node.right != null && !visited.contains(node.right.val)) {
          queue.add(node.right);
          visited.add(node.right.val);
        }
        if (childToParentMap.containsKey(node) && !visited.contains(childToParentMap.get(node).val)) {
          queue.add(childToParentMap.get(node));
          visited.add(childToParentMap.get(node).val);
        }
      }
      currentLevel++;
    }
  }

  private void assignParent(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      childToParentMap.put(root.left, root);
    }
    assignParent(root.left);
    if (root.right != null) {
      childToParentMap.put(root.right, root);
    }
    assignParent(root.right);
  }
}