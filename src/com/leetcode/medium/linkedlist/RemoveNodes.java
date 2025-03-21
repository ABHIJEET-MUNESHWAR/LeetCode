package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/05/24,
 * Time:    8:36 am
 * 2487. Remove Nodes From Linked List
 * https://leetcode.com/problems/remove-nodes-from-linked-list/description/?envType=daily-question&envId=2024-05-06
 */
public class RemoveNodes {
  public static void main(String[] args) {
    RemoveNodes removeNodes = new RemoveNodes();
    ListNode head = new ListNode(5);
    head.next = new ListNode(2);
    head.next.next = new ListNode(13);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(8);
    //head.printList(removeNodes.removeNodesRecursively(head));
    //head.printList(removeNodes.removeNodesUsingStack(head));
    head.printList(removeNodes.removeNodesUsingReverseAndRemove(head));
  }

  private ListNode removeNodesUsingReverseAndRemove(ListNode head) {
    ListNode tail = reverseList(head);
    ListNode current = tail;
    // 5, 2, 13, 3, 8
    // 8, 3, 13, 2, 5
    int max = current.val;
    while (current.next != null) {
      if (max > current.next.val) {
        current.next = current.next.next;
      } else {
        current = current.next;
        max = current.val;
      }
    }
    return reverseList(tail);
  }

  private ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  private ListNode removeNodesUsingStack(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode current = head;
    while (current != null) {
      if (stack.isEmpty()) {
        stack.push(current);
      } else {
        while ((!stack.isEmpty()) && (stack.peek().val < current.val)) {
          stack.pop();
        }
        stack.push(current);
      }
      current = current.next;
    }
    while (stack.size() > 1) {
      ListNode node = stack.pop();
      stack.peek().next = node;
    }
    return stack.peek();
  }

  private ListNode removeNodesRecursively(ListNode head) {
    if (head == null) {
      return null;
    }
    head.next = removeNodesRecursively(head.next);
    return head.next != null && head.val < head.next.val ? head.next : head;
  }
}