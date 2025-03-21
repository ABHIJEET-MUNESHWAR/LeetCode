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
    public ListNode removeNodes(ListNode head) {
        ListNode tail = reverseList(head);
        ListNode current = tail;
        // 5, 2, 13, 3, 8
        // 8, 3, 13, 2, 5
        int max = current.val;
        while (current.next != null) {
            if (max > current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
                max = current.val;
            }
        }
        return reverseList(tail);
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}