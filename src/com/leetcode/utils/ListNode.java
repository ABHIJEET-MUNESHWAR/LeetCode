package com.leetcode.utils;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    16/07/22, Time:    6:31 AM
 */
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public void printList(ListNode head) {
    if (head == null) {
      return;
    }
    System.out.println("The list contents are:");
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }
}