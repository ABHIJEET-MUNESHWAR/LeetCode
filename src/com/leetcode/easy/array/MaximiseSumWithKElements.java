package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/05/23,
 * Time:    3:50 pm
 * https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/
 */
public class MaximiseSumWithKElements {
    public static void main(String[] args) {
        MaximiseSumWithKElements maximiseSumWithKElements = new MaximiseSumWithKElements();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int k = 3;
        System.out.println(maximiseSumWithKElements.maximizeSum(nums, k));
    }

    private int maximizeSum(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (max < i) {
                max = i;
            }
        }
        int i = 0;
        while (k-- > 0) {
            sum += max + i++;
        }
        return sum;
    }
}