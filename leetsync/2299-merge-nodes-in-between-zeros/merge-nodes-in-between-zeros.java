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

        ListNode dummyHead = new ListNode(0);
        ListNode dummyHeadIterator = dummyHead;
        ListNode current = head.next;
        int sum = 0;
        while (current != null) {
            sum += current.val;
            if (current.val == 0) {
                ListNode node = new ListNode(sum);
                if (dummyHeadIterator == null) {
                    dummyHeadIterator = node;
                } else {
                    dummyHeadIterator.next = node;
                    dummyHeadIterator = dummyHeadIterator.next;
                }
                sum = 0;
            }
            current = current.next;
        }
        return dummyHead.next;
    }
}