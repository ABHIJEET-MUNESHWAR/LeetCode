package com.leetcode.medium.greedy;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/07/24,
 * Time:    10:46 am
 * 3085. Minimum Deletions to Make String K-Special
 * https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/
 */
public class MinimumDeletions {
    public static void main(String[] args) {
        MinimumDeletions minimumDeletions = new MinimumDeletions();
        String word = "aabcaba";
        int k = 0;
        System.out.println(minimumDeletions.minimumDeletions(word, k));
        System.out.println(minimumDeletions.minimumDeletionsOptimised(word, k));
    }

    private int minimumDeletionsOptimised(String word, int k) {
        int n = word.length();
        int result = n;
        int[] letterFrequency = new int[26];
        for (int i = 0; i < n; i++) {
            letterFrequency[word.charAt(i) - 'a']++;
        }
        Arrays.sort(letterFrequency);
        int cumulativeDeleted = 0;
        for (int i = 0; i < 26; i++) {
            int minimumFrequency = letterFrequency[i];
            int temp = cumulativeDeleted;
            for (int j = 25; j > i; j--) {
                int diff = letterFrequency[j] - letterFrequency[i];
                if (diff <= k) {
                    break;
                }
                temp += letterFrequency[j] - minimumFrequency - k;
            }
            result = Math.min(result, temp);
            cumulativeDeleted += minimumFrequency;
        }
        return result;
    }

    private int minimumDeletions(String word, int k) {
        int n = word.length();
        int result = n;
        int[] letterFrequency = new int[26];
        for (int i = 0; i < n; i++) {
            letterFrequency[word.charAt(i) - 'a']++;
        }
        Arrays.sort(letterFrequency);
        int cumulativeDeleted = 0;
        for (int i = 0; i < 26; i++) {
            int deleted = cumulativeDeleted;
            for (int j = 25; j >= 0; j--) {
                int diff = letterFrequency[j] - letterFrequency[i];
                if (diff <= k) {
                    break;
                }
                deleted += diff - k;
            }
            result = Math.min(result, deleted);
            cumulativeDeleted += letterFrequency[i];
        }
        return result;
    }
}