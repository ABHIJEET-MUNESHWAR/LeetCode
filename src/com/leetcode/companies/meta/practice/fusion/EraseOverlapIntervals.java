package com.leetcode.companies.meta.practice.fusion;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   13-04-2025
    Time:   09:37 pm
    435. Non-overlapping Intervals
    https://leetcode.com/problems/non-overlapping-intervals/description/
*/

import java.util.Arrays;

public class EraseOverlapIntervals {
    public static void main(String[] args) {
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Minimum number of intervals to remove: " + eraseOverlapIntervals.eraseOverlapIntervals(intervals));
    }

    private int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int remove = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
            } else {
                remove++;
            }
        }
        return remove;
    }
}
