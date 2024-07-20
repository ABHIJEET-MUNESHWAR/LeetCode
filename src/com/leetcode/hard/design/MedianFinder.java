package com.leetcode.hard.design;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/07/24,
 * Time:    12:07 am
 * 295. Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class MedianFinder {

    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }
        // always maintain leftMaxHeap size one greater than rightMinHeap size
        // or both sizes equal
        if ((leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }
        return leftMaxHeap.peek();
    }
}