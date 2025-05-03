package com.leetcode.medium.greedy;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   03-05-2025
    Time:   09:51 pm
    🟠 1007. Minimum Domino Rotations For Equal Row
    https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/?envType=daily-question&envId=2025-05-03
*/

public class MinDominoRotations {
    public static void main(String[] args) {
        MinDominoRotations minDominoRotations = new MinDominoRotations();
        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};
        int result = minDominoRotations.minDominoRotations(tops, bottoms);
        System.out.println("Result: " + result);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = Integer.MAX_VALUE;
        for (int val = 1; val <= 6; val++) {
            int swaps = find(tops, bottoms, val);
            if (swaps != -1) {
                result = Math.min(result, swaps);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int find(int[] tops, int[] bottoms, int val) {
        int n = tops.length;
        int swapTop = 0;
        int swapBottom = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != val && bottoms[i] != val) {
                return -1;
            } else if (tops[i] != val) {
                swapTop++;
            } else if (bottoms[i] != val) {
                swapBottom++;
            }
        }
        return Math.min(swapTop, swapBottom);
    }
}
