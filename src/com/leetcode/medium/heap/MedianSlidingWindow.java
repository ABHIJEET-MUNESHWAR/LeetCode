package com.leetcode.medium.heap;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   13-04-2025
    Time:   05:31 pm
*/

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

public class MedianSlidingWindow {
    public static void main(String[] args) {
        MedianSlidingWindow medianSlidingWindow = new MedianSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] result = medianSlidingWindow.medianSlidingWindow(nums, k);
        for (double num : result) {
            System.out.print(num + " ");
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);

        Supplier<Double> median = (k % 2 == 0) ? () -> ((double) nums[left.first()] + nums[right.first()]) / 2
                : () -> (double) nums[right.first()];

        // balance lefts size and rights size (if not equal then right will be larger by one)
        Runnable balance = () -> {
            while (left.size() > right.size())
                right.add(left.pollFirst());
        };

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            left.add(i);
        }
        balance.run();
        result[0] = median.get();

        for (int i = k, r = 1; i < nums.length; i++, r++) {
            // remove tail of window from either left or right
            if (!left.remove(i - k))
                right.remove(i - k);

            // add next num, this will always increase left size
            right.add(i);
            left.add(right.pollFirst());

            // rebalance left and right, then get median from them
            balance.run();
            result[r] = median.get();
        }

        return result;
    }
}
