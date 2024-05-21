package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.ListUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/05/24,
 * Time:    7:57 am
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
  public static void main(String[] args) {
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    ListNode list1 = new ListNode(2);
    list1.next = new ListNode(4);
    list1.next.next = new ListNode(3);
    ListNode list2 = new ListNode(5);
    list2.next = new ListNode(6);
    list2.next.next = new ListNode(4);
    ListNode list3 = addTwoNumbers.addTwoNumbers(list1, list2);
    list3.printList(list3);
  }

  private ListNode addTwoNumbers(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }
    int carry = 0;
    ListNode list3 = new ListNode(-1);
    ListNode head = list3;
    while (list1 != null && list2 != null) {
      int sum = list1.val + list2.val + carry;
      carry = sum / 10;
      list3.next = new ListNode(sum % 10);
      list3 = list3.next;
      list1 = list1.next;
      list2 = list2.next;
    }
    while (list1 != null) {
      int sum = list1.val + carry;
      carry = sum / 10;
      list3.next = new ListNode(sum % 10);
      list3 = list3.next;
      list1 = list1.next;
    }
    while (list2 != null) {
      int sum = list2.val + carry;
      carry = sum / 10;
      list3.next = new ListNode(sum % 10);
      list3 = list3.next;
      list2 = list2.next;
    }
    if (carry > 0) {
      list3.next = new ListNode(carry);
    }
    return head.next;
  }
}