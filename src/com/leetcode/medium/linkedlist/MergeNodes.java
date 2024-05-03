package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/05/24,
 * Time:    10:19 am
 * https://leetcode.com/problems/merge-nodes-in-between-zeros/
 */
public class MergeNodes {
  public static void main(String[] args) {
    MergeNodes mergeNodes = new MergeNodes();
    ListNode head = new ListNode(0);
    head.next = new ListNode(3);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(0);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next = new ListNode(2);
    head.next.next.next.next.next.next.next = new ListNode(0);
    head.printList(mergeNodes.mergeNodes(head));
  }

  private ListNode mergeNodes(ListNode head) {
    ListNode dummyHead = new ListNode(0);
    ListNode dummyHeadIterator = dummyHead;
    ListNode current = head.next;
    int sum = 0;
    while (current != null) {
      sum += current.val;
      if (current.val == 0) {
        ListNode node = new ListNode(sum);
        if (dummyHeadIterator == null) {
          dummyHeadIterator = node;
        } else {
          dummyHeadIterator.next = node;
          dummyHeadIterator = dummyHeadIterator.next;
        }
        sum = 0;
      }
      current = current.next;
    }
    return dummyHead.next;
  }
}