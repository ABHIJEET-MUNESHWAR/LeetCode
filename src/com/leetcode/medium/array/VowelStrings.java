package com.leetcode.medium.array;


/*
Created using IntelliJ IDEA
Author: Abhijeet Ashok Muneshwar
Date: 02-01-2025
Time: 09:18 pm
2559. Count Vowel Strings in Ranges
https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02
*/

import com.leetcode.utils.ArrayUtils;

public class VowelStrings {
    public static void main(String[] args) {
        VowelStrings vowelStrings = new VowelStrings();
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        ArrayUtils.printArray(vowelStrings.vowelStrings(words, queries));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int wordsLen = words.length;
        int[] prefixArray = new int[wordsLen];
        int sum = 0;
        for (int i = 0; i < wordsLen; i++) {
            String word = words[i];
            if (isWordStartEndWithVowel(word)) {
                sum++;
            }
            prefixArray[i] = sum;
        }
        int queriesLen = queries.length;
        int[] result = new int[queriesLen];
        for (int i = 0; i < queriesLen; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = prefixArray[r] - (l > 0 ? prefixArray[l - 1] : 0);
        }
        return result;
    }

    public boolean isWordStartEndWithVowel(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowel(first) && isVowel(last);
    }

    private boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }
}
