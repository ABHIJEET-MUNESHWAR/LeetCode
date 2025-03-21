package com.leetcode.easy.tree;

import com.leetcode.utils.ArrayUtils;
import com.leetcode.utils.NaryTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    4:21 pm
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class NaryTreeNodePreOrder {
  public static void main(String[] args) {
    NaryTreeNodePreOrder naryTreeNodePreOrder = new NaryTreeNodePreOrder();
    NaryTreeNode root = new NaryTreeNode(1);
    root.children.add(new NaryTreeNode(3));
    root.children.add(new NaryTreeNode(2));
    root.children.add(new NaryTreeNode(4));
    root.children.get(0).children.add(new NaryTreeNode(5));
    root.children.get(0).children.add(new NaryTreeNode(6));
    ArrayUtils.printIntArray(naryTreeNodePreOrder.naryTreeNodePreOrder(root));
  }

  private List<Integer> naryTreeNodePreOrder(NaryTreeNode root) {
    List<Integer> answer = new ArrayList<>();
    if (root == null) {
      return answer;
    }
    naryTreeNodePreOrder(root, answer);
    return answer;
  }

  private void naryTreeNodePreOrder(NaryTreeNode root, List<Integer> answer) {
    answer.add(root.val);
    for (NaryTreeNode n : root.children) {
      naryTreeNodePreOrder(n, answer);
    }
  }
}