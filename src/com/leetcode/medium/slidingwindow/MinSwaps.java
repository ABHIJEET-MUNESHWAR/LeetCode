package com.leetcode.medium.slidingwindow;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/08/24,
 * Time:    11:02 pm
 * 2134. Minimum Swaps to Group All 1's Together II
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/description/?envType=daily-question&envId=2024-08-02
 */
public class MinSwaps {
    public static void main(String[] args) {
        MinSwaps minSwaps = new MinSwaps();
        //int[] nums = {0, 1, 0, 1, 1, 0, 0};
        //int[] nums = {0, 1, 1, 1, 0, 0, 1, 1, 0};
        //int[] nums = {1, 1, 0, 0, 1};
        int[] nums = {1};
        System.out.println(minSwaps.minSwaps(nums));
    }

    private int minSwaps(int[] nums) {
        int n = nums.length;
        int maxOnce = 0;
        for (int num : nums) {
            maxOnce += num;
        }
        int left = 0, right = 0, currentOnce = 0, currentMaxOnce = 0;
        while (right < 2 * n) {
            if (nums[right % n] == 1) {
                currentOnce++;
            }
            int currentWindowSize = right - left + 1;
            if (currentWindowSize > maxOnce) {
                currentOnce -= nums[left % n];
                left++;
            }

            currentMaxOnce = Math.max(currentMaxOnce, currentOnce);
            right++;
        }
        return maxOnce - currentMaxOnce;
    }
}