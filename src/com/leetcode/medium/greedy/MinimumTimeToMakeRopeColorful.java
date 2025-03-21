package com.leetcode.medium.greedy;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/07/24,
 * Time:    2:30 pm
 * 1578. Minimum Time to Make Rope Colorful
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
 */
public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful solution = new MinimumTimeToMakeRopeColorful();
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        System.out.println(solution.minCost(colors, neededTime));
    }

    private int minCost(String colors, int[] neededTime) {
        int time = 0;
        int previousmax = 0;
        int n = colors.length();
        for (int i = 0; i < n; i++) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                previousmax = 0;
            }
            int currentTime = neededTime[i];
            // Greedily select the minimum between prevMax and curr
            time += Math.min(previousmax, currentTime);
            // Update prevMax to the maximum between prevMax and curr
            previousmax = Math.max(previousmax, currentTime);
        }
        return time;
    }
}