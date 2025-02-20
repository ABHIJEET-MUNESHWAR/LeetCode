package com.leetcode.medium.heap;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   19-02-2025
    Time:   06:31 pm
    Minimum Number of Meeting Room Required Problem in Java
    https://www.tpointtech.com/minimum-number-of-meeting-room-required-problem-in-java
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        //creating array of intervals
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);
        MeetingRoom meetingRoom = new MeetingRoom();
        System.out.println("Total number of meeting rooms required is: " + meetingRoom.getMinMeetingRooms(intervals));
    }

    private int getMinMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(intervals[0].end);
        int meetingRooms = 1;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int n = intervals.length;
        priorityQueue.add(intervals[0].end);
        for (int i = 1; i < n; i++) {
            if (intervals[i].start < priorityQueue.peek()) {
                meetingRooms++;
            } else {
                priorityQueue.poll();
            }
            priorityQueue.add(intervals[i].end);
        }
        return meetingRooms;
    }
}
