package com.leetcode.medium.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/07/24,
 * Time:    3:29 pm
 * 2131. Longest Palindrome by Concatenating Two Letters Words
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        LongestPalindromeByConcatenatingTwoLetterWords obj = new LongestPalindromeByConcatenatingTwoLetterWords();
        String[] words = {"ab", "ty", "yt", "lc", "cl", "ab"};
        System.out.println(obj.longestPalindrome(words));
    }

    private int longestPalindrome(String[] words) {
        Map<String, Integer> nonPaired = new HashMap<>();
        int pairs = 0, sym = 0;
        for (String w : words) {
            String reverse = new StringBuilder(w).reverse().toString();
            if (nonPaired.getOrDefault(reverse, 0) > 0) { // Find a counterpart for w among non-paired words.
                ++pairs;                                  // Increase the counter by 1.
                nonPaired.merge(reverse, -1, Integer::sum); // Decrease reverse by 1 since it has been counted in pairs.
                sym -= w.charAt(0) == w.charAt(1) ? 1 : 0; // Decrease sym by 1 since it has been counted in pairs.
            } else {
                nonPaired.merge(w, 1, Integer::sum); // Increase the occurrence of w.
                sym += w.charAt(0) == w.charAt(1) ? 1 : 0; // Increase sym by 1.
            }
        }
        return 4 * pairs + (sym > 0 ? 2 : 0);
    }
}