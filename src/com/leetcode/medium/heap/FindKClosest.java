package com.leetcode.medium.heap;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   13-04-2025
    Time:   03:46 pm
    973. K Closest Points to Origin
    https://leetcode.com/problems/k-closest-points-to-origin/description/
*/

import com.leetcode.utils.ArrayUtils;

import java.util.PriorityQueue;

public class FindKClosest {
    public static void main(String[] args) {
        FindKClosest findKClosest = new FindKClosest();
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int k = 1;
        ArrayUtils.printMatrix(findKClosest.kClosest(points, k)); // Output: [[-2,2]]
    }

    private int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap
                = new PriorityQueue<>((x, y)
                -> (x[0] * x[0] + x[1] * x[1]) - (y[0] * y[0] + y[1] * y[1]));
        int[][] result = new int[k][2];
        for (int[] point : points) {
            minHeap.offer(point);
        }
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
