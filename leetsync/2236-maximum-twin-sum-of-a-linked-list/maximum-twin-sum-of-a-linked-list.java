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
    public int pairSum(ListNode head) {
        // 1. Get the mid of linked list
        ListNode mid = getMidOfList(head);
        // 2. Reverse remaining half of linked list
        ListNode tail = reverseList(mid);
        // 3. Now find the maximum pair
        return getMaxSum(head, tail);
    }

    private ListNode getMidOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private int getMaxSum(ListNode head, ListNode tail) {
        int maxSum = Integer.MIN_VALUE;
        while (head != null && tail != null) {
            maxSum = Math.max(maxSum, head.val + tail.val);
            head = head.next;
            tail = tail.next;
        }
        return maxSum;
    }
}