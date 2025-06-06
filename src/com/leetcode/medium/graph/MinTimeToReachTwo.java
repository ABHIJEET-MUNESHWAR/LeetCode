package com.leetcode.medium.graph;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   08-05-2025
    Time:   10:23 am
    🟠 3342. Find Minimum Time to Reach Last Room II
    https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/description/?envType=daily-question&envId=2025-05-08
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinTimeToReachTwo {
    public static void main(String[] args) {
        MinTimeToReachTwo minTimeToReachTwo = new MinTimeToReachTwo();
        int[][] moveTime = {{0, 4}, {4, 4}};
        System.out.println(minTimeToReachTwo.minTimeToReach(moveTime));
    }

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        result[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] currentCell = pq.poll();
            int currentTime = currentCell[0];
            int i = currentCell[1];
            int j = currentCell[2];
            if (i == m - 1 && j == n - 1) {
                return currentTime;
            }
            for (int[] direction : directions) {
                int i_ = i + direction[0];
                int j_ = j + direction[1];
                if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n) {
                    int wait = Math.max(0, moveTime[i_][j_] - currentTime);
                    int moveCost = (i_ + j_) % 2 == 0 ? 2 : 1;
                    int arriveTime = currentTime + wait + moveCost;
                    if (result[i_][j_] > arriveTime) {
                        result[i_][j_] = arriveTime;
                        pq.offer(new int[]{arriveTime, i_, j_});
                    }
                }
            }
        }
        return -1;
    }
}
