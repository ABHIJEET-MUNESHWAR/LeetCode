package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.ListUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/04/24,
 * Time:    7:21 am
 * https://leetcode.com/problems/merge-in-between-linked-lists/?envType=daily-question&envId=2024-03-20
 */
public class MergeInBetween {
  public static void main(String[] args) {
    MergeInBetween mergeInBetween = new MergeInBetween();
    ListNode list1 = new ListNode(10);
    list1.next = new ListNode(1);
    list1.next.next = new ListNode(13);
    list1.next.next.next = new ListNode(6);
    list1.next.next.next.next = new ListNode(9);
    list1.next.next.next.next.next = new ListNode(5);
    ListNode list2 = new ListNode(1000000);
    list2.next = new ListNode(1000001);
    list2.next.next = new ListNode(1000002);
    int a = 3, b = 4;
    ListNode list3 = mergeInBetween(list1, list2, a, b);
    list3.printList(list3);
  }

  private static ListNode mergeInBetween(ListNode list1, ListNode list2, int a, int b) {
    ListNode start = list1;
    for (int i = 1; i < a; i++) {
      start = start.next;
    }
    ListNode end = start;
    for (int i = a; i <= b; i++) {
      end = end.next;
    }
    start.next = list2;
    while (list2.next != null) {
      list2 = list2.next;
    }
    list2.next = end.next;
    return list1;
  }
}