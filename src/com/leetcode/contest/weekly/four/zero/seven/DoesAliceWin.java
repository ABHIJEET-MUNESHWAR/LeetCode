package com.leetcode.contest.weekly.four.zero.seven;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/07/24,
 * Time:    8:45 am
 * 100335. Vowels Game in a String
 * https://leetcode.com/contest/weekly-contest-407/problems/vowels-game-in-a-string/description/
 */
public class DoesAliceWin {
    public static void main(String[] args) {
        DoesAliceWin doesAliceWin = new DoesAliceWin();
        String s = "leetcoder";
        System.out.println(doesAliceWin.doesAliceWin(s));
    }

    private boolean doesAliceWin(String s) {
        int n = s.length();
        int vowels = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowels++;
            }
        }
        if (vowels == 0) {
            return false;
        }
        return true;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}