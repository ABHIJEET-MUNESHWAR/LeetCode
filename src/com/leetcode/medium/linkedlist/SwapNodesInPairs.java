package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    16/05/23, Time:    1:10 pm
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

  public static void main(String[] args) {
    SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    ListNode swappedList = swapNodesInPairs.swapPairs(head);
    swappedList.printList(swappedList);
  }

  private ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode nextNode = head.next;
    head.next = swapPairs(head.next.next);
    nextNode.next = head;
    return nextNode;
  }

}