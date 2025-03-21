package com.leetcode.medium.search;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/07/24,
 * Time:    7:50 am
 * 1838. Frequency of the Most Frequent Element
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
 */
public class FrequencyOfMostFrequentElement {
    public static void main(String[] args) {
        FrequencyOfMostFrequentElement frequencyOfMostFrequentElement = new FrequencyOfMostFrequentElement();
        int[] nums = {1, 4, 8, 13};
        int k = 5;
        System.out.println(frequencyOfMostFrequentElement.maxFrequencyBinarySearch(nums, k));
        System.out.println(frequencyOfMostFrequentElement.maxFrequencySlidingWindow(nums, k));
    }

    private int maxFrequencySlidingWindow(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;

        int result = 0;

        int i = 0;
        long currSum = 0;

        for (int j = 0; j < n; j++) {

            long target = nums[j];
            currSum += nums[j];

            if ((j - i + 1) * target - currSum > k) {
                currSum -= nums[i];
                i++;
            }

            result = Math.max(result, j - i + 1);

        }
        return result;
    }

    private int maxFrequencyBinarySearch(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxFrequency = 0;
        int[] prefixSumArray = new int[n];
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            prefixSumArray[i] = prefixSum;
        }
        for (int i = 0; i < n; i++) {
            maxFrequency = Math.max(maxFrequency, binarySearch(nums, k, i, prefixSumArray));
        }
        return maxFrequency;
    }

    private int binarySearch(int[] nums, int k, int targetIndex, int[] prefixSumArray) {
        int left = 0;
        int right = targetIndex;
        int result = targetIndex;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = targetIndex - mid + 1;
            long windowSum = count * nums[targetIndex];
            long currentSum = prefixSumArray[targetIndex] - prefixSumArray[mid] + nums[mid];
            int difference = (int) (windowSum - currentSum);
            if (difference > k) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return targetIndex - result + 1;
    }
}