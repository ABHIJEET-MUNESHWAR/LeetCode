package com.leetcode.contest.weekly.four.zero.eight;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/07/24,
 * Time:    8:49 am
 * Q1. Find if Digit Game Can Be Won
 * https://leetcode.com/problems/find-if-digit-game-can-be-won/description/
 */
public class CanAliceWin {
    public static void main(String[] args) {
        CanAliceWin aliceWin = new CanAliceWin();
        //int[] nums = {1, 2, 3, 4, 10};
        //int[] nums = {1,2,3,4,5,14};
        int[] nums = {5,5,5,25};
        System.out.println(aliceWin.canAliceWin(nums));
    }

    private boolean canAliceWin(int[] nums) {
        int singleDigitSum = 0;
        int doubleDigitSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 10) {
                singleDigitSum += nums[i];
            } else {
                doubleDigitSum += nums[i];
            }
        }
        return !(singleDigitSum == doubleDigitSum);
    }
}