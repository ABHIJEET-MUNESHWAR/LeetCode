package com.leetcode.medium.math;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   20-06-2025
    Time:   10:29 pm
    🟠 3443. Maximum Manhattan Distance After K Changes
    https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/description/?envType=daily-question&envId=2025-06-20
*/

public class MaxDistance {
    public static void main(String[] args) {
        MaxDistance maxDistance = new MaxDistance();
        String      s           = "NWSE";
        int         k           = 1;
        System.out.println("Maximum Manhattan Distance: " + maxDistance.maxDistance(s, k));
    }

    public int maxDistance(String s, int k) {
        int maxMd = 0;
        int east  = 0, west = 0, south = 0, north = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'E':
                    east++;
                    break;

                case 'W':
                    west++;
                    break;

                case 'N':
                    north++;
                    break;

                case 'S':
                    south++;
                    break;
            }
            int currentMd      = Math.abs(north - south) + Math.abs(east - west);
            int steps          = i + 1;
            int wasted         = steps - currentMd;
            int extra          = Math.min(2 * k, wasted);
            int finalCurrentMd = currentMd + extra;
            maxMd = Math.max(maxMd, finalCurrentMd);
        }
        return maxMd;
    }
}
