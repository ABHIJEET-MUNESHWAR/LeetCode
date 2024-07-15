package com.leetcode.medium.greedy;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/07/24,
 * Time:    10:49 pm
 * 1921. Eliminate Maximum Number of Monsters
 * https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/
 */
public class EliminateMaximum {
    public static void main(String[] args) {
        EliminateMaximum eliminateMaximum = new EliminateMaximum();
        int[] dist = {1, 3, 4};
        int[] speed = {1, 1, 1};
        System.out.println(eliminateMaximum.eliminateMaximum(dist, speed));
    }

    private int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(time);
        int count = 1;
        int timePassed = 1;
        for (int i = 1; i < n; i++) {
            if ((time[i] - timePassed) <= 0) {
                return count;
            }
            count++;
            timePassed++;
        }
        return count;
    }
}