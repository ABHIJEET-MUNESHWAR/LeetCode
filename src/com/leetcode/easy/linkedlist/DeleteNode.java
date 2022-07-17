package com.leetcode.easy.linkedlist;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    16/07/22, Time:    6:24 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
 */

public class DeleteNode {

  public static void main(String[] args) {
    DeleteNode deleteNode = new DeleteNode();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.printList(head);
    deleteNode.deleteNode(head);
    head.printList(head);
  }

  private void deleteNode(ListNode head) {
    head.val = head.next.val;
    head.next = head.next.next;
  }
}