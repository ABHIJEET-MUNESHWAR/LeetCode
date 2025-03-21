package com.leetcode.medium.greedy;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/07/24,
 * Time:    3:54 pm
 * 2279. Maximum Bags With Full Capacity of Rocks
 * https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/
 */
public class MaximumBags {
    public static void main(String[] args) {
        MaximumBags maximumBags = new MaximumBags();
        int[] capacity = {91, 54, 63, 99, 24, 45, 78};
        int[] rocks = {35, 32, 45, 98, 6, 1, 25};
        int additionalRocks = 17;
        System.out.println(maximumBags.maximumBags(capacity, rocks, additionalRocks));
    }

    private int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] difference = new int[n];
        for (int i = 0; i < n; i++) {
            difference[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(difference);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (additionalRocks >= difference[i]) {
                additionalRocks -= difference[i];
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}