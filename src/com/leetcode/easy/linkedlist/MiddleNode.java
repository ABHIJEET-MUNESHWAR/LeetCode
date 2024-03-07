package com.leetcode.easy.linkedlist;

import com.leetcode.utils.ListNode;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/03/24,
 * Time:    7:07 am
 * https://leetcode.com/problems/middle-of-the-linked-list/?envType=daily-question&envId=2024-03-07
 */
public class MiddleNode {
  public static void main(String[] args) {
    MiddleNode middleNode = new MiddleNode();
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    listNode.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next = new ListNode(6);
    System.out.println(middleNode.middleNode(listNode).val);
  }

  private ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}