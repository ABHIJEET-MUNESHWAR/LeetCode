package com.leetcode.easy.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/07/22, Time:    7:24 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
 */
public class PalindromeLinkedList {

  public static void main(String[] args) {
    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
    ListNode head = new ListNode(1);
    /*head.next = new ListNode(2);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(1);*/
    System.out.println("Is Palindrome? " + palindromeLinkedList.isPalindrome(head));
  }

  private boolean isPalindrome(ListNode head) {
    boolean isPalindrome = true;
    ListNode slowPointer = head;
    ListNode fastPointer = head;
    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }
    if (fastPointer != null) {
      slowPointer = slowPointer.next;
    }
    ListNode reverseHalf = reverseLinkedList(slowPointer);
    while (reverseHalf != null) {
      if (reverseHalf.val != head.val) {
        return false;
      }
      reverseHalf = reverseHalf.next;
      head = head.next;
    }
    return isPalindrome;
  }

  private ListNode reverseLinkedList(ListNode head) {
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