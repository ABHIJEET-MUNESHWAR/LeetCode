package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/06/24,
 * Time:    12:50 am
 */
public class ReverseLinkedListTwo {
  public static void main(String[] args) {
    ReverseLinkedListTwo reverseLinkedListTwo = new ReverseLinkedListTwo();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    int left = 2, right = 4;
    ListNode reversedList = reverseLinkedListTwo.reverseBetween(head, left, right);
    reversedList.printList(reversedList);
  }

  private ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    for (int i = 0; i < left - 1; i++) {
      pre = pre.next;
    }
    ListNode cur = pre.next;
    for (int i = 0; i < right - left; i++) {
      ListNode forward = cur.next;
      cur.next = forward.next;
      forward.next = pre.next;
      pre.next = forward;
    }
    return dummy.next;
  }
}