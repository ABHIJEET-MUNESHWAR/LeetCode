package com.leetcode.medium.twopointer;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   02-05-2025
    Time:   08:27 pm
    🟠 838. Push Dominoes
    https://leetcode.com/problems/push-dominoes/description/?envType=daily-question&envId=2025-05-02
*/

public class PushDominoes {
    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        String dominoes = ".L.R...LR..L..";
        String result = pushDominoes.pushDominoes(dominoes);
        System.out.println("Result: " + result);
    }

    private String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] rightClosestL = new int[n];
        int[] leftClosestR = new int[n];
        // Move right to left to find rightClosestL
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                rightClosestL[i] = i; // L starts from here
            } else if (dominoes.charAt(i) == '.') {
                rightClosestL[i] = (i < n - 1) ? rightClosestL[i + 1] : -1;
            } else {
                rightClosestL[i] = -1;
            }
        }
        // Move left to right to find leftClosestR
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                leftClosestR[i] = i; // R starts from here
            } else if (dominoes.charAt(i) == '.') {
                leftClosestR[i] = (i > 0) ? leftClosestR[i - 1] : -1;
            } else {
                leftClosestR[i] = -1;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int distRightL = rightClosestL[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - rightClosestL[i]);
            int distLeftR = leftClosestR[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - leftClosestR[i]);
            if (leftClosestR[i] == rightClosestL[i]) {
                result.append('.');
            } else if (rightClosestL[i] == -1) {
                result.append('R');
            } else if (leftClosestR[i] == -1) {
                result.append('L');
            } else if (distRightL == distLeftR) {
                result.append('.');
            } else {
                result.append(distRightL < distLeftR ? 'L' : 'R');
            }
        }
        return result.toString();
    }
}
