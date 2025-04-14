package com.leetcode.medium.linkedlist;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   14-04-2025
    Time:   10:49 am
    23. Merge k Sorted Lists
    https://leetcode.com/problems/merge-k-sorted-lists/description/
*/

import com.leetcode.utils.ListNode;

public class MergeKLists {
    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        ListNode mergedList = mergeKLists.mergeKLists(lists);
        mergedList.printList(mergedList);
    }

    public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoSortedLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoSortedLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode partitionAndMerge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = partitionAndMerge(lists, start, mid);
        ListNode right = partitionAndMerge(lists, mid + 1, end);
        return mergeTwoSortedLists(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return partitionAndMerge(lists, 0, lists.length - 1);
    }
}
