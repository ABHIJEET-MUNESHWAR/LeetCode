package com.leetcode.contest.biweekly.onethreefive;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/07/24,
 * Time:    8:00 pm
 * 100375. Find the Winning Player in Coin Game
 * https://leetcode.com/problems/find-the-winning-player-in-coin-game/description/
 */
public class LosingPlayer {
    public static void main(String[] args) {
        LosingPlayer losingPlayer = new LosingPlayer();
        //int x = 2, y = 7;
        //int x = 4, y = 11;
        //int x = 1, y = 4;
        int x = 1, y = 1;
        System.out.println(losingPlayer.losingPlayer(x, y));
    }

    private String losingPlayer(int x, int y) {
        int iterations = 0;
        while (x > 0 && y > 3) {
            x--;
            y -= 4;
            iterations++;
        }
        return iterations % 2 == 1 ? "Alice" : "Bob";
    }
}