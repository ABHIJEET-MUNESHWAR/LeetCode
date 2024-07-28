package com.leetcode.hard.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/07/24,
 * Time:    9:38 pm
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays obj = new FindMedianSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(obj.findMedianSortedArraysBruteForce(nums1, nums2));
        System.out.println(obj.findMedianSortedArraysBruteForceOptimisedSpace(nums1, nums2));
    }

    private double findMedianSortedArraysBruteForceOptimisedSpace(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;
        int index1 = (size / 2) - 1;
        int element1 = -1;
        int index2 = (size / 2);
        int element2 = -1;

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (k == index1) {
                    element1 = nums1[i];
                }
                if (k == index2) {
                    element2 = nums1[i];
                }
                i++;
            } else {
                if (k == index1) {
                    element1 = nums2[j];
                }
                if (k == index2) {
                    element2 = nums2[j];
                }
                j++;
            }
            k++;
        }
        while (i < m) {
            if (k == index1) {
                element1 = nums1[i];
            }
            if (k == index2) {
                element2 = nums1[i];
            }
            i++;
            k++;
        }
        while (j < n) {
            if (k == index1) {
                element1 = nums2[j];
            }
            if (k == index2) {
                element2 = nums2[j];
            }
            j++;
            k++;
        }
        double result = 0;
        if (size % 2 == 0) {
            result = (element1 + element2) / 2.0;
        } else {
            result = element2;
        }
        return result;
    }

    private double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] nums = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums[k++] = nums1[i++];
        }
        while (j < n) {
            nums[k++] = nums2[j++];
        }
        int size = m + n;
        double result = 0;
        int mid = size / 2;
        if (size % 2 == 0) {
            result = (nums[mid] + nums[mid - 1]) / 2.0;
        } else {
            result = nums[mid];
        }
        return result;
    }
}