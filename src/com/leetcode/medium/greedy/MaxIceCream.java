package com.leetcode.medium.greedy;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/07/24,
 * Time:    4:27 pm
 * 1833. Maximum Ice Cream Bars
 * https://leetcode.com/problems/maximum-ice-cream-bars/description/
 */
public class MaxIceCream {
    public static void main(String[] args) {
        MaxIceCream maxIceCream = new MaxIceCream();
        int[] costs = {1, 3, 2, 4, 1};
        int coins = 7;
        System.out.println(maxIceCream.maxIceCream(costs, coins));
    }

    private int maxIceCream(int[] costs, int coins) {
        int result = 0;
        Arrays.sort(costs);
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            coins -= costs[i];
            if (coins < 0) {
                return result;
            }
            result++;
        }
        return result;
    }
}