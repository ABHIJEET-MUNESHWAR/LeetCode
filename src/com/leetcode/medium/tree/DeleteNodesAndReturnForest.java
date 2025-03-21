package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/06/24,
 * Time:    10:59 am
 * 1110. Delete Nodes And Return Forest
 * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
 */
public class DeleteNodesAndReturnForest {
  public static void main(String[] args) {
    DeleteNodesAndReturnForest deleteNodesAndReturnForest = new DeleteNodesAndReturnForest();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    int[] to_delete = {3, 2};
    List<TreeNode> disjointRoots = deleteNodesAndReturnForest.delNodes(root, to_delete);
  }

  private List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
    List<TreeNode> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Set<Integer> toDeleteSet = new HashSet<>();
    for (int node : toDelete) {
      toDeleteSet.add(node);
    }
    deleteUtil(root, toDeleteSet, result);
    if (!toDeleteSet.contains(root.val)) {
      result.add(root);
    }
    return result;
  }

  private TreeNode deleteUtil(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> result) {
    if (root == null) {
      return root;
    }
    root.left = deleteUtil(root.left, toDeleteSet, result);
    root.right = deleteUtil(root.right, toDeleteSet, result);
    if (toDeleteSet.contains(root.val)) {
      if (root.left != null) {
        result.add(root.left);
      }
      if (root.right != null) {
        result.add(root.right);
      }
      return null;
    } else {
      return root;
    }
  }
}