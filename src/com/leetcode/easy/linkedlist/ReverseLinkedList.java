package com.leetcode.easy.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    21/07/22, Time:    7:53 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
 */
public class ReverseLinkedList {

  public static void main(String[] args) {
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.printList(head);
    head = reverseLinkedList.iterativeReverse(head);
    head = reverseLinkedList.recursiveReverse(head, null);
    head.printList(head);
  }

  private ListNode recursiveReverse(ListNode head, ListNode newHead) {
    if (head == null) {
      return newHead;
    }
    ListNode nextNode = head.next;
    head.next = newHead;
    newHead = head;
    return recursiveReverse(nextNode, newHead);
  }

  private ListNode iterativeReverse(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
      ListNode nextNode = head.next;
      head.next = newHead;
      newHead = head;
      head = nextNode;
    }
    return newHead;
  }
}