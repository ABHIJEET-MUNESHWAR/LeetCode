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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), prev = dummy;
        while (head != null && head.next != null) {
            prev.next = head; // prev connects next 0 node.
            head = head.next; // head forward to a non-zero node.
            while (head != null && head.val != 0) { // traverse all non-zero nodes between two zero nodes.
                prev.next.val += head.val; // add current value to the previous zero node.
                head = head.next; // forward one step.
            }
            prev = prev.next; // prev point to the summation node (initially 0).
        }
        prev.next = null; // cut off last 0 node.
        return dummy.next;
    }
}