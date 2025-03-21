/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {  
        boolean isPalindrome = true;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
          slowPointer = slowPointer.next;
          fastPointer = fastPointer.next.next;
        }
        if (fastPointer != null) {
          slowPointer = slowPointer.next;
        }
        ListNode reverseHalf = reverseLinkedList(slowPointer);
        while (reverseHalf != null) {
          if (reverseHalf.val != head.val) {
            return false;
          }
          reverseHalf = reverseHalf.next;
          head = head.next;
        }
        return isPalindrome;
    }
    private ListNode reverseLinkedList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
          ListNode nextNode = head.next;
          head.next = newHead;
          newHead = head;
          head = nextNode;
        }
        return newHead;
    }
}