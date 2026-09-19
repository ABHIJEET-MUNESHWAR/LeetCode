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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        int carry = 0;
        ListNode list3 = new ListNode(-1);
        ListNode head = list3;
        while (list1 != null && list2 != null) {
            int sum = list1.val + list2.val + carry;
            carry = sum / 10;
            list3.next = new ListNode(sum % 10);
            list3 = list3.next;
            list1 = list1.next;
            list2 = list2.next;
        }
        while (list1 != null) {
            int sum = list1.val + carry;
            carry = sum / 10;
            list3.next = new ListNode(sum % 10);
            list3 = list3.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            int sum = list2.val + carry;
            carry = sum / 10;
            list3.next = new ListNode(sum % 10);
            list3 = list3.next;
            list2 = list2.next;
        }
        if (carry > 0) {
            list3.next = new ListNode(carry);
        }
        return head.next;
    }
}