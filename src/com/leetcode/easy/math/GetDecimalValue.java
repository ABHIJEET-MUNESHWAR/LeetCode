package com.leetcode.easy.math;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/06/23,
 * Time:    6:34 pm
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/solutions/629087/detailed-explanation-java-faster-than-100-00/
 */
public class GetDecimalValue {
  public static void main(String[] args) {
    GetDecimalValue getDecimalValue = new GetDecimalValue();
    ListNode head = new ListNode(1);
    head.next = new ListNode(0);
    head.next.next = new ListNode(1);
    System.out.println(getDecimalValue.getDecimalValue(head));
  }

  private int getDecimalValue(ListNode head) {
    int sum = 0;
    while (head != null) {
      sum *= 2;
      sum += head.val;
      head = head.next;
    }
    return sum;
  }
}