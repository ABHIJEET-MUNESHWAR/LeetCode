package com.leetcode.medium.array;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   18-06-2025
    Time:   02:55 pm
    🟠 2966. Divide Array Into Arrays With Max Difference
    https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/?envType=daily-question&envId=2025-06-18
*/

import com.leetcode.utils.ArrayUtils;

import java.util.Arrays;

public class DivideArray {
    public static void main(String[] args) {
        DivideArray divideArray = new DivideArray();
        int[]       nums        = new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1};
        int         k           = 2;
        ArrayUtils.printMatrix(divideArray.divideArray(nums, k));
    }

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] result = new int[n / 3][3];
        int     index  = 0;
        for (int i = 0; i < n; i += 3) {
            if ((nums[i + 2] - nums[i]) > k) {
                return new int[0][0];
            }
            result[index++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return result;
    }
}
