package com.leetcode.easy.linkedlist;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/07/22, Time:    6:19 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
 */
public class RemoveNthNodeFromEnd {

  public static void main(String[] args) {
    RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.printList(head);
    head = removeNthNodeFromEnd.removeNthNodeFromEnd(head, 1);
    head.printList(head);
  }

  private ListNode removeNthNodeFromEnd(ListNode head, int n) {
    ListNode iNode = head;
    ListNode jNode = head;
    while (n-- > 0) {
      iNode = iNode.next;
    }
    if (iNode == null) {
      return head.next;
    }
    while (iNode.next != null) {
      iNode = iNode.next;
      jNode = jNode.next;
    }
    jNode.next = jNode.next.next;
    return head;
  }
}