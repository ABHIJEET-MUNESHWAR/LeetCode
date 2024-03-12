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
    public ListNode removeZeroSumSublists(ListNode head) {

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        int prefixSum = 0;
        for (ListNode current = dummyNode; current != null; current = current.next) {
            prefixSum += current.val;
            map.put(prefixSum, current);
        }
        prefixSum = 0;
        for (ListNode current = dummyNode; current != null; current = current.next) {
            prefixSum += current.val;
            current.next = map.get(prefixSum).next;
        }
        return dummyNode.next;
    }
}