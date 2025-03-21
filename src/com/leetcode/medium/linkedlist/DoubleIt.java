package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/05/24,
 * Time:    6:42 am
 * 2816. Double a Number Represented as a Linked List
 * https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/?envType=daily-question&envId=2024-05-07
 */
public class DoubleIt {
  public static void main(String[] args) {
    DoubleIt doubleIt = new DoubleIt();
    ListNode head = new ListNode(9);
    head.next = new ListNode(9);
    head.next.next = new ListNode(9);
    /*ListNode head = new ListNode(1);
    head.next = new ListNode(8);
    head.next.next = new ListNode(9);*/
    //ListNode head = new ListNode(5);
    //ListNode head = new ListNode(1);
    //ListNode head = new ListNode(5);
    //head.next = new ListNode(0);
    head.printList(doubleIt.doubleIt(head));
  }

  public ListNode doubleIt(ListNode head) {
    ListNode tail = reverseList(head);
    ListNode current = tail;
    int carry = 0;
    while (current != null) {
      int multiplication = current.val * 2 + carry;
      carry = multiplication / 10;
      current.val = multiplication % 10;
      current = current.next;
    }
    head = reverseList(tail);
    if (carry != 0) {
      head = new ListNode(carry, head);
    }
    return head;
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}