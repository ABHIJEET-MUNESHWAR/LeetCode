package com.leetcode.easy.math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/08/24,
 * Time:    10:38 am
 * 3014. Minimum Number of Pushes to Type Word I
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/
 */
public class MinimumPushes {
    public static void main(String[] args) {
        MinimumPushes minimumPushes = new MinimumPushes();
        String word = "abcde";
        System.out.println(minimumPushes.minimumPushes(word));
    }

    private int minimumPushes(String word) {
        int n = word.length();
        int result = 0;
        int[] letterToFrequencyMap = new int[26];
        for (int i = 0; i < n; i++) {
            letterToFrequencyMap[word.charAt(i) - 'a']++;
        }
        Integer[] mpInteger = Arrays.stream(letterToFrequencyMap).boxed().toArray(Integer[]::new);
        Arrays.sort(mpInteger, Comparator.reverseOrder());
        for (int i = 0; i < 26; i++) {
            int frequency = mpInteger[i];
            int press = (i / 8) + 1;
            result += frequency * press;
        }
        return result;
    }
}