package com.leetcode.contest.weekly.four.zero.six;

import com.leetcode.utils.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/07/24,
 * Time:    9:08 am
 * 3217. Delete Nodes From Linked List Present in Array
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/
 */
public class ModifiedList {
    public static void main(String[] args) {
        ModifiedList modifiedList = new ModifiedList();
        int[] nums = {1, 2, 3};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = modifiedList.modifiedList(nums, head);
        head.printList(head);
    }

    private ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }
}