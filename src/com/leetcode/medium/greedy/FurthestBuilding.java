package com.leetcode.medium.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/07/24,
 * Time:    10:07 am
 * 1642. Furthest Building You Can Reach
 * https://leetcode.com/problems/furthest-building-you-can-reach/description/
 */
public class FurthestBuilding {
    public static void main(String[] args) {
        FurthestBuilding furthestBuilding = new FurthestBuilding();
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int bricks = 5, ladders = 1;
        System.out.println(furthestBuilding.furthestBuilding(heights, bricks, ladders));
    }

    private int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }
            int diff = heights[i + 1] - heights[i];
            pq.add(diff);
            bricks -= diff;
            if (bricks < 0) {
                bricks += pq.poll();
                if (ladders > 0) {
                    ladders--;
                } else {
                    return i;
                }
            }
        }
        return n - 1;
    }
}