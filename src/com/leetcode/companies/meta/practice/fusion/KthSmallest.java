package com.leetcode.companies.meta.practice.fusion;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   14-04-2025
    Time:   02:07 pm
    🟠 378. Kth Smallest Element in a Sorted Matrix
    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
*/

public class KthSmallest {
    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println(kthSmallest.kthSmallest(matrix, k)); // Output: 13
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int countLessEqual(int[][] matrix, int k) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= k) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
