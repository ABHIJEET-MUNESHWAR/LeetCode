package com.leetcode.medium.search;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   28-02-2025
    Time:   10:31 am
    https://leetcode.com/problems/strings-differ-by-one-character/description/
    1554. Strings Differ by One Character
*/

import java.util.HashSet;
import java.util.Set;

public class DifferByOne {
    public static void main(String[] args) {
        DifferByOne differByOne = new DifferByOne();
        String[] dict = {"abcd","cccc","abyd","abab"};
        System.out.println(differByOne.differByOne(dict));
    }

    private boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String word : dict) {
            int wordLength = word.length();
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                if (set.contains(newWord)) {
                    return true;
                }
                set.add(newWord);
            }
        }
        return false;
    }
}
