package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    06/12/22, Time:    8:02 am
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class EvenOddLinkedList {

  public static void main(String[] args) {
    EvenOddLinkedList evenOddLinkedList = new EvenOddLinkedList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNode newHead = evenOddLinkedList.oddEvenList2(head);
    newHead.printList(newHead);
  }

  private ListNode oddEvenList2(ListNode head) {
    if (head != null) {
      ListNode odd = head, evenHead = head.next, even = evenHead;
      while (even != null && even.next != null) {
        odd.next = odd.next.next;
        even.next = even.next.next;
        odd = odd.next;
        even = even.next;
      }
      odd.next = evenHead;
    }
    return head;
  }

  private ListNode oddEvenList1(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode evenHead = new ListNode(0), oddHead = new ListNode(0);
    ListNode curr = head, currEven = evenHead, currOdd = oddHead;
    while (curr != null && curr.next != null) {
      currOdd.next = curr;
      currEven.next = curr.next;
      curr = curr.next.next;
      currEven = currEven.next;
      currOdd = currOdd.next;
    }
    if (curr != null) {
      currOdd.next = curr;
      currEven.next = curr.next;
      currEven = currEven.next;
      currOdd = currOdd.next;
    }
    currOdd.next = evenHead.next;
    return oddHead.next;
  }
}