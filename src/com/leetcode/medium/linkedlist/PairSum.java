package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/05/24,
 * Time:    10:18 am
 * 2130. Maximum Twin Sum of a Linked List
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 */
public class PairSum {
  public static void main(String[] args) {
    PairSum pairSum = new PairSum();
    ListNode head = new ListNode(5);
    head.next = new ListNode(4);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(1);
    System.out.println(pairSum.pairSum(head));
  }

  private int pairSum(ListNode head) {
    // 1. Get the mid of linked list
    ListNode mid = getMidOfList(head);
    // 2. Reverse remaining half of linked list
    ListNode tail = reverseList(mid);
    // 3. Now find the maximum pair
    return getMaxSum(head, tail);
  }

  private ListNode getMidOfList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  private int getMaxSum(ListNode head, ListNode tail) {
    int maxSum = Integer.MIN_VALUE;
    while (head != null && tail != null) {
      maxSum = Math.max(maxSum, head.val + tail.val);
      head = head.next;
      tail = tail.next;
    }
    return maxSum;
  }
}