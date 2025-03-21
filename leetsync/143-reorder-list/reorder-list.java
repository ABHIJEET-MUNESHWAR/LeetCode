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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // 1. Find Mid of Linked List
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;

        // 2. Detach the 2 linked lists
        slow.next = null;

        // 3. Reverse 2nd half of Linked List
        ListNode previous = null;
        ListNode current = secondHead;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        // 4. Start reorder 1 by 1
        ListNode l1 = head;
        ListNode l2 = previous;
        while (l2 != null) {
            ListNode m1 = l1.next;
            ListNode m2 = l2.next;
            l1.next = l2;
            l2.next = m1;
            l1 = m1;
            l2 = m2;
        }
    }
}