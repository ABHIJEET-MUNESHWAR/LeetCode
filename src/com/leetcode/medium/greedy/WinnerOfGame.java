package com.leetcode.medium.greedy;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/07/24,
 * Time:    10:25 pm
 * 2038. Remove Colored Pieces if Both Neighbors are the Same Color
 * https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/
 */
public class WinnerOfGame {
    public static void main(String[] args) {
        WinnerOfGame winnerOfGame = new WinnerOfGame();
        String colors = "AAABABB";
        System.out.println(winnerOfGame.winnerOfGame(colors));
    }

    private boolean winnerOfGame(String colors) {
        int aliceCount = 0;
        int bobCount = 0;
        int n = colors.length();
        char[] chars = colors.toCharArray();
        for (int i = 1; i < n - 1; i++) {
            if (chars[i - 1] == chars[i] && chars[i] == chars[i + 1]) {
                if (chars[i] == 'A') {
                    aliceCount++;
                } else {
                    bobCount++;
                }
            }
        }
        return aliceCount > bobCount;
    }
}