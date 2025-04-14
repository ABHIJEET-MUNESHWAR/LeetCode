package com.leetcode.companies.meta.practice.fusion;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   13-04-2025
    Time:   09:14 pm
    https://leetcode.com/problems/meeting-rooms-ii/description/
    Meeting Rooms II
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsTwo {
    public static void main(String[] args) {
        MeetingRoomsTwo meetingRoomsTwo = new MeetingRoomsTwo();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(meetingRoomsTwo.minMeetingRooms(intervals)); // Output: 2
    }

    private int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (intervals == null || n == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> endTimeMinHeap = new PriorityQueue<>();
        endTimeMinHeap.offer(intervals[0][1]);
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            int startTime = interval[0];
            int endTime = interval[1];
            if (startTime >= endTimeMinHeap.peek()) {
                endTimeMinHeap.poll();
            }
            endTimeMinHeap.offer(endTime);
        }
        return endTimeMinHeap.size();
    }
}
