package com.leetcode.medium.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/07/24,
 * Time:    4:09 pm
 * 2244. Minimum Rounds to Complete All Tasks
 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
 */
public class MinimumRounds {
    public static void main(String[] args) {
        MinimumRounds minimumRounds = new MinimumRounds();
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(minimumRounds.minimumRounds(tasks));
    }

    private int minimumRounds(int[] tasks) {
        int rounds = 0;
        Map<Integer, Integer> numberToFrequencyMap = new HashMap<>();
        for (int task : tasks) {
            numberToFrequencyMap.put(task, numberToFrequencyMap.getOrDefault(task, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numberToFrequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency == 1) {
                return -1;
            }
            if (frequency % 3 == 0) {
                rounds += frequency / 3;
            } else {
                rounds += frequency / 3 + 1;
            }
        }
        return rounds;
    }
}