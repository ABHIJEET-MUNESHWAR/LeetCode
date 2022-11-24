package com.leetcode.easy.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    30/08/22, Time:    2:56 PM
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfLinkedLists {

  public static void main(String[] args) {
    IntersectionOfLinkedLists intersectionOfLinkedLists = new IntersectionOfLinkedLists();
    ListNode head1 = new ListNode(4);
    head1.next = new ListNode(1);
    head1.next.next = new ListNode(8);
    head1.next.next.next = new ListNode(4);
    head1.next.next.next.next = new ListNode(5);
    ListNode head2 = new ListNode(5);
    head2.next = new ListNode(6);
    head2.next.next = new ListNode(1);
    head2.next.next.next = new ListNode(8);
    head2.next.next.next.next = new ListNode(4);
    head2.next.next.next.next.next = new ListNode(5);
    ListNode intersectionNode = intersectionOfLinkedLists.getIntersectionNode(head1, head2);
    if (intersectionNode == null) {
      System.out.println("No intersection");
    } else {
      System.out.println("Intersected at " + intersectionNode.val);
    }
  }

  private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode intersectionNode = null;
    int len1 = 0;
    ListNode node1 = headA;
    while (node1 != null) {
      len1++;
      node1 = node1.next;
    }
    int len2 = 0;
    ListNode node2 = headB;
    while (node2 != null) {
      len2++;
      node2 = node2.next;
    }
    if (len1 > len2) {
      int diff = len1 - len2;
      node1 = headA;
      while (diff-- > 0) {
        node1 = node1.next;
      }
      node2 = headB;
    } else {
      int diff = len2 - len1;
      node2 = headB;
      while (diff-- > 0) {
        node2 = node2.next;
      }
      node1 = headA;
    }
    while (node1 != null && node2 != null) {
      if (node1.val == node2.val) {
        return node1;
      }
      node1 = node1.next;
      node2 = node2.next;
    }
    return intersectionNode;
  }
}