package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    15/05/23, Time:    3:36 pm
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */
public class SwapNodes {

  public static void main(String[] args) {
    SwapNodes swapNodes = new SwapNodes();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNode swappedList = swapNodes.swapNodes(head, 5);
    swappedList.printList(swappedList);
  }

  private ListNode swapNodes(ListNode head, int k) {
    ListNode first = head, second = head;
    ListNode curr = head;
    int i = 1;
    while (curr != null) {
      curr = curr.next;
      i++;
      if (i == k) {
        first = curr;
        break;
      }
    }
    int size = 0;
    curr = head;
    while (curr != null) {
      curr = curr.next;
      size++;
    }
    int secondPosition = size - k + 1;
    curr = head;
    i = 1;
    while (curr != null) {
      curr = curr.next;
      i++;
      if (i == secondPosition) {
        second = curr;
      }
    }
    int t = first.val;
    first.val = second.val;
    second.val = t;
    return head;
  }
}