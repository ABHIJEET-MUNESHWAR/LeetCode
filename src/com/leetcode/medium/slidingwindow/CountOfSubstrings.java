package com.leetcode.medium.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-03-2025
    Time:   02:39 pm
    3306. Count of Substrings Containing Every Vowel and K Consonants II
    https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/?envType=daily-question&envId=2025-03-10
*/

import java.util.Map;

public class CountOfSubstrings {
    public static void main(String[] args) {
        CountOfSubstrings countOfSubstrings = new CountOfSubstrings();
        String word = "aeioqq";
        int k = 1;
        System.out.println(countOfSubstrings.countOfSubstrings(word, k));
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        Map<Character, Integer> vowelToFreqMap = new HashMap<>(); // to keep count of vowels in current window

        // Preprocessing to find index of next consonant
        int[] nextConsonent = new int[n];
        int lastConsonentIndex = n;
        for (int i = n - 1; i >= 0; i--) {
            nextConsonent[i] = lastConsonentIndex;
            if (!isVowel(word.charAt(i))) {
                lastConsonentIndex = i;
            }
        }
        int left = 0, right = 0, consonentCount = 0;
        long count = 0;
        while (right < n) {
            char ch = word.charAt(right);
            if (isVowel(ch)) {
                vowelToFreqMap.put(ch, vowelToFreqMap.getOrDefault(ch, 0) + 1);
            } else {
                consonentCount++;
            }
            while (consonentCount > k) {
                char ci = word.charAt(left);
                if (isVowel(ci)) {
                    vowelToFreqMap.put(ci, vowelToFreqMap.get(ci) - 1);
                    if (vowelToFreqMap.get(ci) == 0) {
                        vowelToFreqMap.remove(ci);
                    }
                } else {
                    consonentCount--;
                }
                left++;
            }
            while (left < n && vowelToFreqMap.size() == 5 && consonentCount == k) {
                int index = nextConsonent[right];
                count += index - right;
                char ci = word.charAt(left);
                if (isVowel(ci)) {
                    vowelToFreqMap.put(ci, vowelToFreqMap.get(ci) - 1);
                    if (vowelToFreqMap.get(ci) == 0) {
                        vowelToFreqMap.remove(ci);
                    }
                } else {
                    consonentCount--;
                }
                left++;
            }
            right++;
        }
        return count;
    }
}
