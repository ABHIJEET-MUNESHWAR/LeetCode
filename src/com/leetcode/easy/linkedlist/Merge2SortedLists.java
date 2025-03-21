package com.leetcode.easy.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    26/07/22, Time:    8:43 AM
 */
public class Merge2SortedLists {

  public static void main(String[] args) {
    Merge2SortedLists merge2SortedLists = new Merge2SortedLists();
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(4);
    head1.printList(head1);
    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(3);
    head2.next.next = new ListNode(4);
    head2.printList(head2);
    //ListNode head3 = merge2SortedLists.merge2SortedListsIterative(head1, head2);
    ListNode head3 = merge2SortedLists.merge2SortedListsRecursive(head1, head2);
    head3.printList(head3);
  }

  private ListNode merge2SortedListsRecursive(ListNode head1, ListNode head2) {
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    if (head1.val < head2.val) {
      head1.next = merge2SortedListsRecursive(head1.next, head2);
      return head1;
    } else {
      head2.next = merge2SortedListsRecursive(head1, head2.next);
      return head2;
    }
  }

  private ListNode merge2SortedListsIterative(ListNode head1, ListNode head2) {
    ListNode dummy = new ListNode(0);
    ListNode head3 = dummy;
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    while (head1 != null && head2 != null) {
      if (head1.val < head2.val) {
        dummy.next = head1;
        head1 = head1.next;
        dummy = dummy.next;
      } else {
        dummy.next = head2;
        head2 = head2.next;
        dummy = dummy.next;
      }
    }
    while (head1 != null) {
      dummy.next = head1;
      head1 = head1.next;
      dummy = dummy.next;
    }
    while (head2 != null) {
      dummy.next = head2;
      head2 = head2.next;
      dummy = dummy.next;
    }
    return head3.next;
  }
}