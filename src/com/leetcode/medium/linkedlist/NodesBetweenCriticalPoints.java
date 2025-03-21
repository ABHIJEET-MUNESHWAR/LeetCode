package com.leetcode.medium.linkedlist;

import com.leetcode.utils.ArrayUtils;
import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/07/24,
 * Time:    7:46 am
 * 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/?envType=daily-question&envId=2024-07-05
 */
public class NodesBetweenCriticalPoints {
  public static void main(String[] args) {
    NodesBetweenCriticalPoints nodesBetweenCriticalPoints = new NodesBetweenCriticalPoints();
    ListNode head = new ListNode(5);
    head.next = new ListNode(3);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(1);
    head.next.next.next.next.next.next = new ListNode(2);
    ArrayUtils.printArray(nodesBetweenCriticalPoints.nodesBetweenCriticalPoints(head));
  }

  private int[] nodesBetweenCriticalPoints(ListNode head) {
    ListNode current = head.next;
    ListNode previous = head;
    int minDistance = Integer.MAX_VALUE;
    int firstCriticalPointIndex = 0, currentCriticalPointIndex = 0, previousCriticalPointIndex = 0;
    for (int i = 1; current.next != null; i++) {
      if ((previous.val < current.val && current.val > current.next.val)
          || (previous.val > current.val && current.val < current.next.val)) {
        if (previousCriticalPointIndex == 0) {
          firstCriticalPointIndex = i;
        } else {
          minDistance = Math.min(minDistance, i - previousCriticalPointIndex);
        }
        previousCriticalPointIndex = i;
      }
      previous = current;
      current = current.next;
    }
    if (minDistance == Integer.MAX_VALUE) {
      return new int[] {-1, -1};
    }
    return new int[] {minDistance, previousCriticalPointIndex - firstCriticalPointIndex};
  }
}