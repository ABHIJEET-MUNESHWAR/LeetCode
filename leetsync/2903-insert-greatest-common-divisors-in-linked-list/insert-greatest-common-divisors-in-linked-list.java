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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int a = 0, b = 0;
        ListNode current = head;
        while (current.next != null) {
            a = current.val;
            b = current.next.val;
            ListNode gcdNode = new ListNode(gcd(a, b));
            gcdNode.next = current.next;
            current.next = gcdNode;
            current = gcdNode.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        } else {
            return a;
        }
    }
}