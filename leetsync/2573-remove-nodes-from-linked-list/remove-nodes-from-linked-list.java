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

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            if (stack.isEmpty()) {
                stack.push(current);
            } else {
                while ((!stack.isEmpty()) && (stack.peek().val < current.val)) {
                    stack.pop();
                }
                stack.push(current);
            }
            current = current.next;
        }
        while (stack.size() > 1) {
            ListNode node = stack.pop();
            stack.peek().next = node;
        }
        return stack.peek();
    }
}