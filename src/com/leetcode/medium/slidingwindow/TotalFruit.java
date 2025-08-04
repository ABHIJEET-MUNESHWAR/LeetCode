package com.leetcode.medium.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   04-08-2025
    Time:   06:03 pm
    🟠 904. Fruit Into Baskets
    https://leetcode.com/problems/fruit-into-baskets/description/?envType=daily-question&envId=2025-08-04
*/

import java.util.HashMap;

public class TotalFruit {
    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        int[]      fruits     = {1, 2, 1};
        System.out.println(totalFruit.totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        int                       n                = fruits.length;
        HashMap<Integer, Integer> fruitTypeToNoMap = new HashMap<>();
        int                       left             = 0, right = 0, maxCount = 0;
        while (right < n) {
            // Add the fruit at the right pointer to the map
            fruitTypeToNoMap.put(fruits[right], fruitTypeToNoMap.getOrDefault(fruits[right], 0) + 1);
            // While more than 2 types of fruits are in the map, move the left pointer
            if (fruitTypeToNoMap.size() > 2) {
                fruitTypeToNoMap.put(fruits[left], fruitTypeToNoMap.get(fruits[left]) - 1);
                if (fruitTypeToNoMap.get(fruits[left]) == 0) {
                    fruitTypeToNoMap.remove(fruits[left]);
                }
                left++; // Move the left pointer to the right
            }
            // Calculate the maximum count of fruits collected
            maxCount = Math.max(maxCount, right - left + 1);
            // Move the right pointer to the right
            right++;
        }
        return maxCount;
    }
}
