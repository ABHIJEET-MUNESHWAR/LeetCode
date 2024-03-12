package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/03/24,
 * Time:    7:12 am
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/?envType=daily-question&envId=2024-03-12
 */
public class RemoveZeroSumSublists {
  public static void main(String[] args) {
    RemoveZeroSumSublists removeZeroSumSublists = new RemoveZeroSumSublists();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(-3);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(1);
    head = removeZeroSumSublists.removeZeroSumSublists(head);
    head.printList(head);
  }

  private ListNode removeZeroSumSublists(ListNode head) {
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;
    int prefixSum = 0;
    for (ListNode current = dummyNode; current != null; current = current.next) {
      prefixSum += current.val;
      map.put(prefixSum, current);
    }
    prefixSum = 0;
    for (ListNode current = dummyNode; current != null; current = current.next) {
      prefixSum += current.val;
      current.next = map.get(prefixSum).next;
    }
    return dummyNode.next;
  }
}