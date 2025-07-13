package com.leetcode.medium.greedy;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   13-07-2025
    Time:   10:30 am
    🟠 2410. Maximum Matching of Players With Trainers
    https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/?envType=daily-question&envId=2025-07-13
*/

import java.util.Arrays;

public class MatchPlayersAndTrainers {
    public static void main(String[] args) {
        int[]                   players  = {4, 7, 9};
        int[]                   trainers = {8, 2, 5, 8};
        MatchPlayersAndTrainers obj      = new MatchPlayersAndTrainers();
        System.out.println(obj.matchPlayersAndTrainers(players, trainers));
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int count = 0;
        int i     = 0; // pointer for players
        int j     = 0; // pointer for trainers

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                // Match found, move both pointers
                count++;
                i++;
                j++;
            } else {
                // Current trainer can't train this player, try next trainer
                j++;
            }
        }
        return count;
    }
}
