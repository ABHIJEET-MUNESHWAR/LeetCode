package com.leetcode.easy.tree;

import com.leetcode.utils.ArrayUtils;
import com.leetcode.utils.NaryTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/09/23,
 * Time:    4:24 pm
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 */
public class NaryTreeNodePostOrder {
  public static void main(String[] args) {
    NaryTreeNodePostOrder naryTreeNodePostOrder = new NaryTreeNodePostOrder();
    NaryTreeNode root = new NaryTreeNode(1);
    root.children.add(new NaryTreeNode(3));
    root.children.add(new NaryTreeNode(2));
    root.children.add(new NaryTreeNode(4));
    root.children.get(0).children.add(new NaryTreeNode(5));
    root.children.get(0).children.add(new NaryTreeNode(6));
    ArrayUtils.printIntArray(naryTreeNodePostOrder.postOrder(root));
  }

  private List<Integer> postOrder(NaryTreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    postOrder(root, result);
    return result;


  }

  private void postOrder(NaryTreeNode root, List<Integer> result) {
    for (NaryTreeNode node : root.children) {
      postOrder(node, result);
    }
    result.add(root.val);
  }
}