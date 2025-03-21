package com.leetcode.easy.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    01/08/22, Time:    10:45 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
 */
public class LinkedListCycle {

  public static void main(String[] args) {
    LinkedListCycle linkedListCycle = new LinkedListCycle();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.printList(head);
    System.out.println("Does cycle exist: " + linkedListCycle.hasCycle(head));
    head.printList(head);
  }

  private boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}