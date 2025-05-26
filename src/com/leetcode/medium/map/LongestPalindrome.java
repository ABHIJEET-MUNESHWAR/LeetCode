package com.leetcode.medium.map;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   26-05-2025
    Time:   10:31 pm
    🟠 2131. Longest Palindrome by Concatenating Two Letter Words
    https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/?envType=daily-question&envId=2025-05-25
*/

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome lp     = new LongestPalindrome();
        String[]          words  = {"lc", "cl", "gg"};
        int               result = lp.longestPalindrome(words);
        System.out.println("Longest Palindrome Length: " + result); // Output: 6
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> wordToFreqMap = new HashMap<>();
        int                  result        = 0;
        for (String word : words) {
            String reverseWord = new StringBuilder(word).reverse().toString();
            if (wordToFreqMap.getOrDefault(reverseWord, 0) > 0) {
                result += 4;
                wordToFreqMap.put(reverseWord, wordToFreqMap.get(reverseWord) - 1);
            } else {
                wordToFreqMap.put(word, wordToFreqMap.getOrDefault(word, 0) + 1);
            }
        }
        // Check for a word with both characters same to use in the center
        for (Map.Entry<String, Integer> entry : wordToFreqMap.entrySet()) {
            String word = entry.getKey();
            int    freq = entry.getValue();
            if (word.charAt(0) == word.charAt(1) && freq > 0) {
                result += 2;
                break;
            }
        }
        return result;
    }
}
