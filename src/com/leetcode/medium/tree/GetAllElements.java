package com.leetcode.medium.tree;

import com.leetcode.utils.ListUtils;
import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    1:52 pm
 * 1305. All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/
 */
public class GetAllElements {
  public static void main(String[] args) {
    GetAllElements getAllElements = new GetAllElements();
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(4);
    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(0);
    root2.right = new TreeNode(3);
    ListUtils.printList(getAllElements.getAllElements(root1, root2));
  }


  private List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> answer = new ArrayList<>();
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
      while (root1 != null) {
        stack1.push(root1);
        root1 = root1.left;
      }
      while (root2 != null) {
        stack2.push(root2);
        root2 = root2.left;
      }
      if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val <= stack2.peek().val)) {
        root1 = stack1.pop();
        answer.add(root1.val);
        root1 = root1.right;
      } else {
        root2 = stack2.pop();
        answer.add(root2.val);
        root2 = root2.right;
      }
    }
    return answer;
  }
}