/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

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
            return new int[] { -1, -1 };
        }
        return new int[] { minDistance, previousCriticalPointIndex - firstCriticalPointIndex };
    }
}