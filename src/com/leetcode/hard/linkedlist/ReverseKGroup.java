package com.leetcode.hard.linkedlist;

import com.leetcode.utils.ListNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/07/24,
 * Time:    9:36 pm
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        head = reverseKGroup.reverseKGroup(head, k);
        head.printList(head);
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        if (count == k) {
            current = reverseKGroup(current, k);
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }
        return head;
    }
}