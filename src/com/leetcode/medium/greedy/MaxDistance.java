package com.leetcode.medium.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/08/24,
 * Time:    7:13 pm
 * 624. Maximum Distance in Arrays
 * https://leetcode.com/problems/maximum-distance-in-arrays/description/
 */
public class MaxDistance {
    public static void main(String[] args) {
        MaxDistance maxDistance = new MaxDistance();
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 2, 3));
        arrays.add(Arrays.asList(4, 5));
        arrays.add(Arrays.asList(1, 2, 3));
        System.out.println(maxDistance.maxDistance(arrays));
    }

    private int maxDistance(List<List<Integer>> arrays) {
        int maxDiff = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int n = arrays.size();
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, arrays.get(i).get(arrays.get(i).size() - 1) - min);
            maxDiff = Math.max(maxDiff, max - arrays.get(i).get(0));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return maxDiff;
    }
}