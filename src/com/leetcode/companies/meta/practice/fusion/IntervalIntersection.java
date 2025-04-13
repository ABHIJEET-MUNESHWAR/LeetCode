package com.leetcode.companies.meta.practice.fusion;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   13-04-2025
    Time:   08:41 pm
    🟠 986. Interval List Intersections
    https://leetcode.com/problems/interval-list-intersections/description/
*/

import com.leetcode.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public static void main(String[] args) {
        IntervalIntersection intervalIntersection = new IntervalIntersection();
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] result = intervalIntersection.intervalIntersection(firstList, secondList);
        ArrayUtils.printMatrix(result);
    }

    private int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int length1 = firstList.length;
        int length2 = secondList.length;
        if (firstList == null || length1 == 0 || secondList == null || length2 == 0) {
            return new int[][]{};
        }
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < length1 && j < length2) {
            int startMax = Math.max(firstList[i][0], secondList[j][0]);
            int endMin = Math.min(firstList[i][1], secondList[j][1]);
            if (endMin >= startMax) {
                result.add(new int[]{startMax, endMin});
            }
            if (firstList[i][1] == endMin) {
                i++;
            }
            if (secondList[j][1] == endMin) {
                j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
