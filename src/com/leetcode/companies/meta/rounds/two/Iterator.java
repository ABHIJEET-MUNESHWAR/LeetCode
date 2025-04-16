package com.leetcode.companies.meta.rounds.two;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   15-04-2025
    Time:   10:26 am
*/

import java.util.PriorityQueue;

public class Iterator {
    PriorityQueue<Integer> minHeap;

    public Iterator(int[][] lists) {
        minHeap = new PriorityQueue<>();
        for (int[] list : lists) {
            for (int num : list) {
                minHeap.add(num);
            }
        }
    }

    public int next() {
        if (minHeap.isEmpty()) {
            throw new IllegalStateException("No more elements");
        }
        // Get the smallest element from the min heap
        // and remove it from the heap
        // This is the next smallest element in the merged list
        // and we can return it
        // The time complexity of this operation is O(log n)
        // where n is the number of elements in the heap
        // The space complexity of this operation is O(1)
        // because we are not using any extra space
        // to store the result
        // The overall time complexity of this operation is O(n log n)
        // where n is the total number of elements in the merged list
        if (hasNext()) {
            return minHeap.poll();
        }
        return -1;
    }

    public boolean hasNext() {
        return !minHeap.isEmpty();
    }

    public static void main(String[] args) {
        int[][] lists = new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        Iterator iterator = new Iterator(lists);
    }
}
