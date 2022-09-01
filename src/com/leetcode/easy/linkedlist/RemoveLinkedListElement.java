package com.leetcode.easy.linkedlist;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    31/08/22, Time:    8:18 PM
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElement {

  public static void main(String[] args) {
    RemoveLinkedListElement removeLinkedListElement = new RemoveLinkedListElement();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(6);
    head.printList(head);
//    head = removeLinkedListElement.removeElementsUsingDummyNode(head, 6);
    head = removeLinkedListElement.removeElementsUsingPrevNode(head, 6);
    head.printList(head);
    ListNode head2 = new ListNode(7);
    head2.next = new ListNode(7);
    head2.next.next = new ListNode(7);
    head2.next.next.next = new ListNode(7);
    head2.printList(head2);
//    head2 = removeLinkedListElement.removeElementsUsingDummyNode(head2, 7);
    head2 = removeLinkedListElement.removeElementsUsingPrevNode(head2, 7);
    head2.printList(head2);
  }

  private ListNode removeElementsUsingPrevNode(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    ListNode prev = new ListNode(0);
    prev.next = head;
    ListNode dummy = prev;
    ListNode curr = head;
    while (curr != null) {
      if (curr.val == val) {
        prev.next = curr.next;
      } else {
        prev = curr;
      }
      curr = curr.next;
    }
    return dummy.next;
  }

  private ListNode removeElementsUsingDummyNode(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;
    while (curr.next != null) {
      if (curr.next.val == val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }
    return dummy.next;
  }
}