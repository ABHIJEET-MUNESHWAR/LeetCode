package com.leetcode.medium.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/07/24,
 * Time:    12:57 pm
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/
 */
public class MinDeletions {
    public static void main(String[] args) {
        MinDeletions minDeletions = new MinDeletions();
        String s = "bbcebab";
        System.out.println(minDeletions.minDeletionsUsingSet(s));
        System.out.println(minDeletions.minDeletions(s));
    }

    private int minDeletions(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int result = 0;
        int[] frequencyMap = new int[26];
        for (int i = 0; i < n; i++) {
            frequencyMap[chars[i] - 'a']++;
        }
        Arrays.sort(frequencyMap);
        for (int i = 24; i >= 0 && frequencyMap[i] > 0; i--) {
            if (frequencyMap[i] >= frequencyMap[i + 1]) {
                int previous = frequencyMap[i];
                frequencyMap[i] = Math.max(0, frequencyMap[i + 1] - 1);
                result += (previous - frequencyMap[i]);
            }
        }
        return result;
    }

    private int minDeletionsUsingSet(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] frequencyMap = new int[26];
        int result = 0;
        for (int i = 0; i < n; i++) {
            frequencyMap[chars[i] - 'a']++;
        }
        Set<Integer> frequencySet = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (frequencyMap[i] > 0 && frequencySet.contains(frequencyMap[i])) {
                frequencyMap[i]--;
                result++;
            }
            frequencySet.add(frequencyMap[i]);
        }
        return result;
    }
}