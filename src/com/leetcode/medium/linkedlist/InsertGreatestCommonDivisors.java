package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/04/24,
 * Time:    10:43 am
 * https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
 * 2807. Insert Greatest Common Divisors in Linked List
 */
public class InsertGreatestCommonDivisors {
  public static void main(String[] args) {
    InsertGreatestCommonDivisors insertGreatestCommonDivisors = new InsertGreatestCommonDivisors();
    ListNode head = new ListNode(18);
    head.next = new ListNode(6);
    head.next.next = new ListNode(10);
    head.next.next.next = new ListNode(3);
    head.printList(insertGreatestCommonDivisors.insertGreatestCommonDivisors(head));
  }

  private ListNode insertGreatestCommonDivisors(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    int a = 0, b = 0;
    ListNode current = head;
    while (current.next != null) {
      a = current.val;
      b = current.next.val;
      ListNode gcdNode = new ListNode(gcd(a, b));
      gcdNode.next = current.next;
      current.next = gcdNode;
      current = gcdNode.next;
    }
    return head;
  }

  private int gcd(int a, int b) {
    while (a > 0 && b > 0) {
      if (a > b) {
        a = a % b;
      } else {
        b = b % a;
      }
    }
    if (a == 0) {
      return b;
    } else {
      return a;
    }
  }
}